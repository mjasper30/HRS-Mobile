package com.macaraeg_jasper.rastatel.model;

public class RoomModel {
    private String Image;
    private String RoomName;
    private String Price;

    public RoomModel() {
    }

    public RoomModel(String image, String roomName, String price) {
        Image = image;
        RoomName = roomName;
        Price = price;
    }

    public String getImage() {
        return Image;
    }

    public String getRoomName() {
        return RoomName;
    }

    public String getPrice() {
        return Price;
    }

    public void setImage(String image) {
        Image = image;
    }

    public void setRoomName(String roomName) {
        RoomName = roomName;
    }

    public void setPrice(String price) {
        Price = price;
    }


}
