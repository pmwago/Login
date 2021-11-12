package com.example.login;

public class CustomerModel {
    String Id;
    String fullName;
    String address;
    String gender;

    public CustomerModel(String id, String fullName, String address, String gender) {
        Id = id;
        this.fullName = fullName;
        this.address = address;
        this.gender = gender;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
