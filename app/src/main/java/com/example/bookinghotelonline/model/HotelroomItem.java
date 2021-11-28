package com.example.bookinghotelonline.model;

import com.google.gson.annotations.SerializedName;

public class HotelroomItem{

    @SerializedName("harga")
    private String harga;

    @SerializedName("jenis")
    private String jenis;

    @SerializedName("id")
    private String id;

    @SerializedName("nomor")
    private String nomor;

    @SerializedName("status")
    private String status;

    public String getHarga(){
        return harga;
    }

    public String getJenis(){
        return jenis;
    }

    public String getId(){
        return id;
    }

    public String getNomor(){
        return nomor;
    }

    public String getStatus(){
        return status;
    }
}