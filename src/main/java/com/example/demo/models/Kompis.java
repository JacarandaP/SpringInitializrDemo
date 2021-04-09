package com.example.demo.models;


public class Kompis {
    protected int id;
    protected String namn;
    protected String adress;
    protected String phone;

    public Kompis(){}

    public Kompis(int id, String namn, String adress, String phone){
        this.id = id;
        this.namn = namn;
        this.adress = adress;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamn() {
        return namn;
    }

    public void setNamn(String namn) {
        this.namn = namn;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
