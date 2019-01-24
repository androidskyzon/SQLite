package com.example.faraday.sqlitepage.initial.objects;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class TeamList {


    @SerializedName("users")
    private ArrayList<User> userArrayList;

    @SerializedName("invite")
    private ArrayList<Invite> inviteArrayList;

    public TeamList(ArrayList<User> userArrayList, ArrayList<Invite> inviteArrayList) {
        this.userArrayList = userArrayList;
        this.inviteArrayList = inviteArrayList;
    }

    public ArrayList<User> getUserArrayList() {
        return userArrayList;
    }

    public void setUserArrayList(ArrayList<User> userArrayList) {
        this.userArrayList = userArrayList;
    }

    public ArrayList<Invite> getInviteArrayList() {
        return inviteArrayList;
    }

    public void setInviteArrayList(ArrayList<Invite> inviteArrayList) {
        this.inviteArrayList = inviteArrayList;
    }
}
