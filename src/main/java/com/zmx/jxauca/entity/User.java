package com.zmx.jxauca.entity;

public class User {
    private String userId;
    private String userName;
    private String userPwd;
    private String userQq;
    private String userHead;
    private String userType;
    private String dept;
    private String aca;
    private String major;
    private String classDd;
    private String number;
    private String sex;

    public User(String userId, String userName, String userPwd, String userQq, String userHead, String userType, String dept, String aca, String major, String classDd, String number, String sex) {
        this.userId = userId;
        this.userName = userName;
        this.userPwd = userPwd;
        this.userQq = userQq;
        this.userHead = userHead;
        this.userType = userType;
        this.dept = dept;
        this.aca = aca;
        this.major = major;
        this.classDd = classDd;
        this.number = number;
        this.sex = sex;
    }

    public User() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserQq() {
        return userQq;
    }

    public void setUserQq(String userQq) {
        this.userQq = userQq;
    }

    public String getUserHead() {
        return userHead;
    }

    public void setUserHead(String userHead) {
        this.userHead = userHead;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getAca() {
        return aca;
    }

    public void setAca(String aca) {
        this.aca = aca;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getClassDd() {
        return classDd;
    }

    public void setClassDd(String classDd) {
        this.classDd = classDd;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", userQq='" + userQq + '\'' +
                ", userHead='" + userHead + '\'' +
                ", userType='" + userType + '\'' +
                ", dept='" + dept + '\'' +
                ", aca='" + aca + '\'' +
                ", major='" + major + '\'' +
                ", classDd='" + classDd + '\'' +
                ", number='" + number + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
