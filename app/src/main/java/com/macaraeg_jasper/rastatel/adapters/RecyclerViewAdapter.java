package com.macaraeg_jasper.rastatel.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.macaraeg_jasper.rastatel.model.RoomModel;

import java.util.List;
import com.macaraeg_jasper.rastatel.R;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>{
    private Context mContext;
    private List<RoomModel> mData;//Room Model sa folder ng model

    RequestOptions option;

    public RecyclerViewAdapter(Context mContext, List<RoomModel> mData) {
        this.mContext = mContext;
        this.mData = mData;

        //Request option for Glide
        option = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;

        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.room_row_item, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_room_name.setText(mData.get(position).getRoomName());
        holder.tv_price.setText(mData.get(position).getPrice());

        //Load Image from the internet and set it into ImageView using Glide
        Glide.with(mContext).load(mData.get(position).getImage()).apply(option).into(holder.img_thumbnail);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_room_name;
        TextView tv_price;
        ImageView img_thumbnail;

        public MyViewHolder(View itemView) {
            super(itemView);

            tv_room_name = itemView.findViewById(R.id.room_name);
            tv_price = itemView.findViewById(R.id.price);
            img_thumbnail = itemView.findViewById(R.id.thumbnail);
        }
    }
}
