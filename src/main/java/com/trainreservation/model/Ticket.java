package com.trainreservation.model;

import java.time.LocalDate;

public class Ticket {
    private String ticketId;
    private String username;
    private String source;
    private String destination;
    private LocalDate travelDate;
    private String trainName;
    private String seatType;
    private int seatCount;
    private double totalAmount;

    // Constructor
    public Ticket(String ticketId, String username, String source, String destination, LocalDate travelDate, 
                  String trainName, String seatType, int seatCount, double totalAmount) {
        this.ticketId = ticketId;
        this.username = username;
        this.source = source;
        this.destination = destination;
        this.travelDate = travelDate;
        this.trainName = trainName;
        this.seatType = seatType;
        this.seatCount = seatCount;
        this.totalAmount = totalAmount;
    }

    // Getters and setters
    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDate getTravelDate() {
        return travelDate;
    }

    public void setTravelDate(LocalDate travelDate) {
        this.travelDate = travelDate;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
