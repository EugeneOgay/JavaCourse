package main.java.lessons.lesson6and7;

import java.time.LocalDateTime;

public class EconomyClassSeat extends Seat{
    public static int rows = 16;
    public final static String[] sections =  {"A", "B", "C", "D", "E", "F"};

    public EconomyClassSeat(int number, String section, Status status, Passenger passenger, LocalDateTime timeOfBooking) throws Exception {
        super(number, status, passenger, timeOfBooking);
        if(number < 6 || number > 21) throw new Exception("Выбран ряд иного класса");
        if(!checkSection(section)) throw new Exception("В эконом классе нет такой секции");
        setSection(section);
        setSeatClass("Economy");
    }

    private boolean checkSection(String section) {
        for(String sec : sections) {
            if(sec.equalsIgnoreCase(section)) {
                return true;
            }
        }
        return false;
    }
}
