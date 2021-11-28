package com.example.bookinghotelonline;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailHotelRoomActivity extends AppCompatActivity {
    TextView textNomorRoomKamar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_hotel_room);

        Intent detailHotelRoomIntent = getIntent();
        String nomorRoomKamar = detailHotelRoomIntent.getStringExtra("NOMOR_ROOM_KAMAR");
        textNomorRoomKamar = findViewById(R.id.textNomorRoomKamar);
        textNomorRoomKamar.setText(nomorRoomKamar);
    }

    public void kembali (View view){
        finish();
    }
}