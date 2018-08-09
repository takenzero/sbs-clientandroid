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

    @SerializedName("user")
    private List<UserDetail> userDetail;

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

    public List<UserDetail> getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(List<UserDetail> userDetail){
        this.userDetail = userDetail;
    }
}
