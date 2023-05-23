package com.macaraeg_jasper.rastatel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.macaraeg_jasper.rastatel.activities.MyBookingActivity;
import com.macaraeg_jasper.rastatel.activities.RoomActivity;

public class Menu extends AppCompatActivity {

    private ImageButton imgRooms;
    private ImageButton imgMyBookings;
    private ImageButton imgProfile;
    private ImageButton imgLogout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        imgRooms = (ImageButton) findViewById(R.id.imgRooms);
        imgMyBookings = (ImageButton) findViewById(R.id.imgMyBookings);
        imgProfile = (ImageButton) findViewById(R.id.imgProfile);
        imgLogout = (ImageButton) findViewById(R.id.imgLogout);

        imgRooms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, RoomActivity.class);
                startActivity(intent);
                finish();
            }
        });

        imgMyBookings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, MyBookingActivity.class);
                startActivity(intent);
                finish();
            }
        });

        imgProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        imgLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
