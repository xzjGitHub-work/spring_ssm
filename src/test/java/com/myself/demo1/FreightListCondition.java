package com.myself.demo1;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 类描述： freight_list表实体
 * @author CaoXueJia
 * @createDate 2020/4/13 11:01
 */
@Data
public class FreightListCondition{

    private static final long serialVersionUID = 3435537147141389047L;
    /**
     * 主键
     */
    private Integer id;

    /**
     * 货主名称
     */
    private String ownerName;

    /**
     * 平台
     */
    private String targetPlatform;

    /**
     * 渠道
     */
    private String channel;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 运单号
     */
    private String waybillNo;

    /**
     * 子单号
     */
    private String childNos;

    /**
     * 运单类型  1：清单 2：回单
     */
    private String waybillType;

    /**
     * 月结账号
     */
    private String customerAcctCode;

    /**
     * 计费重量
     */
    private String meterageWeightQty;

    /**
     * 体积
     */
    private String volume;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 包裹数
     */
    private String quantity;

    /**
     * 标准价
     */
    private String feeAmt;

    /**
     * 应付折扣
     */
    private String payDiscount;

    /**
     * 应付价格
     */
    private String payPrice;

    /**
     * 应收折扣
     */
    private String receiveDiscount;

    /**
     * 应收价格
     */
    private String receivePrice;

    /**
     * 费用类型：1主运费，2其他费用，3保费，4代收货款服务费，5代收货款
     */
    private String feeTypeCode;

    /**
     * 支付方式：1 寄付 2 到付 3 第三方付
     */
    private String paymentTypeCode;

    /**
     * 日期
     */
    private Date generateDate;

    /**
     * 发货人姓名
     */
    private String consignorName;

    /**
     * 发货人电话
     */
    private String consignorTel;

    /**
     * 发货地
     */
    private String deliverPlace;

    /**
     * 收货人姓名
     */
    private String receiverName;

    /**
     * 收货人电话
     */
    private String receiverTel;

    /**
     * 收货地
     */
    private String receivePlace;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改人
     */
    private String modifier;

    /**
     * 修改时间
     */
    private Date modifyTime;

    /**
     * 开始时间
     */
    private String beginTimeStr;

    /**
     * 结束时间
     */
    private String endTimeStr;

    /**
     * 主键字符串
     */
    private String idStr;

    /**
     * 主键集合
     */
    private List<Integer> idList;

    /**
     * 公司编号
     */
    private String companyCode;

    /**
     * 供应商名称
     */
    private String supplierName;

    /**
     * 供应商编号
     */
    private String supplierCode;

    /**
     * 所属业务类型（00:国网物流；01:询报价）
     */
    private String businessType;

    /**
     * 推送状态 （00:已推送 01:未推送 02:推送失败）
     */
    private String pushStatus;

}
