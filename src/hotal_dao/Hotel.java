package hotal_dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pojo_class.Room;



public class Hotel {
    private List<Room> rooms;
    private Map<String, Room> guestToRoomMap;

    public Hotel(int numRooms) {
        rooms = new ArrayList<>();
        guestToRoomMap = new HashMap<>();

        for (int i = 1; i <= numRooms; i++) {
            rooms.add(new Room(i));
        }
    }

    public List<Room> getAvailableRooms() {
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (!room.isOccupied()) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    public void checkIn(String guestName, int roomNumber) {
        Room room = rooms.get(roomNumber - 1);
       
        if (!room.isOccupied()) {
            room.checkIn(guestName);
            guestToRoomMap.put(guestName, room);
            System.out.println("Check-in successful!");
        } else {
            System.out.println("Room is already occupied.");
        }
    }

    public void checkOut(String guestName) {
        if (guestToRoomMap.containsKey(guestName)) {
            Room room = guestToRoomMap.get(guestName);
            room.checkOut();
            guestToRoomMap.remove(guestName);
            System.out.println("Check-out successful!");
        } else {
            System.out.println("Guest not found.");
        }
    }

    public void printGuestSummaryReport() {
        System.out.println("Guest Summary Report:");
        for (String guestName : guestToRoomMap.keySet()) {
            Room room = guestToRoomMap.get(guestName);
            System.out.println("Guest: " + guestName + ", Room: " + room.getRoomNumber());
        }
    }
    
    public void searchCustomer(String name) {
    	System.out.println(" Report:");
    	for (String guestName : guestToRoomMap.keySet()) {
    		Room room = guestToRoomMap.get(guestName);
    		if((room.getGuestName()).equalsIgnoreCase(name)) {
    			
    			System.out.println("Guest: " + guestName + ", Room: " + room.getRoomNumber());
    		}
    		else {
    			System.out.println("not avalable !");
    		}
    	}
    }
    
    
    
}
