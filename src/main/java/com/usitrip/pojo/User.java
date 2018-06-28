package com.usitrip.pojo;

import java.util.Date;

public class User {
    private Integer userId;

    private String userName;

    private String apiPassword;

    private String password;

    private String name;

    private String telPhone;

    private String cellPhone;

    private String email;

    private Date createdAt;

    private Integer role;

    private Integer status;

    private String hotelChain;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getApiPassword() {
        return apiPassword;
    }

    public void setApiPassword(String apiPassword) {
        this.apiPassword = apiPassword;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelPhone() {
        return telPhone;
    }

    public void setTelPhone(String telPhone) {
        this.telPhone = telPhone;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getHotelChain() {
        return hotelChain;
    }

    public void setHotelChain(String hotelChain) {
        this.hotelChain = hotelChain;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", apiPassword='" + apiPassword + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", telPhone='" + telPhone + '\'' +
                ", cellPhone='" + cellPhone + '\'' +
                ", email='" + email + '\'' +
                ", createdAt=" + createdAt +
                ", role=" + role +
                ", status=" + status +
                ", hotelChain='" + hotelChain + '\'' +
                '}';
    }
}