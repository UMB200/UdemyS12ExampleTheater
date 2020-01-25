package com.UmidJavaUdemy;

public class Main {

    public static void main(String[] args) {
        MovieTheater movieTheater = new MovieTheater("東京", 2, 3);
        movieTheater.getSeats();
        if(movieTheater.reserveSeat("B03")){
            System.out.println("支払って下さい");
        }
        else {
            System.out.println("すみません、この座席は、確報された");
        }
        if(movieTheater.reserveSeat("B03")){
            System.out.println("支払って下さい");
        }
        else {
            System.out.println("すみません、この座席は、確報された");
        }
    }
}
