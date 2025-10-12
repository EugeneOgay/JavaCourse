package main.java.lessons.lesson6;

public class EconomyClassSeat extends Seat{
    public static int rows = 16;
    public final static String[] sections =  {"A", "B", "C", "D", "E", "F"};

    public EconomyClassSeat(int number, String section, boolean booked, Passenger passenger) throws Exception {
        super(number, booked, passenger);
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
