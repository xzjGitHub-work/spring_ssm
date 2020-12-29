package com.myself.domain;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ContractProductVo implements Serializable {

    /**
     * 客户名称
     */
    private String customName;
    /**
     * 合同号，订单号
     */
    private String contractNo;
    /**
     * 货号
     */
    private String productNo;
    /**
     * 数量
     */
    private Integer cnumber;
    /**
     * 厂家名称，冗余字段
     */
    private String factoryName;
    /**
     * 交货期限
     */
    private Date deliveryPeriod;
    /**
     * 有效期
     */
    private Date shipTime;
    /**
     * 贸易条款
     */
    private String tradeTerms;

}
