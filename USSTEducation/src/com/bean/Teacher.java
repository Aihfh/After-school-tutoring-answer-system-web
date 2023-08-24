package com.bean;

public class Teacher {
    String Teacherid;
    String Tname;
    String Tdept;
    String Tpassword;
    String Tinfo;

    public Teacher(String teacherid, String tname,String tpassword, String tdept,String tinfo) {
        this.Teacherid = teacherid;
        this.Tname = tname;
        this.Tpassword = tpassword;
        this.Tdept = tdept;
        this.Tinfo = tinfo;
    }

    public Teacher(String teacherid, String tname, String tdept, String tinfo) {
        Teacherid = teacherid;
        Tdept = tdept;
        Tname = tname;
        Tinfo = tinfo;
    }

    public Teacher() {

    }

    public String getTdept() {
        return Tdept;
    }

    public void setTdept(String tdept) {
        Tdept = tdept;
    }

    public String getTeacherid() {
        return Teacherid;
    }

    public void setTeacherid(String teacherid) {
        Teacherid = teacherid;
    }

    public String getTpassword() {
        return Tpassword;
    }

    public void setTpassword(String tpassword) {
        Tpassword = tpassword;
    }

    public String getTclass() {
        return Tdept;
    }

    public void setTclass(String tdept) {
        Tdept = tdept;
    }

    public String getTname() {
        return Tname;
    }

    public void setTname(String tname) {
        Tname = tname;
    }

    public String getTinfo() {
        return Tinfo;
    }

    public void setTinfo(String tinfo) {
        Tinfo = tinfo;
    }
}
