package com.example.demo.entities;

public class User {

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String name;
    private String phone;
    private String email;

    String[] userInfo = new String[3];

    public User(){

    }
    public User(String name, String phone, String email){
        this.name=name;
        this.phone=phone;
        this.email=email;
    }
    public String[] getValue(){
        userInfo[0]=this.name;
        userInfo[1]=this.phone;
        userInfo[2]=this.email;
        return this.userInfo;
    }
    @Override
    public String toString() {
//        return User;
        return "user{" +
                "name=" + name +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                '}';

    }
}
