package com.takenzero.sbs.model;

import com.google.gson.annotations.SerializedName;

public class UserDetail {
    @SerializedName("id_user")
    private String idUser;

    @SerializedName("name")
    private String fullName;

    @SerializedName("level_code")
    private Integer levelCode;

    @SerializedName("id_upline")
    private String idUpline;

    public UserDetail(){
        this.idUser = idUser;
        this.fullName = fullName;
        this.levelCode = levelCode;
        this.idUpline = idUpline;
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
}
