package org.codealpha.hms;

import org.codealpha.hms.model.Reservation;
import org.codealpha.hms.model.RoomDetails;
import org.codealpha.hms.payment.PaymentProcessor;
import org.codealpha.hms.reservation.ReservationManager;
import org.codealpha.hms.reservation.RoomManager;

import java.util.List;
import java.util.Scanner;

public class HotelReservationSystem {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        RoomManager roomManager = new RoomManager();
        ReservationManager reservationManager = new ReservationManager();
        PaymentProcessor paymentProcessor = new PaymentProcessor();

        while (true) {
            System.out.println("1. Search for available rooms");
            System.out.println("2. Make a reservation");
            System.out.println("3. View booking details");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter room category (Single/Double/Suite): ");
                    String category = scanner.nextLine();
                    List<RoomDetails> availableRooms = roomManager.getAvailableRooms(category);
                    if (availableRooms.isEmpty()) {
                        System.out.println("No rooms available in this category.");
                    } else {
                        System.out.println("Available rooms:");
                        for (RoomDetails room : availableRooms) {
                            System.out.println("Room number: " + room.getRoomNumber() + ", Price: ₹" + room.getPrice());
                        }
                    }
                    break;
                case 2:
                    System.out.print("Enter room number: ");
                    int roomNumber = scanner.nextInt();
                    scanner.nextLine();
                    RoomDetails room = roomManager.getRoomByNumber(roomNumber);
                    if (room == null || !room.isAvailable()) {
                        System.out.println("Room not available.");
                    } else {
                        System.out.print("Enter guest name: ");
                        String guestName = scanner.nextLine();
                        Reservation reservation = reservationManager.makeReservation(room, guestName);
                        System.out.println("Reservation made. Reservation ID: " + reservation.getReservationId());
                        System.out.print("Proceed to payment? (yes/no): ");
                        String proceed = scanner.nextLine();
                        if (proceed.equalsIgnoreCase("yes")) {
                            System.out.print("Enter payment method (Credit Card/PayPal/UPI): ");
                            String paymentMethod = scanner.nextLine();
                            boolean paymentSuccess = paymentProcessor.processPayment(room.getPrice(), paymentMethod);
                            if (paymentSuccess) {
                                reservation.setPaid(true);
                                System.out.println("Payment successful. Reservation confirmed.");
                            } else {
                                System.out.println("Payment failed. Reservation not confirmed.");
                            }
                        } else {
                            System.out.println("Reservation pending payment.");
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter reservation ID: ");
                    int reservationId = scanner.nextInt();
                    Reservation reservation = reservationManager.getReservationById(reservationId);
                    if (reservation == null) {
                        System.out.println("Reservation not found.");
                    } else {
                        System.out.println("Reservation details:");
                        System.out.println("Guest name: " + reservation.getGuestName());
                        System.out.println("Room number: " + reservation.getRoom().getRoomNumber());
                        System.out.println("Room category: " + reservation.getRoom().getCategory());
                        System.out.println("Price: ₹" + reservation.getRoom().getPrice());
                        System.out.println("Payment status: " + (reservation.isPaid() ? "Paid" : "Pending"));
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

    }
}
