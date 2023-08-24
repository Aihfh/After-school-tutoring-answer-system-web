package com.bean;

public class Message {
    int MessageId;
    String Ddate;
    String Nname;
    String Ttitle;
    String Ccontext;
    String Classtype;

    public Message() {
    }

    public Message(int messageId, String ttitle, String nname, String ddate, String ccontext, String classtype) {
        MessageId = messageId;
        Ttitle = ttitle;
        Nname = nname;
        Ddate = ddate;
        Ccontext = ccontext;
        Classtype = classtype;
    }

    public int getMessageId() {
        return MessageId;
    }

    public void setMessageId(int messageId) {
        MessageId = messageId;
    }

    public String getDdate() {
        return Ddate;
    }

    public void setDdate(String ddate) {
        Ddate = ddate;
    }

    public String getNname() {
        return Nname;
    }

    public void setNname(String nname) {
        Nname = nname;
    }

    public String getTtitle() {
        return Ttitle;
    }

    public void setTtitle(String ttitle) {
        Ttitle = ttitle;
    }

    public String getCcontext() {
        return Ccontext;
    }

    public void setCcontext(String ccontext) { Ccontext = ccontext; }

    public String getClasstype() {return Classtype;}

    public void setClasstype(String classtype) {Classtype = classtype;}
}

