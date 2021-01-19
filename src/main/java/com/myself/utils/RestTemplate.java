package com.myself.utils;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.GenericHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import org.springframework.web.client.*;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description: 作用描述
 * @Author: xzj
 * @CreateDate: 2021/1/15 9:09
 */
public class RestTemplate {
    private final List<HttpMessageConverter<?>> messageConverters = null;

    public <T> T getForObject(URI url, Class<T> responseType) throws RestClientException {
        RequestCallback requestCallback = this.acceptHeaderRequestCallback(responseType);
        HttpMessageConverterExtractor<T> responseExtractor = new HttpMessageConverterExtractor(responseType, this.getMessageConverters());
        return this.execute(url, HttpMethod.GET, requestCallback, responseExtractor);
    }

    public <T> T execute(URI url, HttpMethod method, @Nullable RequestCallback requestCallback, @Nullable ResponseExtractor<T> responseExtractor) throws RestClientException {
        return this.doExecute(url, method, requestCallback, responseExtractor);
    }

    //    protected <T> T doExecute(URI url, @Nullable HttpMethod method, @Nullable RequestCallback requestCallback, @Nullable ResponseExtractor<T> responseExtractor) throws RestClientException {
    protected <T> T doExecute(URI url, @Nullable HttpMethod method, @Nullable RequestCallback requestCallback, @Nullable ResponseExtractor<T> responseExtractor) throws RestClientException {
        Assert.notNull(url, "URI is required");
        Assert.notNull(method, "HttpMethod is required");
        ClientHttpResponse response = null;

        Object var14;
        try {
            ClientHttpRequest request = this.createRequest(url, method);
            if (requestCallback != null) {
                requestCallback.doWithRequest(request);
            }

            response = request.execute();
            this.handleResponse(url, method, response);
            var14 = responseExtractor != null ? responseExtractor.extractData(response) : null;
        } catch (IOException var12) {
            String resource = url.toString();
            String query = url.getRawQuery();
            resource = query != null ? resource.substring(0, resource.indexOf(63)) : resource;
            throw new ResourceAccessException("I/O error on " + method.name() + " request for \"" + resource + "\": " + var12.getMessage(), var12);
        } finally {
            if (response != null) {
                response.close();
            }

        }
        return null;
//        return var14;
    }


    protected void handleResponse(URI url, HttpMethod method, ClientHttpResponse response) throws IOException {
        ResponseErrorHandler errorHandler = this.getErrorHandler();
        boolean hasError = errorHandler.hasError(response);
//        if (this.logger.isDebugEnabled()) {
//            try {
//                int code = response.getRawStatusCode();
//                HttpStatus status = HttpStatus.resolve(code);
//                this.logger.debug("Response " + (status != null ? status : code));
//            } catch (IOException var8) {
//            }
//        }

        if (hasError) {
            errorHandler.handleError(url, method, response);
        }

    }

    private ResponseErrorHandler errorHandler;

    public ResponseErrorHandler getErrorHandler() {
        return this.errorHandler;
    }

    protected ClientHttpRequest createRequest(URI url, HttpMethod method) throws IOException {
        ClientHttpRequest request = this.getRequestFactory().createRequest(url, method);
//        if (this.logger.isDebugEnabled()) {
//            this.logger.debug("HTTP " + method.name() + " " + url);
//        }

        return request;
    }

    private ClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();

    public ClientHttpRequestFactory getRequestFactory() {
        return this.requestFactory;
    }

    public <T> RequestCallback acceptHeaderRequestCallback(Class<T> responseType) {
        return new AcceptHeaderRequestCallback(responseType);
    }

    public List<HttpMessageConverter<?>> getMessageConverters() {
        return this.messageConverters;
    }

    private class AcceptHeaderRequestCallback implements RequestCallback {
        @Nullable
        private final Type responseType;

        public AcceptHeaderRequestCallback(@Nullable Type responseType) {
            this.responseType = responseType;
        }

        public void doWithRequest(ClientHttpRequest request) throws IOException {
            if (this.responseType != null) {
                List<MediaType> allSupportedMediaTypes = (List) getMessageConverters().stream().filter((converter) -> {
                    return this.canReadResponse(this.responseType, converter);
                }).flatMap(this::getSupportedMediaTypes).distinct().sorted(MediaType.SPECIFICITY_COMPARATOR).collect(Collectors.toList());
//                if (this.logger.isDebugEnabled()) {
//                    this.logger.debug("Accept=" + allSupportedMediaTypes);
//                }

                request.getHeaders().setAccept(allSupportedMediaTypes);
            }

        }

        private boolean canReadResponse(Type responseType, HttpMessageConverter<?> converter) {
            Class<?> responseClass = responseType instanceof Class ? (Class) responseType : null;
            if (responseClass != null) {
                return converter.canRead(responseClass, (MediaType) null);
            } else if (converter instanceof GenericHttpMessageConverter) {
                GenericHttpMessageConverter<?> genericConverter = (GenericHttpMessageConverter) converter;
                return genericConverter.canRead(responseType, (Class) null, (MediaType) null);
            } else {
                return false;
            }
        }

        private Stream<MediaType> getSupportedMediaTypes(HttpMessageConverter<?> messageConverter) {
            return messageConverter.getSupportedMediaTypes().stream().map((mediaType) -> {
                return mediaType.getCharset() != null ? new MediaType(mediaType.getType(), mediaType.getSubtype()) : mediaType;
            });
        }
    }
}
