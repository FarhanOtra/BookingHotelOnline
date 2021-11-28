package com.example.bookinghotelonline.model;

public class Room {
    public String nomor;
    public String harga;
    public String jenis;
    public String status;

    public Room(String nomor, String harga, String jenis, String status){
        this.nomor = nomor;
        this.harga = harga;
        this.jenis = jenis;
        this.status = status;
    }
}
