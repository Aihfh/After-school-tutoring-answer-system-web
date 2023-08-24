package com.bean;

public class Adm {
    String Cid;
    String Cname;
    String Cpassword;

    public Adm(String cid, String cname, String cpassword) {
        Cid = cid;
        Cname = cname;
        Cpassword = cpassword;
    }

    public Adm() {

    }

    public String getCid() {
        return Cid;
    }

    public void setCid(String cid) {
        Cid = cid;
    }

    public String getCname() {
        return Cname;
    }

    public void setCname(String cname) {
        Cname = cname;
    }

    public String getCpassword() {
        return Cpassword;
    }

    public void setCpassword(String cpassword) {
        Cpassword = cpassword;
    }
}
