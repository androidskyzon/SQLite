package com.example.faraday.sqlitepage.initial.objects;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {


    @SerializedName("status")
    private String status;

    @SerializedName("status_code")
    private String status_code;

    @SerializedName("statusMessage")
    private String statusMessage;

    @SerializedName("tokenId")
    private String tokenId;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public String getStatus_code() {
        return status_code;
    }

    public void setStatus_code(String status_code) {
        this.status_code = status_code;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }
}
