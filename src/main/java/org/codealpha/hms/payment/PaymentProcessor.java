package org.codealpha.hms.payment;

import java.util.Scanner;

public class PaymentProcessor {

    public boolean processPayment(double amount, String paymentMethod) {
        Scanner scanner = new Scanner(System.in);

        switch (paymentMethod.toLowerCase()) {
            case "credit card":
                System.out.print("Enter credit card number: ");
                String cardNumber = scanner.nextLine();
                System.out.print("Enter expiration date (MM/YY): ");
                String expirationDate = scanner.nextLine();
                System.out.print("Enter CVV: ");
                String cvv = scanner.nextLine();
                // Simulate payment processing
                System.out.println("Processing credit card payment...");
                return true;
            case "paypal":
                System.out.print("Enter PayPal email: ");
                String email = scanner.nextLine();
                // Simulate payment processing
                System.out.println("Processing PayPal payment...");
                return true;
            case "upi":
                System.out.print("Enter UPI ID: ");
                String upiId = scanner.nextLine();
                // Simulate payment processing
                System.out.println("Processing UPI payment...");
                return true;
            default:
                System.out.println("Unsupported payment method.");
                return false;
        }
    }
}
