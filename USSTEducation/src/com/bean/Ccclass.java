package com.bean;

public class Ccclass {
    String Tid;
    String CClass;
    String Tname;

    public Ccclass(String tid, String tname,String CClass) {
        Tid = tid;
        Tname = tname;
        this.CClass = CClass;
    }

    public Ccclass(String CClass, String tname) {
        this.CClass = CClass;
        Tname = tname;
    }

    public Ccclass(String CClass) {
        this.CClass = CClass;
    }

    public String getCClass() {
        return CClass;
    }

    public void setCClass(String CClass) {
        this.CClass = CClass;
    }

    public String getTname() {
        return Tname;
    }

    public void setTname(String tname) {
        Tname = tname;
    }

    public String getTid() {
        return Tid;
    }

    public void setTid(String tid) {
        Tid = tid;
    }
}
