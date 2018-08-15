package com.takenzero.sbs.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LoginResp {
    @SerializedName("status")
    private String status;

    @SerializedName("message")
    private String message;

    @SerializedName("token_code")
    private String tokenCode;

    @SerializedName("id_user")
    private String idUser;

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public String getMessage(){
        return message;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public String getTokenCode() {
        return tokenCode;
    }

    public void setTokenCode(String tokenCode){
        this.tokenCode = tokenCode;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser){
        this.idUser = idUser;
    }
}
