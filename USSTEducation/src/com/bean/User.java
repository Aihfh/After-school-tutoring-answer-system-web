package com.bean;

public class User {
    String Userid;
    String UName;
    String UPassword;
    String Truename;
    public User() {
    }
    public User(String userid, String UName, String UPassword, String truename) {
        Userid = userid;
        this.UName = UName;
        this.UPassword = UPassword;
        Truename = truename;
    }

    public String getUserid() {
        return Userid;
    }

    public void setUserid(String userid) {
        Userid = userid;
    }

    public String getUName() {
        return UName;
    }

    public void setUName(String UName) {
        this.UName = UName;
    }

    public String getUPassword() {
        return UPassword;
    }

    public void setUPassword(String UPassword) {
        this.UPassword = UPassword;
    }

    public String getTruename() {
        return Truename;
    }

    public void setTruename(String truename) {
        Truename = truename;
    }
}
