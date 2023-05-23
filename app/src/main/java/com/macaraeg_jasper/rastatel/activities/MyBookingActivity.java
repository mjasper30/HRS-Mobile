package com.macaraeg_jasper.rastatel.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.macaraeg_jasper.rastatel.R;
import com.macaraeg_jasper.rastatel.adapters.BookingRecyclerViewAdapter;
import com.macaraeg_jasper.rastatel.model.MyBookingModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MyBookingActivity extends AppCompatActivity {

    private final String JSON_URL = "https://ucc-csd-bscs.com/HRS/mobile/my_booking.php";
    private final String IMG_URL = "https://ucc-csd-bscs.com/HRS/admin/images/";
    private JsonArrayRequest request;
    private RequestQueue requestQueue;
    private List<MyBookingModel> listBooking;
    private RecyclerView recyclerView;

    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.my_booking_recycler_view);

        listBooking = new ArrayList<>();
        recyclerView = findViewById(R.id.my_booking_recyclerviewid);
        jsonrequest();
    }

    private void jsonrequest(){
        request = new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>(){
            @Override
            public void onResponse(JSONArray response){
                JSONObject jsonObject = null ;

                for (int i = 0; i < response.length(); i++){

                    try {
                        jsonObject = response.getJSONObject(i);
                        MyBookingModel mybookingmodel = new MyBookingModel();
                        mybookingmodel.setRoomName(jsonObject.getString("RoomName"));
                        mybookingmodel.setPrice("Price: P " + jsonObject.getString("Price"));
                        mybookingmodel.setImage(IMG_URL + jsonObject.getString("Image"));
                        mybookingmodel.setBookingNumber("Booking Number: " + jsonObject.getString("BookingNumber"));
                        mybookingmodel.setCheckIn("Check-in Date: " + jsonObject.getString("CheckinDate"));
                        mybookingmodel.setCheckOut("Check-out Date: " + jsonObject.getString("CheckoutDate"));
                        mybookingmodel.setStatus("Status: " + jsonObject.getString("Status"));
                        listBooking.add(mybookingmodel);

                    }catch (JSONException e){
                        e.printStackTrace();
                    }

                }
                setuprecyclerview1(listBooking);
            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error){

            }
        });

        requestQueue = Volley.newRequestQueue(MyBookingActivity.this);
        requestQueue.add(request);
    }

    private void setuprecyclerview1(List<MyBookingModel> listBooking){
        BookingRecyclerViewAdapter myadapter1 = new BookingRecyclerViewAdapter(this, listBooking);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(myadapter1);
    }
}
