package com.test.util;

import org.apache.commons.collections4.MapUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Description: 判断参数是否为空
 * @Author: xzj
 * @CreateDate: 2021/4/16 16:04
 */
public class EmptyUtil {
    public boolean isBlanke(Object ...o){
        if (null == o){
            return true;
        }
        for (Object obj : o) {
            if (obj instanceof  String && StringUtils.isEmpty(obj)){
                return true;
            }
            if (obj instanceof Collection && CollectionUtils.isEmpty((Collection<?>)obj)){
                return true;
            }
            if (obj instanceof Map && MapUtils.isEmpty((Map)obj)){
                return true;
            }
        }
        return false;

    }
}
