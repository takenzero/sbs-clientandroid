package com.takenzero.sbs.model;

public class LoginReq {
    private String iduser;
    private String password;

    public LoginReq(String iduser, String password){
        this.iduser = iduser;
        this.password = password;
    }

    public String getIduser(){
        return iduser;
    }

    public void setIduser(String iduser){
        this.iduser = iduser;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }
}
