package com.macaraeg_jasper.rastatel.model;

public class MyBookingModel {
    private String Image;
    private String RoomName;
    private String Price;
    private String BookingNumber;
    private String CheckIn;
    private String CheckOut;
    private String Status;

    public MyBookingModel() {
    }

    public MyBookingModel(String image, String roomName, String price, String bookingNumber, String checkIn, String checkOut, String status) {
        Image = image;
        RoomName = roomName;
        Price = price;
        BookingNumber = bookingNumber;
        CheckIn = checkIn;
        CheckOut = checkOut;
        Status = status;
    }

    //getter

    public String getImage() {
        return Image;
    }

    public String getRoomName() {
        return RoomName;
    }

    public String getPrice() {
        return Price;
    }

    public String getBookingNumber() {
        return BookingNumber;
    }

    public String getCheckIn() {
        return CheckIn;
    }

    public String getCheckOut() {
        return CheckOut;
    }

    public String getStatus() {
        return Status;
    }


    //setter

    public void setImage(String image) {
        Image = image;
    }

    public void setRoomName(String roomName) {
        RoomName = roomName;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public void setBookingNumber(String bookingNumber) {
        BookingNumber = bookingNumber;
    }

    public void setCheckIn(String checkIn) {
        CheckIn = checkIn;
    }

    public void setCheckOut(String checkOut) {
        CheckOut = checkOut;
    }

    public void setStatus(String status) {
        Status = status;
    }


}
