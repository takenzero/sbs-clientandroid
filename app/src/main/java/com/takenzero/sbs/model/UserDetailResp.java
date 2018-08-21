package com.takenzero.sbs.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class UserDetailResp {
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
    @SerializedName("creation_date")
    private String creationDate;
    @SerializedName("total_downline")
    private String totalDownline;
    @SerializedName("count_left")
    private String countLeft;
    @SerializedName("count_right")
    private String countRight;
    @SerializedName("actual_balance")
    private String actualBalance;

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

    public String getLevelCode() {
        return levelCode;
    }

    public void setLevelCode(String levelCode){
        this.levelCode = levelCode;
    }

    public String getIdUpline(){
        return idUpline;
    }

    public void setIdUpline(String idUpline){
        this.idUpline = idUpline;
    }

    public String getCreationDate(){
        return creationDate;
    }

    public void setCreationDate(String creationDate){
        this.creationDate = creationDate;
    }

    public String getTotalDownline(){
        return totalDownline;
    }

    public void setTotalDownline(String totalDownline){
        this.totalDownline = totalDownline;
    }

    public String getCountLeft(){
        return countLeft;
    }

    public void setCountLeft(String countLeft){
        this.countLeft = countLeft;
    }

    public String getCountRight(){
        return countRight;
    }

    public void setCountRight(String countRight){
        this.countRight = countRight;
    }

    public String getActualBalance(){
        return actualBalance;
    }

    public void setActualBalance(String actualBalance){
        this.actualBalance = actualBalance;
    }
}
