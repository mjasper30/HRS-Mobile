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
import com.macaraeg_jasper.rastatel.R;
import com.macaraeg_jasper.rastatel.model.MyBookingModel;

import java.util.List;

public class BookingRecyclerViewAdapter extends RecyclerView.Adapter<BookingRecyclerViewAdapter.MyViewHolder>{
    private Context mContext;
    private List<MyBookingModel> mData;//My Booking Model sa folder ng model

    RequestOptions option;

    public BookingRecyclerViewAdapter(Context mContext, List<MyBookingModel> mData) {
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
        view = inflater.inflate(R.layout.my_booking_row_item, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_room_name.setText(mData.get(position).getRoomName());
        holder.tv_price.setText(mData.get(position).getPrice());
        holder.tv_booking_number.setText(mData.get(position).getBookingNumber());
        holder.tv_checkin.setText(mData.get(position).getCheckIn());
        holder.tv_checkout.setText(mData.get(position).getCheckOut());
        holder.tv_status.setText(mData.get(position).getStatus());

        //Load Image from the internet and set it into ImageView using Glide
        Glide.with(mContext).load(mData.get(position).getImage()).apply(option).into(holder.img_thumbnail1);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_room_name;
        TextView tv_price;
        TextView tv_booking_number;
        TextView tv_checkin;
        TextView tv_checkout;
        TextView tv_status;
        ImageView img_thumbnail1;

        public MyViewHolder(View itemView) {
            super(itemView);

            tv_room_name = itemView.findViewById(R.id.room_name);
            tv_price = itemView.findViewById(R.id.price);
            tv_booking_number = itemView.findViewById(R.id.bookingnumber);
            img_thumbnail1 = itemView.findViewById(R.id.thumbnail1);
            tv_checkin = itemView.findViewById(R.id.checkin);
            tv_checkout = itemView.findViewById(R.id.checkout);
            tv_status = itemView.findViewById(R.id.status);
        }
    }
}
