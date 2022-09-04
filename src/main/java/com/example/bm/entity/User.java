package com.example.bm.entity;

public class User {
    private int uid;
    private String uname;
    private String name;
    private String pwd;
    private String phoneNumber;
    private String emil;
    private String sex;
    private String role;
    private String area;

    public User(){};

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", emil='" + emil + '\'' +
                ", sex='" + sex + '\'' +
                ", role='" + role + '\'' +
                ", area='" + area + '\'' +
                '}';
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public User(int uid, String uname, String name, String pwd, String phoneNumber, String emil, String sex, String role) {
        this.uid = uid;
        this.uname = uname;
        this.name = name;
        this.pwd = pwd;
        this.phoneNumber = phoneNumber;
        this.emil = emil;
        this.sex = sex;
        this.role = role;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmil() {
        return emil;
    }

    public void setEmil(String emil) {
        this.emil = emil;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
