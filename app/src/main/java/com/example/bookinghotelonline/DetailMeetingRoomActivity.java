package com.example.bookinghotelonline;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailMeetingRoomActivity extends AppCompatActivity {
    TextView textJenisMeetingRoom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_meeting_room);

        Intent detailMeetingRoomIntent = getIntent();
        String jenisMeetingRoom = detailMeetingRoomIntent.getStringExtra("JENIS_MEETING_ROOM");
        textJenisMeetingRoom = findViewById(R.id.textJenisMeetingRoom);
        textJenisMeetingRoom.setText(jenisMeetingRoom);
    }

    public void kembali (View view){
        finish();
    }

}