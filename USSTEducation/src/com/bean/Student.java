package com.bean;

public class Student {
    private String Sno;
    private String Sname;
    private String Sex;
    private int Age;
    private String Dept;
    private String nat;
    public Student(){};

    public Student(String sno, String sname, String sex, int age, String dept, String nat) {
        this.Sno = sno;
        this.Sname = sname;
        this.Sex = sex;
        this.Age = age;
        this.Dept = dept;
        this.nat = nat;
    }

    public String getSno() {
        return Sno;
    }

    public String getSname() {
        return Sname;
    }

    public String getSex() {
        return Sex;
    }

    public int getAge() {
        return Age;
    }

    public String getDept() {
        return Dept;
    }

    public String getNat() {
        return nat;
    }

    public void setSno(String sno) {
        Sno = sno;
    }

    public void setSname(String sname) {
        Sname = sname;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public void setAge(int age) {
        Age = age;
    }

    public void setDept(String dept) {
        Dept = dept;
    }

    public void setNat(String nat) {
        this.nat = nat;
    }
}
