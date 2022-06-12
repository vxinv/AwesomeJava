package com.lixin.boot.MbgGenerator.target.orm_user;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class OrmUser implements Serializable {
    @ApiModelProperty(value = "涓婚敭")
    private Integer id;

    @ApiModelProperty(value = "鐢ㄦ埛鍚�")
    private String name;

    @ApiModelProperty(value = "鍔犲瘑鍚庣殑瀵嗙爜")
    private String password;

    @ApiModelProperty(value = "鍔犲瘑浣跨敤鐨勭洂")
    private String salt;

    @ApiModelProperty(value = "閭")
    private String email;

    @ApiModelProperty(value = "鎵嬫満鍙风爜")
    private String phoneNumber;

    @ApiModelProperty(value = "鐘舵�侊紝-1锛氶�昏緫鍒犻櫎锛�0锛氱鐢紝1锛氬惎鐢�")
    private Integer status;

    @ApiModelProperty(value = "鍒涘缓鏃堕棿")
    private Date createTime;

    @ApiModelProperty(value = "涓婃鐧诲綍鏃堕棿")
    private Date lastLoginTime;

    @ApiModelProperty(value = "涓婃鏇存柊鏃堕棿")
    private Date lastUpdateTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", password=").append(password);
        sb.append(", salt=").append(salt);
        sb.append(", email=").append(email);
        sb.append(", phoneNumber=").append(phoneNumber);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", lastLoginTime=").append(lastLoginTime);
        sb.append(", lastUpdateTime=").append(lastUpdateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}