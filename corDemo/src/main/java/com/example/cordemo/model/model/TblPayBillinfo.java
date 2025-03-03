package com.example.cordemo.model.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDate;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author lch
 * @since 2025-03-04
 */
@Getter
@Setter
@TableName("tbl_pay_billinfo")
@Data
public class TblPayBillinfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 该日期截取自支付订单号的日期位
     */
    @TableField("DATE_SSN")
    private LocalDate dateSsn;

    @TableField("SSN_PLT")
    private String ssnPlt;

    /**
     * 可支持5层子订单，每3位为一层
     */
    @TableField("SUB_SEQ")
    private Short subSeq;

    /**
     * 业务支付订单唯一标识
     */
    @TableField("ORDER_ID")
    private String orderId;

    @TableField("ORG_CODE")
    private String orgCode;

    @TableField("BILL_NO")
    private String billNo;

    @TableField("SHYZ_AMT")
    private Long shyzAmt;

    @TableField("MAIL_CITY")
    private String mailCity;

    @TableField("RECE_CITY")
    private String receCity;

    @TableField("MAIL_NAME")
    private String mailName;

    @TableField("RECE_NAME")
    private String receName;

    @TableField("MAIL_INFO")
    private String mailInfo;

    @TableField("RECE_INFO")
    private String receInfo;

    @TableField("BASE_PRODUCTID")
    private String baseProductid;

    @TableField("PRODUCT_ID")
    private String productId;

    /**
     * 用户支付时唯一标识，在优惠券接口中使用
     */
    @TableField("USER_ID")
    private String userId;

    @TableField("EMP_NAME")
    private String empName;

    @TableField("EMP_NO")
    private String empNo;

}
