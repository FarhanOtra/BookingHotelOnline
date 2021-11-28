package com.example.bookinghotelonline;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookinghotelonline.adapter.RoomAdapter;
import com.example.bookinghotelonline.model.HotelRoomResponse;
import com.example.bookinghotelonline.model.HotelroomItem;
import com.example.bookinghotelonline.model.Room;
import com.example.bookinghotelonline.retrofit.PortalClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HotelRoomActivity extends AppCompatActivity implements RoomAdapter.OnRoomHolderClickListener {

    RecyclerView rvListRoom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_room);

        final RoomAdapter adapter = new RoomAdapter();
        adapter.setListener(this);

        rvListRoom = findViewById(R.id.rvListRoom);
        rvListRoom.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvListRoom.setLayoutManager(layoutManager);

        //Buat Object Client Retrofit
        String API_BASE_URL = "https://9803-36-69-14-214.ngrok.io/hotelapi/public/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PortalClient client = retrofit.create(PortalClient.class);

        Call<HotelRoomResponse> call = client.getHotelRoom();
        call.enqueue(new Callback<HotelRoomResponse>() {
            @Override
            public void onResponse(Call<HotelRoomResponse> call, Response<HotelRoomResponse> response) {
                HotelRoomResponse roomResponse = response.body();
                ArrayList<Room> listRoom = new ArrayList<Room>();
                if (roomResponse != null) {
                    List<HotelroomItem> roomItem = roomResponse.getHotelroom();
                    for (HotelroomItem item : roomItem) {
                        Room room = new Room(
                                item.getNomor(),
                                item.getHarga(),
                                item.getJenis(),
                                item.getStatus()
                        );
                        listRoom.add(room);
                    }
                }
                adapter.setListData(listRoom);
            }

            @Override
            public void onFailure(Call<HotelRoomResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "GAGAL", Toast.LENGTH_SHORT).show();
            }
        });
    }



    @Override
    public void onClick(View view, Room room) {
        Intent detailHotelRoomIntent = new Intent(this, DetailHotelRoomActivity.class);
        detailHotelRoomIntent.putExtra("NOMOR_ROOM_KAMAR", room.nomor);
        startActivity(detailHotelRoomIntent);
    }
}