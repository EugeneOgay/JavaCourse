package main.java.lessons.lesson6;

import java.util.ArrayList;
import java.util.List;

public class BusinessClassSeat extends Seat{
    public final static int rows = 5;
    public final static String[] sections =  {"A", "C", "D", "F"};

    public BusinessClassSeat(int number, String row, boolean booked, Passenger passenger) throws Exception{
        super(number, row, booked, passenger);
        setSeatClass("Business");
    }
}
