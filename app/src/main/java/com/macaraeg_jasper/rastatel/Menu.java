package com.macaraeg_jasper.rastatel;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.macaraeg_jasper.rastatel.activities.MyBookingActivity;
import com.macaraeg_jasper.rastatel.activities.RoomActivity;

public class Menu extends AppCompatActivity {

    private boolean isBackPressedOnce=false;

    private RelativeLayout listRoom;
    private RelativeLayout listBooking;
    private RelativeLayout listProfile;
    private RelativeLayout listLogout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        listRoom = (RelativeLayout) findViewById(R.id.listRoom);
        listBooking = (RelativeLayout) findViewById(R.id.listBooking);
        listProfile = (RelativeLayout) findViewById(R.id.listProfile);
        listLogout = (RelativeLayout) findViewById(R.id.listLogout);

        listRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, RoomActivity.class);
                startActivity(intent);
                finish();
            }
        });

        listBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, MyBookingActivity.class);
                startActivity(intent);
                finish();
            }
        });

        listProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        listLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    @Override
    public void onBackPressed() {

        if (isBackPressedOnce) {
            super.onBackPressed();
            return;
        }

        Toast.makeText(this, "Press again to exit", Toast.LENGTH_SHORT).show();
        isBackPressedOnce = true;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                isBackPressedOnce = false;
            }
        }, 2000);

    }
}
