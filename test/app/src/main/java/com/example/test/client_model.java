package com.example.test;

public class client_model{

    String address,name,bloodgroup,emailid;
    int age;

    public client_model(String address, String name, String bloodgroup, String emailid, int age) {
        this.address = address;
        this.name = name;
        this.bloodgroup = bloodgroup;
        this.emailid = emailid;
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public String getBloodgroup() {
        return bloodgroup;
    }

    public String getEmailid() {
        return emailid;
    }

    public int getAge() {
        return age;
    }
}
