package com.example.bookinghotelonline.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookinghotelonline.R;
import com.example.bookinghotelonline.model.Meeting;

import java.util.ArrayList;

public class MeetingAdapter extends RecyclerView.Adapter<MeetingAdapter.MeetingViewHolder> {
    ArrayList<Meeting> listData = new ArrayList<>();

    public class MeetingViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textJenisMeetingRoom, textHargaMeetingRoom;

        public MeetingViewHolder(@NonNull View itemView) {
            super(itemView);
            textJenisMeetingRoom = itemView.findViewById(R.id.textJenisMeetingRoom);
            textHargaMeetingRoom = itemView.findViewById(R.id.textHargaMeetingRoom);
            itemView.setOnClickListener(this);

        }
        @Override
        public void onClick(View view) {
            if(listener != null){
                listener.onClick(view, listData.get(getAdapterPosition()));
            }
        }
}

    MeetingAdapter.OnMeetingHolderClickListener listener = null;

    public interface OnMeetingHolderClickListener{
        void onClick(View view, Meeting meeting);
    }

    public void setListener(MeetingAdapter.OnMeetingHolderClickListener listener) {
        this.listener = listener;
    }

    public void setListData(ArrayList<Meeting> listData) {
        this.listData = listData;
    }

    @NonNull
    @Override
    public MeetingAdapter.MeetingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_meetingroom, parent, false);
        return new MeetingAdapter.MeetingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MeetingAdapter.MeetingViewHolder holder, int position) {
        Meeting meeting = listData.get(position);
        holder.textJenisMeetingRoom.setText(meeting.jenis);
        holder.textHargaMeetingRoom.setText(meeting.harga);
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }
}