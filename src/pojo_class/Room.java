package pojo_class;

public class Room{
    private int roomNumber;
    private boolean isOccupied;
    private String guestName;

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
        this.isOccupied = false;
        this.guestName = null;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public String getGuestName() {
        return guestName;
    }

    public void checkIn(String guestName) {
        this.isOccupied = true;
        this.guestName = guestName;
    }

    public void checkOut() {
        this.isOccupied = false;
        this.guestName = null;
    }
}
