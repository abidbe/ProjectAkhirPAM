package com.example.projectakhirpam.model;

public class User {
    private String id, judul, isi;

    public User() {

    }

    public User(String judul, String isi){

    }
    public String getId() {
        return id;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getJudul () {
        return judul;
    }
    public void setJudul(String judul) {
        this.judul = judul;
    }
    public String getIsi() {
        return isi;
    }
    public void setIsi (String isi){
        this.isi = isi;
    }

}