package com.example.bookinghotelonline;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class BookingMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_menu);
    }
    public void pilihHotel(View view){
        Intent intentHotel = new Intent(BookingMenuActivity.this, HotelRoomActivity.class);
        startActivity(intentHotel);
    }
    public void pilihMeeting(View view){
        Intent intentMeeting = new Intent(BookingMenuActivity.this, MeetingRoomActivity.class);
        startActivity(intentMeeting);
    }
    public void kembali (View view){
        finish();
    }
}