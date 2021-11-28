package com.example.bookinghotelonline.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class HotelRoomResponse{

    @SerializedName("tanggal")
    private String tanggal;

    @SerializedName("jumlah_data")
    private int jumlahData;

    @SerializedName("hotelroom")
    private List<HotelroomItem> hotelroom;

    public String getTanggal(){
        return tanggal;
    }

    public int getJumlahData(){
        return jumlahData;
    }

    public List<HotelroomItem> getHotelroom(){
        return hotelroom;
    }
}