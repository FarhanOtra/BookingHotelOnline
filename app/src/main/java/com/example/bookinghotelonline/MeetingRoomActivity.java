package com.example.bookinghotelonline;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookinghotelonline.adapter.MeetingAdapter;
import com.example.bookinghotelonline.model.Meeting;

import java.util.ArrayList;

public class MeetingRoomActivity extends AppCompatActivity implements MeetingAdapter.OnMeetingHolderClickListener {

    RecyclerView rvListMeetingRoom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting_room);

        MeetingAdapter adapter = new MeetingAdapter();
        adapter.setListData(getMeeting());
        adapter.setListener(this);


        rvListMeetingRoom = findViewById(R.id.rvListMeetingRoom);
        rvListMeetingRoom.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvListMeetingRoom.setLayoutManager(layoutManager);
    }

    public ArrayList<Meeting> getMeeting(){
        ArrayList<Meeting> listMeetingRoom = new ArrayList<Meeting>();
        listMeetingRoom.add(new Meeting(
                "Meeting Deluxe",
                "Rp.100.000"
        ));
        listMeetingRoom.add(new Meeting(
                "Meeting VIP",
                "Rp.600.000"
        ));
        listMeetingRoom.add(new Meeting(
                "Meeting VVIP",
                "Rp.200.000"
        ));
        listMeetingRoom.add(new Meeting(
                "Meeting Deluxe",
                "Rp.100.000"
        ));
        listMeetingRoom.add(new Meeting(
                "Meeting VIP",
                "Rp.600.000"
        ));
        listMeetingRoom.add(new Meeting(
                "Meeting VVIP",
                "Rp.200.000"
        ));listMeetingRoom.add(new Meeting(
                "Meeting Deluxe",
                "Rp.100.000"
        ));
        listMeetingRoom.add(new Meeting(
                "Meeting VIP",
                "Rp.600.000"
        ));
        listMeetingRoom.add(new Meeting(
                "Meeting VVIP",
                "Rp.200.000"
        ));
        return listMeetingRoom;
    }

    @Override
    public void onClick(View view, Meeting meeting) {
        Intent detailMeetingRoomIntent = new Intent(this, DetailMeetingRoomActivity.class);
        detailMeetingRoomIntent.putExtra("JENIS_MEETING_ROOM", meeting.jenis);
        startActivity(detailMeetingRoomIntent);
    }


}