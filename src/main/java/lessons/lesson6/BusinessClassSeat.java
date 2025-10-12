package main.java.lessons.lesson6;

public class BusinessClassSeat extends Seat{
    public final static int rows = 5;
    public final static String[] sections =  {"A", "C", "D", "F"};

    public BusinessClassSeat(int number, String section, boolean booked, Passenger passenger) throws Exception{
        super(number, booked, passenger);
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
