package com.example.bookinghotelonline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
    public void pilihBooking(View view){
        Intent intentBooking = new Intent(HomeActivity.this, BookingMenuActivity.class);
        startActivity(intentBooking);
    }
    public void pilihFacilities(View view){
        Intent intentFacilities = new Intent(HomeActivity.this, FacilitiesActivity.class);
        startActivity(intentFacilities);
    }
    public void pilihHistory(View view){
        Intent intentHistory = new Intent(HomeActivity.this, HistoryActivity.class);
        startActivity(intentHistory);
    }
}