package com.example.hotelmanagementsystemlld;

import java.util.Date;
import java.util.List;

// Hotel class
public class Hotel {
    String name;
    Integer id;
    Location hotelLocation;
    List<Room> roomList;
}

// Location class
class Location {
    int pin;
    String street;
    String area;
    String city;
    String country;
}

// Room class
class Room {
    String roomNumber;
    RoomStyle roomStyle;
    RoomStatus roomStatus;
    Double bookingPrice;
    List<RoomKey> roomKeys;
    List<HouseKeepingLog> houseKeepingLogs;
}

// RoomKey class
class RoomKey {
    String keyId;
    String barCode;
    Date issueAt;
    Boolean isMaster;

    public void assignRoom(Room room) {
        // Implementation
    }
}

// HouseKeepingLog class
class HouseKeepingLog {
    String description;
    Date startDate;
    int duration;
    HouseKeeper houseKeeper;

    public void addRoom(Room room) {
        // Implementation
    }
}

// Abstract Person class
abstract class Person {
    String name;
    Account accountDetail;
    String phone;
}

// HouseKeeper class
class HouseKeeper extends Person {

    public List<Room> getRoomsServiced(Date date) {
        // Implementation
        return null;
    }
}

// Guest class
class Guest extends Person {
    Search searchObj;
    Booking bookingObj;

    public void checkInGuest(Guest guest, RoomBooking bookingInfo) {
        // Implementation
    }

    public void checkOutGuest(Guest guest, RoomBooking bookingInfo) {
        // Implementation
    }
}

// Admin class
class Admin extends Person {
    public void addRoom(Room roomDetail) {
        // Implementation
    }

    public Room deleteRoom(String roomId) {
        // Implementation
        return null;
    }

    public void editRoom(Room roomDetail) {
        // Implementation
    }
}

// Search class
class Search {
    public List<Room> searchRoom(RoomStyle roomStyle, Date startDate, int duration) {
        // Implementation
        return null;
    }
}

// Booking class
class Booking {
    public RoomBooking createBooking(Guest guestInfo) {
        // Implementation
        return null;
    }

    public RoomBooking cancelBooking(int bookingId) {
        // Implementation
        return null;
    }
}

// RoomBooking class
class RoomBooking {
    String bookingId;
    Date startDate;
    int durationInDays;
    BookingStatus bookingStatus;
    List<Guest> guestList;
    List<Room> roomInfo;
    BaseRoomCharge totalRoomCharge;
}

// BaseRoomCharge interface
interface BaseRoomCharge {
    Double getCost();

}

// RoomCharge class
class RoomCharge implements BaseRoomCharge {
    double cost;

    @Override
    public Double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}

// RoomServiceCharge class
class RoomServiceCharge implements BaseRoomCharge {
    double cost;
    BaseRoomCharge baseRoomCharge;

    @Override
    public Double getCost() {
        baseRoomCharge.setCost(baseRoomCharge.getCost() + cost);
        return baseRoomCharge.getCost();
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setBaseRoomCharge(BaseRoomCharge baseRoomCharge) {
        this.baseRoomCharge = baseRoomCharge;
    }
}

// InRoomPurchaseCharge class
class InRoomPurchaseCharge implements BaseRoomCharge {
    double cost;
    BaseRoomCharge baseRoomCharge;

    @Override
    public Double getCost() {
        baseRoomCharge.setCost(baseRoomCharge.getCost() + cost);
        return baseRoomCharge.getCost();
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setBaseRoomCharge(BaseRoomCharge baseRoomCharge) {
        this.baseRoomCharge = baseRoomCharge;
    }
}

// Enums for RoomStyle, RoomStatus, and BookingStatus (Add these as needed)
enum RoomStyle {
    STANDARD, DELUXE, SUITE;
}

enum RoomStatus {
    AVAILABLE, BOOKED, UNDER_MAINTENANCE;
}

enum BookingStatus {
    CONFIRMED, CANCELLED, PENDING;
}

// Account class (Assuming it has some structure, add fields as necessary)
class Account {
    String username;
    String password;
    // Other account details
}
