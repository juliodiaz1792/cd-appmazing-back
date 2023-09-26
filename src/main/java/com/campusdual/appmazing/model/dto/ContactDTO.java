package com.campusdual.appmazing.model.dto;
public class ContactDTO {
    private int id;
    private String name;
    private String first_surname;
    private String second_surname;
    private int phone;
    private String mail;

    //Getter and setter
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getFirst_surname() {
        return first_surname;
    }
    public void setFirst_surname(String first_surname) {
        this.first_surname = first_surname;
    }
    public String getSecond_surname() {
        return second_surname;
    }
    public void setSecond_surname(String second_surname) {
        this.second_surname = second_surname;
    }
    public int getPhone() {
        return phone;
    }
    public void setPhone(int phone) {
        this.phone = phone;
    }
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
}
