package com.UmidJavaUdemy;

import java.util.*;

public class MovieTheater {
    private final String theaterName;
    private Collection<Seat> seatList = new ArrayList<>();


    public MovieTheater(String theaterName, int rowNum, int seatsInRow) {
        this.theaterName = theaterName;

        int lastRow = 'A' + (rowNum -1);
        for(char row = 'A'; row<=lastRow; row++){
            for(int seatNum = 1; seatNum <=seatsInRow; seatNum++){
                Seat seat = new Seat(row + String.format("%02d", seatNum));
                seatList.add(seat);
            }
        }
    }

    public boolean reserveSeat(String seatNumber){
        Seat requestedSeat = null;
        for(Seat seat : seatList){
            System.out.print(".");
            if(seat.getSeatNum().equals(seatNumber)){
                requestedSeat = seat;
                break;
            }
        }
        if(requestedSeat == null){
            System.out.println("この座席は　" + seatNumber + " ありませｎ");
            return false;
        }
        return requestedSeat.reserve();
    }
    public void getSeats(){
        for(Seat seat : seatList){
            System.out.println(seat.getSeatNum());
        }
    }

    public String getTheaterName() {
        return theaterName;
    }

    private class Seat implements Comparable<Seat>{
        private final String seatNum;
        private boolean reserved = false;

        public Seat(String seatNum) {
            this.seatNum = seatNum;
        }
        @Override
        public int compareTo(Seat seat) {
            return this.seatNum.compareToIgnoreCase(seat.getSeatNum());
        }


        public boolean reserve(){
            if(!this.reserved){
                this.reserved = true;
                System.out.println("座席は " + seatNum + " 確保された");
                return true;
            }
            else {
                return false;
            }
        }
        public boolean cancel(){
            if(this.reserved){
                this.reserved = false;
                System.out.println("座席表の確保は"+ seatNum + "取り消しされた");
                return true;
            }
            else {
                return false;
            }
        }

        public String getSeatNum() {
            return seatNum;
        }


    }


}

