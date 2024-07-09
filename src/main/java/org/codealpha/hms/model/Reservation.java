package org.codealpha.hms.model;

import org.codealpha.hms.model.RoomDetails;

public class Reservation {

    private int reservationId;
    private RoomDetails room;
    private String guestName;
    private boolean isPaid;

    public Reservation(int reservationId, RoomDetails room, String guestName) {
        this.reservationId = reservationId;
        this.room = room;
        this.guestName = guestName;
        this.isPaid = false;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public RoomDetails getRoom() {
        return room;
    }

    public void setRoom(RoomDetails room) {
        this.room = room;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }
}
