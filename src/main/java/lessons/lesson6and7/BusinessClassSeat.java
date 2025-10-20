package main.java.lessons.lesson6and7;

import java.time.LocalDateTime;

public class BusinessClassSeat extends Seat{
    public final static int rows = 5;
    public final static String[] sections =  {"A", "C", "D", "F"};

    public BusinessClassSeat(int number, String section, Status status, Passenger passenger, LocalDateTime timeOfBooking) throws Exception{
        super(number, status, passenger,  timeOfBooking);
        if(number > 6) throw new Exception("Выбран ряд иного класса");
        if(!checkSection(section)) throw new Exception("В бизнес классе нет такой секции");
        setSection(section);
        setSeatClass("Business");
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
