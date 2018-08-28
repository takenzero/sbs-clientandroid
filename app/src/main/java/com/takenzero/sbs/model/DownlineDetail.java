package com.takenzero.sbs.model;

import com.google.gson.annotations.SerializedName;

public class DownlineDetail {
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
    private String levelCode;
    @SerializedName("id_upline")
    private String idUpline;
    @SerializedName("user_type")
    private String userType;
    @SerializedName("creation_date")
    private String creationDate;
    @SerializedName("actual_balance")
    private String actualBalance;

    public DownlineDetail(String idUser, String fullName, String idType, String idNumber, String phone, String levelCode, String idUpline, String userType, String creationDate, String actualBalance){
        this.idUser = idUser;
        this.fullName = fullName;
        this.idType = idType;
        this.idNumber = idNumber;
        this.phone = phone;
        this.levelCode = levelCode;
        this.idUpline = idUpline;
        this.userType = userType;
        this.creationDate = creationDate;
        this.actualBalance = actualBalance;
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
        this.idType = idType;
    }

    public String getIdNumber(){
        return idNumber;
    }

    public void setIdNumber(String idNumber){
        this.idNumber = idNumber;
    }

    public String getPhone(){
        return phone;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public String getLevelCode(){
        return levelCode;
    }

    public void setLevelCode(String levelCode){
        this.phone = levelCode;
    }

    public String getIdUpline(){
        return idUpline;
    }

    public void setIdUpline(String idUpline){
        this.idUpline = idUpline;
    }

    public String getUserType(){
        return userType;
    }

    public void setUserType(String userType){
        this.userType = userType;
    }

    public String getCreationDate(){
        return creationDate;
    }

    public void setCreationDate(String creationDate){
        this.creationDate = creationDate;
    }

    public String getActualBalance(){
        return actualBalance;
    }

    public void setActualBalance(String actualBalance){
        this.actualBalance = actualBalance;
    }
}
