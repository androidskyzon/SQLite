package com.example.faraday.sqlitepage.initial.objects;

public class Invite {


    private String id;
    private String name;
    private String user_email;
    private String mob;
    private String modify_date;
    private String create_date;

    public Invite(String id, String name, String user_email, String mob, String modify_date, String create_date) {
        this.id = id;
        this.name = name;
        this.user_email = user_email;
        this.mob = mob;
        this.modify_date = modify_date;
        this.create_date = create_date;
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

    public String getMob() {
        return mob;
    }

    public void setMob(String mob) {
        this.mob = mob;
    }

    public String getModify_date() {
        return modify_date;
    }

    public void setModify_date(String modify_date) {
        this.modify_date = modify_date;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }
}
