package main.java.lessons.lesson6;

import java.util.ArrayList;

public class Airplane {
    private ArrayList<Seat> seats;

    public void setEmptyPlaceSeats() throws Exception {
        //Business class seats
        for(int row = 1; row < BusinessClassSeat.rows; row++){
            for (String section : BusinessClassSeat.sections) {
                seats.add(new BusinessClassSeat(row, section, false, null));
            }
        }

        //Economy class seats
        for(int row = 6; row < EconomyClassSeat.rows; row++){
            for (String section : EconomyClassSeat.sections) {
                seats.add(new EconomyClassSeat(row, section, false, null));
            }
        }

    }
}
