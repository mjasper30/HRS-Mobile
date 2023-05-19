package com.macaraeg_jasper.rastatel;

public class RoomList {
    private int mImageResource;
    private String mRoomName;
    private String mPrice;

    public RoomList(int imageResource, String roomName, String price){
        mImageResource = imageResource;
        mRoomName = roomName;
        mPrice = price;
    }

    public int getmImageResource() {
        return mImageResource;
    }

    public String getmRoomName() {
        return mRoomName;
    }

    public String getmPrice() {
        return mPrice;
    }
}
