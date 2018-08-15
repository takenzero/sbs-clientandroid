package com.takenzero.sbs.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class UserDetail {
    @SerializedName("id_user")
    private String idUser;

    @SerializedName("name")
    private String fullName;

    @SerializedName("id_type")
    private String idType;

    @SerializedName("id_number")
    private String idNumber;

    @SerializedName("phone")
    private String phone;

    @SerializedName("level_code")
    private Integer levelCode;

    @SerializedName("id_upline")
    private String idUpline;

    @SerializedName("creation_date")
    private Date creationDate;

    public UserDetail(String idUser, String fullName, String idType, String idNumber, String phone, Integer levelCode, String idUpline, Date creationDate){
        this.idUser = idUser;
        this.fullName = fullName;
        this.idType = idType;
        this.idNumber = idNumber;
        this.phone = phone;
        this.levelCode = levelCode;
        this.idUpline = idUpline;
        this.creationDate = creationDate;
    }

    public String getIdUser(){
        return idUser;
    }

    public void setIdUser(String idUser){
        this.idUser = idUser;
    }

    public String getFullName(){
        return fullName;
    }

    public void setFullName(String fullName){
        this.fullName = fullName;
    }

    public String getIdType(){
        return idType;
    }

    public void setIdType(String idType){
        this.idType= idType;
    }

    public String getIdNumber(){
        return idNumber;
    }

    public void setIdNumber(String idNumber){
        this.idNumber = idNumber;
    }

    public Integer getLevelCode() {
        return levelCode;
    }

    public void setLevelCode(Integer levelCode){
        this.levelCode = levelCode;
    }

    public String getIdUpline(){
        return idUpline;
    }

    public void setIdUpline(String idUpline){
        this.idUpline = idUpline;
    }

    public Date getCreationDate(){
        return creationDate;
    }

    public void setCreationDate(Date creationDate){
        this.creationDate = creationDate;
    }
}
