package com.macaraeg_jasper.rastatel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RoomAdapter extends RecyclerView.Adapter<RoomAdapter.RoomViewHolder>{
    private ArrayList<RoomList> mRoomList;
    public static class RoomViewHolder extends RecyclerView.ViewHolder{
        public ImageView mImageView;
        public TextView mRoomName;
        public TextView mPrice;

        public RoomViewHolder(View roomView){
            super(roomView);
            mImageView = roomView.findViewById(R.id.imageView);
            mRoomName = roomView.findViewById(R.id.room_name);
            mPrice = roomView.findViewById(R.id.price);
        }
    }

    public RoomAdapter(ArrayList<RoomList> roomList){
        mRoomList = roomList;
    }

    @NonNull
    @Override
    public RoomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.room_list, parent, false);
        RoomViewHolder rvh = new RoomViewHolder(v);
        return rvh;
    }

    @Override
    public void onBindViewHolder(@NonNull RoomViewHolder holder, int position) {
        RoomList currentRoom = mRoomList.get(position);

        holder.mImageView.setImageResource(currentRoom.getmImageResource());
        holder.mRoomName.setText(currentRoom.getmRoomName());
        holder.mPrice.setText(currentRoom.getmPrice());
    }

    @Override
    public int getItemCount() {
        return mRoomList.size();
    }
}
