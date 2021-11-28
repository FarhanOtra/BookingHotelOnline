package com.example.bookinghotelonline.retrofit;

import com.example.bookinghotelonline.model.AuthClass;
import com.example.bookinghotelonline.model.HotelRoomResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface PortalClient {

    //EndPoint Login
    @FormUrlEncoded
    @POST("api/login")
    Call<AuthClass> checkLogin(@Field("email") String username, @Field("password") String password);

    //EmdPoint HotelRoom
    @GET("api/hotelroom")
    Call<HotelRoomResponse> getHotelRoom();
}
