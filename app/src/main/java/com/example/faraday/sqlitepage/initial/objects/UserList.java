package com.example.faraday.sqlitepage.initial.objects;

import com.google.gson.annotations.SerializedName;

public class UserList {


    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("user_email")
    private String user_email;

    public UserList(String id, String name, String user_email) {
        this.id = id;
        this.name = name;
        this.user_email = user_email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }
}
