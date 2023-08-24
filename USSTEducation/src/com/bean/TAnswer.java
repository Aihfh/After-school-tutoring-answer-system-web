package com.bean;

public class TAnswer {
    int MessageId;
    String Apicture;
    String Acontent;
    String Adate;
    String Teacherid;
    String Atype;
    String Tname;

    public TAnswer() {
    }

    public TAnswer(int messageId, String apicture, String acontent, String adate, String teacherid, String atype, String tname) {
        MessageId = messageId;
        Apicture = apicture;
        Acontent = acontent;
        Adate = adate;
        Teacherid = teacherid;
        Atype = atype;
        Tname = tname;
    }

    public TAnswer(int messageId, String apicture, String acontent, String adate, String teacherid, String tname) {
        MessageId = messageId;
        Apicture = apicture;
        Acontent = acontent;
        Adate = adate;
        Teacherid = teacherid;
        Tname = tname;
    }

    public String getTname() {
        return Tname;
    }

    public void setTname(String tname) {
        Tname = tname;
    }

    public String getAtype() {
        return Atype;
    }

    public void setAtype(String atype) {
        Atype = atype;
    }

    public int getMessageId() {
        return MessageId;
    }

    public void setMessageId(int messageId) {
        MessageId = messageId;
    }

    public String getApicture() {
        return Apicture;
    }

    public void setApicture(String apicture) {
        Apicture = apicture;
    }

    public String getAcontent() {
        return Acontent;
    }

    public void setAcontent(String acontent) {
        Acontent = acontent;
    }

    public String getAdate() {
        return Adate;
    }

    public void setAdate(String adate) {
        Adate = adate;
    }

    public String getTeacherid() {
        return Teacherid;
    }

    public void setTeacherid(String teacherid) {
        Teacherid = teacherid;
    }
}
