package org.codealpha.hms.reservation;

import org.codealpha.hms.model.Reservation;
import org.codealpha.hms.model.RoomDetails;

import java.util.HashMap;
import java.util.Map;

public class ReservationManager {

    private Map<Integer, Reservation> reservations;
    private int nextReservationId;

    public ReservationManager() {
        reservations = new HashMap<>();
        nextReservationId = 1;
    }

    public Reservation makeReservation(RoomDetails room, String guestName) {
        Reservation reservation = new Reservation(nextReservationId++, room, guestName);
        room.setAvailable(false);
        reservations.put(reservation.getReservationId(), reservation);
        return reservation;
    }

    public Reservation getReservationById(int reservationId) {
        return reservations.get(reservationId);
    }
}
