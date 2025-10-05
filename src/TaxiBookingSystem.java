import java.util.*;

class Taxi {
    private static int counter = 0;
    private int taxiID;
    private String currentLocation;
    private int freeTime; // when taxi is free
    private double totalEarnings;

    public Taxi(String currentLocation) {
        this.taxiID = ++counter;
        this.currentLocation = currentLocation;
        this.freeTime = 0; // initially free
        this.totalEarnings = 0;
    }

    public int getTaxiID() { return taxiID; }
    public String getCurrentLocation() { return currentLocation; }
    public int getFreeTime() { return freeTime; }
    public double getTotalEarnings() { return totalEarnings; }

    public void setCurrentLocation(String location) { this.currentLocation = location; }
    public void setFreeTime(int freeTime) { this.freeTime = freeTime; }
    public void addEarnings(double fare) { this.totalEarnings += fare; }

    public void showDetails() {
        System.out.println("Taxi " + taxiID + " | Location: " + currentLocation +
                " | FreeTime: " + freeTime + " | Earnings: " + totalEarnings);
    }
}

class Booking {
    private static int counter = 0;
    private int bookingID;
    private String customerName;
    private String pickup;
    private String drop;
    private int pickupTime;
    private double fare;
    private Taxi assignedTaxi;

    public Booking(String customerName, String pickup, String drop, int pickupTime, Taxi taxi) {
        this.bookingID = ++counter;
        this.customerName = customerName;
        this.pickup = pickup;
        this.drop = drop;
        this.pickupTime = pickupTime;
        this.assignedTaxi = taxi;
        this.fare = calculateFare(pickup, drop);
        taxi.setCurrentLocation(drop);
        taxi.setFreeTime(pickupTime + Math.abs(drop.charAt(0) - pickup.charAt(0)));
        taxi.addEarnings(fare);
    }

    private double calculateFare(String pickup, String drop) {
        int distance = Math.abs(drop.charAt(0) - pickup.charAt(0)) * 15;
        return 100 + (distance - 5) * 10;
    }

    public void showBooking() {
        System.out.println("BookingID: " + bookingID + " | Customer: " + customerName +
                " | Pickup: " + pickup + " | Drop: " + drop +
                " | Time: " + pickupTime + " | Taxi: " + assignedTaxi.getTaxiID() +
                " | Fare: " + fare);
    }
}

class BookingManager {
    private List<Taxi> taxis = new ArrayList<>();
    private List<Booking> bookings = new ArrayList<>();

    public BookingManager(int taxiCount) {
        for (int i = 0; i < taxiCount; i++) {
            taxis.add(new Taxi("A")); // all taxis start at A
        }
    }

    public void bookTaxi(String customer, String pickup, String drop, int pickupTime) {
        Taxi chosenTaxi = null;
        for (Taxi t : taxis) {
            if (t.getFreeTime() <= pickupTime) {
                if (chosenTaxi == null || t.getTotalEarnings() < chosenTaxi.getTotalEarnings()) {
                    chosenTaxi = t;
                }
            }
        }

        if (chosenTaxi == null) {
            System.out.println("No taxis available!");
            return;
        }

        Booking booking = new Booking(customer, pickup, drop, pickupTime, chosenTaxi);
        bookings.add(booking);
        System.out.println("Booking successful!");
        booking.showBooking();
    }

    public void showTaxis() {
        for (Taxi t : taxis) {
            t.showDetails();
        }
    }

    public void showBookings() {
        for (Booking b : bookings) {
            b.showBooking();
        }
    }
}

public class TaxiBookingSystem {
    public static void main(String[] args) {
        BookingManager manager = new BookingManager(4); // 4 taxis
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Book Taxi\n2. Show Taxis\n3. Show Bookings\n4. Exit");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter Customer Name: ");
                String name = sc.next();
                System.out.print("Enter Pickup Location (A-F): ");
                String pickup = sc.next();
                System.out.print("Enter Drop Location (A-F): ");
                String drop = sc.next();
                System.out.print("Enter Pickup Time (int): ");
                int time = sc.nextInt();

                manager.bookTaxi(name, pickup, drop, time);
            } else if (choice == 2) {
                manager.showTaxis();
            } else if (choice == 3) {
                manager.showBookings();
            } else {
                break;
            }
        }
    }
}
