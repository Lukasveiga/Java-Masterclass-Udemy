package com.masterclass.oldcontent.section13.theatreseats;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Theatre {

    private final String theatreName;
    private List<Seat> seats = new ArrayList<Seat>();

    static final Comparator<Seat> PRICE_ORDER = new Comparator<Seat>(){
        @Override
        public int compare(Seat seat1, Seat seat2) {
            if (seat1.getPrice() < seat2.getPrice()) {
                return -1;
            } else if (seat1.getPrice() > seat2.getPrice()) {
                return 1;
            } else {
                return 0;
            }
        }
    };

    public Theatre(String theatreName, int numRows, int seatsPerRows) {
        this.theatreName = theatreName;

        int lastRow = 'A' + (numRows - 1);
        for (char row = 'A'; row <= lastRow; row++) {
            for (int seatNum = 1; seatNum <= seatsPerRows; seatNum++) {
                double price = 12.0;
                if (row < 'D' && (seatNum >= 4 && seatNum <= 9)) {
                    price = 14.0;
                } else if ((row > 'F') || (seatNum < 4 || seatNum > 9)) {
                    price = 7.00;
                }
                Seat seat = new Seat(row + String.format("%02d", seatNum), price);
                seats.add(seat);
            }
        }
    }

    public String getTheatreName() {
        return theatreName;
    }

    public boolean reserveSeat(String seatNumber) {
        Seat requestedSeat = new Seat(seatNumber);
        int foundSeat = Collections.binarySearch(seats, requestedSeat, null);
        if (foundSeat >= 0) {
            return seats.get(foundSeat).reserve();
        } else {
            System.out.println("There is no seat");
            return false;
        }
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public Seat getSeat(String seatNumber) {
        Seat searchedSeat = null;
        for (Seat seat : seats) {
            if (seat.getSeatNumber().equals(seatNumber)) {
                searchedSeat = seat;
                break;
            }
        }

        if (searchedSeat == null) {
            System.out.println("There is no seat " + seatNumber);
            return null;
        }

        return searchedSeat;
    }

    public void cancelSeatreversed(String seatNumber) {
        Seat requestedSeat = new Seat(seatNumber);
        int foundSeat = Collections.binarySearch(seats, requestedSeat, null);
        if (foundSeat >= 0) {
            seats.get(foundSeat).cancel();
        }
    }

    public class Seat implements Comparable<Seat> {

        private final String seatNumber;
        private double price;
        private boolean reserved = false;

        public Seat(String seatNumber, double price) {
            this.seatNumber = seatNumber;
            this.price = price;
        }

        public Seat(String seatNumber) {
            this.seatNumber = seatNumber;
            this.price = 0;
        }

        public boolean reserve() {

            if (!this.reserved) {
                this.reserved = true;
                System.out.println("Seat " + this.seatNumber + " reserved");
                return true;
            } else {
                return false;
            }
        }

        public boolean cancel() {
            if (this.reserved) {
                this.reserved = false;
                System.out.println("Reservation of seat " + this.seatNumber + " cancelled.");
                return true;
            } else {
                return false;
            }
        }

        public String getSeatNumber() {
            return seatNumber;
        }

        public double getPrice() {
            return price;
        }

        public boolean isReserved() {
            return reserved;
        }

        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareTo(seat.seatNumber);
        }

    }

}
