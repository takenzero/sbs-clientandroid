package com.takenzero.sbs.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DownlineResp {
    @SerializedName("status")
    private String status;
    @SerializedName("message")
    private String message;
    @SerializedName("total_downline")
    private String totalDownline;
    @SerializedName("count_left")
    private String countLeft;
    @SerializedName("count_right")
    private String countRight;
    @SerializedName("downline")
    private List<DownlineDetail> downline;

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

    public List<DownlineDetail> getDownline(){
        return downline;
    }

    public void setDownline(List<DownlineDetail> downline){
        this.downline = downline;
    }
}
