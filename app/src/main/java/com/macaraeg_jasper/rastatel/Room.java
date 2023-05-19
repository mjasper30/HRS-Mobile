package com.macaraeg_jasper.rastatel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import java.util.ArrayList;

public class Room extends AppCompatActivity{
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview);

        ArrayList<RoomList> roomList = new ArrayList<>();
        roomList.add(new RoomList(R.drawable.room1, "Single Room", "P 4500"));
        roomList.add(new RoomList(R.drawable.room2, "Double Room", "P 5600"));
        roomList.add(new RoomList(R.drawable.room3, "Executive Suite Room", "P 6000"));
        roomList.add(new RoomList(R.drawable.room4, "Deluxe Room", "P 7700"));
        roomList.add(new RoomList(R.drawable.room5, "Presidential Suite Room", "P 8000"));

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new RoomAdapter(roomList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
}
