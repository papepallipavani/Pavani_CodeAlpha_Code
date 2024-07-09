package org.codealpha.hms.reservation;

import org.codealpha.hms.model.RoomDetails;

import java.util.ArrayList;
import java.util.List;

public class RoomManager {

    private List<RoomDetails> rooms;

    public RoomManager() {
        rooms = new ArrayList<>();
        // Initialize with some rooms
        rooms.add(new RoomDetails(101, "Single", 1000.0));
        rooms.add(new RoomDetails(102, "Double", 1500.0));
        rooms.add(new RoomDetails(103, "Suite", 2000.0));
    }

    public List<RoomDetails> getAvailableRooms(String category) {
        List<RoomDetails> availableRooms = new ArrayList<>();
        for (RoomDetails room : rooms) {
            if (room.getCategory().equalsIgnoreCase(category) && room.isAvailable()) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    public RoomDetails getRoomByNumber(int roomNumber) {
        for (RoomDetails room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }
}
