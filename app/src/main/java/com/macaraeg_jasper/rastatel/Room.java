package com.macaraeg_jasper.rastatel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class Room extends AppCompatActivity{
    private ArrayList<RoomList> mRoomList;
    private RecyclerView mRecyclerView;
    private RoomAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private Button buttonInsert;
    private Button buttonRemove;
    private EditText editTextInsert;
    private EditText editTextRemove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview);

        createExampleList();
        buildRecyclerView();

        buttonInsert = findViewById(R.id.button_insert);
        buttonRemove = findViewById(R.id.button_remove);
        editTextInsert = findViewById(R.id.edittext_insert);
        editTextRemove = findViewById(R.id.edittext_remove);

        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = Integer.parseInt(editTextInsert.getText().toString());
                insertRoom(position);
            }
        });

        buttonRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = Integer.parseInt(editTextRemove.getText().toString());
                removeRoom(position);
            }
        });
    }

    public void insertRoom(int position) {
        mRoomList.add(position, new RoomList(R.drawable.room1, "New Item At Position" + position, "This is Line 2"));
        mAdapter.notifyItemInserted(position);
    }

    public void removeRoom(int position){
        mRoomList.remove(position);
        mAdapter.notifyItemRemoved(position);
    }

    public void createExampleList(){
        mRoomList = new ArrayList<>();
        mRoomList.add(new RoomList(R.drawable.room1, "Single Room", "P 4500"));
        mRoomList.add(new RoomList(R.drawable.room2, "Double Room", "P 5600"));
        mRoomList.add(new RoomList(R.drawable.room3, "Executive Suite Room", "P 6000"));
        mRoomList.add(new RoomList(R.drawable.room4, "Deluxe Room", "P 7700"));
        mRoomList.add(new RoomList(R.drawable.room5, "Presidential Suite Room", "P 8000"));
    }
    public void buildRecyclerView() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new RoomAdapter(mRoomList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
}
