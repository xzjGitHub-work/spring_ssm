package com.test.demo01;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public abstract class AbstractAuditIpp{
    /**
     * 
     */
    private static final long serialVersionUID = -4387459190012165612L;

    private Serializable creator;
    private Date createTime;
    private Serializable modifier;
    private Date modifyTime;
    private Serializable deleteBy;
    private Date deleteTime;
    private String deleteFlag;

}
