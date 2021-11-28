package com.example.bookinghotelonline.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookinghotelonline.R;
import com.example.bookinghotelonline.model.Room;

import java.util.ArrayList;

public class RoomAdapter extends RecyclerView.Adapter<RoomAdapter.RoomViewHolder> {

    ArrayList<Room> listData = new ArrayList<>();

    public class RoomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView textNomorRoomKamar, textHarga, textJenisRoomHotel;

        public RoomViewHolder(@NonNull View itemView) {
            super(itemView);
            textNomorRoomKamar = itemView.findViewById(R.id.textNomorRoomKamar);
            textHarga = itemView.findViewById(R.id.textHarga);
            textJenisRoomHotel = itemView.findViewById(R.id.textJenisRoomKamar);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(listener != null){
                listener.onClick(view, listData.get(getAdapterPosition()));
            }
        }
    }

    OnRoomHolderClickListener listener = null;

    public interface OnRoomHolderClickListener{
        void onClick(View view, Room room);
    }

    public void setListener(OnRoomHolderClickListener listener) {
        this.listener = listener;
    }

    public void setListData(ArrayList<Room> listData) {
        this.listData = listData;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RoomAdapter.RoomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_hotelroom, parent, false);
        return new RoomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RoomViewHolder holder, int position) {
        Room room = listData.get(position);
        holder.textNomorRoomKamar.setText(room.nomor);
        holder.textHarga.setText(room.harga);
        holder.textJenisRoomHotel.setText(room.jenis);
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }
}
