package main.java.lessons.lesson6;

public class EconomyClassSeat extends Seat{
    public static int rows = 16;
    public final static String[] sections =  {"A", "B", "C", "D", "E", "F"};

    public EconomyClassSeat(int number, String row, boolean booked, Passenger passenger) throws Exception {
        super(number, row, booked, passenger);
        setSeatClass("Economy");
    }

}
