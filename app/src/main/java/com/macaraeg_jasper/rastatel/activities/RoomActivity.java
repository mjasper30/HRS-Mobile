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
import com.macaraeg_jasper.rastatel.adapters.RecyclerViewAdapter;
import com.macaraeg_jasper.rastatel.model.RoomModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class RoomActivity extends AppCompatActivity {

    private final String JSON_URL = "https://ucc-csd-bscs.com/HRS/mobile/available_rooms.php";
    private final String IMG_URL = "https://ucc-csd-bscs.com/HRS/admin/images/";
    private JsonArrayRequest request;
    private RequestQueue requestQueue;
    private List<RoomModel> listRoom;
    private RecyclerView recyclerView;

    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.recycler_view);

        listRoom = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerviewid);
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
                        RoomModel roommodel = new RoomModel();
                        roommodel.setRoomName(jsonObject.getString("RoomName"));
                        roommodel.setPrice("P " + jsonObject.getString("Price"));
                        roommodel.setImage(IMG_URL + jsonObject.getString("Image"));
                        listRoom.add(roommodel);

                    }catch (JSONException e){
                        e.printStackTrace();
                    }

                }
                setuprecyclerview(listRoom);
            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error){

            }
        });

        requestQueue = Volley.newRequestQueue(RoomActivity.this);
        requestQueue.add(request);
    }

    private void setuprecyclerview(List<RoomModel> listRoom){
        RecyclerViewAdapter myadapter = new RecyclerViewAdapter(this, listRoom);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(myadapter);
    }
}
