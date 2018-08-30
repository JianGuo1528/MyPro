package com.usitrip.pojo;


import java.util.Date;

public class Country {

  private long countryId;
  private String countryCode;
  private String countryName;
  private String countryNameZh;
  private Date createdAt;
  private Date updatedAt;
  private long flag;
  private String continents;


  public long getCountryId() {
    return countryId;
  }

  public void setCountryId(long countryId) {
    this.countryId = countryId;
  }


  public String getCountryCode() {
    return countryCode;
  }

  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }


  public String getCountryName() {
    return countryName;
  }

  public void setCountryName(String countryName) {
    this.countryName = countryName;
  }


  public String getCountryNameZh() {
    return countryNameZh;
  }

  public void setCountryNameZh(String countryNameZh) {
    this.countryNameZh = countryNameZh;
  }


  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }


  public Date getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }


  public long getFlag() {
    return flag;
  }

  public void setFlag(long flag) {
    this.flag = flag;
  }


  public String getContinents() {
    return continents;
  }

  public void setContinents(String continents) {
    this.continents = continents;
  }

  @Override
  public String toString() {
    return "Country{" +
            "countryId=" + countryId +
            ", countryCode='" + countryCode + '\'' +
            ", countryName='" + countryName + '\'' +
            ", countryNameZh='" + countryNameZh + '\'' +
            ", createdAt=" + createdAt +
            ", updatedAt=" + updatedAt +
            ", flag=" + flag +
            ", continents='" + continents + '\'' +
            '}';
  }
}
