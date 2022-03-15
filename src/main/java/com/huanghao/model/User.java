package com.huanghao.model;

public class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private String sex;
    private String birth;
    //构建

    public User() {
    }

    public User(int id, String username, String password, String email, String sex, String birth) {
        this.id=id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.sex = sex;
        this.birth = birth;
    }
    //getter and setter


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    //to String


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", sex='" + sex + '\'' +
                ", birth='" + birth + '\'' +
                '}';
    }
}
