
import java.util.ArrayList;
import java.util.Scanner;

class Room {
int roomNumber;
String category;
double price;
boolean isAvailable;

```
public Room(int roomNumber, String category, double price) {
    this.roomNumber = roomNumber;
    this.category = category;
    this.price = price;
    this.isAvailable = true; // All rooms are available initially
}

@Override
public String toString() {
    return "Room Number: " + roomNumber +
           "\\nCategory: " + category +
           "\\nPrice per Night: $" + price +
           "\\nAvailable: " + (isAvailable ? "Yes" : "No");
}

```

}

class Booking {
String guestName;
Room room;
int nights;
double totalCost;

```
public Booking(String guestName, Room room, int nights) {
    this.guestName = guestName;
    this.room = room;
    this.nights = nights;
    this.totalCost = room.price * nights;
}

@Override
public String toString() {
    return "Guest Name: " + guestName +
           "\\n" + room +
           "\\nNights: " + nights +
           "\\nTotal Cost: $" + totalCost;
}

```

}

public class HotelReservationSystem {
public static void main(String[] args) {
Scanner scanner = new Scanner([System.in](http://system.in/));
ArrayList<Room> rooms = initializeRooms();
ArrayList<Booking> bookings = new ArrayList<>();
boolean running = true;

```
    System.out.println("Welcome to the Hotel Reservation System!");

    // Main loop
    while (running) {
        System.out.println("\\nMain Menu:");
        System.out.println("1. View Available Rooms");
        System.out.println("2. Make a Reservation");
        System.out.println("3. View Booking Details");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                // View available rooms
                System.out.println("\\nAvailable Rooms:");
                for (Room room : rooms) {
                    if (room.isAvailable) {
                        System.out.println(room);
                        System.out.println("-------------------");
                    }
                }
                break;

            case 2:
                // Make a reservation
                System.out.println("\\nEnter Your Name: ");
                String guestName = scanner.nextLine();

                System.out.println("Enter the Room Number you wish to book: ");
                int roomNumber = scanner.nextInt();

                System.out.println("Enter the Number of Nights: ");
                int nights = scanner.nextInt();

                Room selectedRoom = null;
                for (Room room : rooms) {
                    if (room.roomNumber == roomNumber && room.isAvailable) {
                        selectedRoom = room;
                        break;
                    }
                }

                if (selectedRoom != null) {
                    selectedRoom.isAvailable = false;
                    Booking booking = new Booking(guestName, selectedRoom, nights);
                    bookings.add(booking);
                    System.out.println("Reservation successful!");
                    System.out.println(booking);
                } else {
                    System.out.println("Room not available or does not exist.");
                }
                break;

            case 3:
                // View booking details
                if (bookings.isEmpty()) {
                    System.out.println("No bookings found.");
                } else {
                    System.out.println("\\nBooking Details:");
                    for (Booking booking : bookings) {
                        System.out.println(booking);
                        System.out.println("-------------------");
                    }
                }
                break;

            case 4:
                // Exit program
                System.out.println("Thank you for using the Hotel Reservation System!");
                running = false;
                break;

            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    scanner.close();
}

// Method to initialize room data
private static ArrayList<Room> initializeRooms() {
    ArrayList<Room> rooms = new ArrayList<>();
    rooms.add(new Room(101, "Single", 100.0));
    rooms.add(new Room(102, "Double", 150.0));
    rooms.add(new Room(103, "Suite", 300.0));
    rooms.add(new Room(104, "Single", 100.0));
    rooms.add(new Room(105, "Double", 150.0));
    return rooms;
}

```

}