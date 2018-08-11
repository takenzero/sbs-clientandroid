package com.takenzero.sbs.model;

public class Header {
    private final String AUTH_KEY = "b277d4b4311ff79f65a20929bfba09d5";
    private final String CLIENT_SERVICE = "frontend-client";

    public String getAuthKey(){
        return AUTH_KEY;
    }

    public String getClientService(){
        return CLIENT_SERVICE;
    }
}
