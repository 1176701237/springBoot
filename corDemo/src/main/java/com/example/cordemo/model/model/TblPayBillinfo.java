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

    public LocalDate getDateSsn() {
        return dateSsn;
    }

    public void setDateSsn(LocalDate dateSsn) {
        this.dateSsn = dateSsn;
    }

    public String getSsnPlt() {
        return ssnPlt;
    }

    public void setSsnPlt(String ssnPlt) {
        this.ssnPlt = ssnPlt;
    }

    public Short getSubSeq() {
        return subSeq;
    }

    public void setSubSeq(Short subSeq) {
        this.subSeq = subSeq;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public Long getShyzAmt() {
        return shyzAmt;
    }

    public void setShyzAmt(Long shyzAmt) {
        this.shyzAmt = shyzAmt;
    }

    public String getMailCity() {
        return mailCity;
    }

    public void setMailCity(String mailCity) {
        this.mailCity = mailCity;
    }

    public String getReceCity() {
        return receCity;
    }

    public void setReceCity(String receCity) {
        this.receCity = receCity;
    }

    public String getMailName() {
        return mailName;
    }

    public void setMailName(String mailName) {
        this.mailName = mailName;
    }

    public String getReceName() {
        return receName;
    }

    public void setReceName(String receName) {
        this.receName = receName;
    }

    public String getMailInfo() {
        return mailInfo;
    }

    public void setMailInfo(String mailInfo) {
        this.mailInfo = mailInfo;
    }

    public String getReceInfo() {
        return receInfo;
    }

    public void setReceInfo(String receInfo) {
        this.receInfo = receInfo;
    }

    public String getBaseProductid() {
        return baseProductid;
    }

    public void setBaseProductid(String baseProductid) {
        this.baseProductid = baseProductid;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }
}
