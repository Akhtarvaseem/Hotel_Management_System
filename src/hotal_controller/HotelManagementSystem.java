package hotal_controller;

import java.util.List;
import java.util.Scanner;

import hotal_dao.Hotel;
import pojo_class.Room;



public class HotelManagementSystem {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of rooms in the hotel: ");
        int numRooms = scanner.nextInt();
        
        Hotel hotel = new Hotel(numRooms);
        
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Check-In");
            System.out.println("2. Get Available Rooms");
            System.out.println("3. Check-Out Room");
            System.out.println("4. Get Guest Summary Report");
            System.out.println("5. Search customer");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    scanner.nextLine(); // Consume the newline
                    System.out.print("Enter guest name: ");
                    String guestName = scanner.nextLine();
                    
                    System.out.print("Enter room number: ");
                    int roomNumber = scanner.nextInt();
                    
                    hotel.checkIn(guestName, roomNumber);
                    break;
                case 2:
                    List<Room> availableRooms = hotel.getAvailableRooms();
                    System.out.println("Available Rooms:");
                    for (Room room : availableRooms) {
                        System.out.println("Room " + room.getRoomNumber());
                    }
                    break;
                case 3:
                    scanner.nextLine(); // Consume the newline
                    System.out.print("Enter guest name: ");
                    String guestToCheckOut = scanner.nextLine();
                    hotel.checkOut(guestToCheckOut);
                    break;
                case 4:
                    hotel.printGuestSummaryReport();
                    break;
                case 5:
                	System.out.println("Enter customer name :");
                	String name=scanner.next();
                	hotel.searchCustomer(name);;
                	break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
