package main.java.lessons.lesson6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Airplane {
    private final ArrayList<Seat> seats = new ArrayList<>();
    private final ArrayList<Passenger> passengers = new ArrayList<>();

    public void setEmptyPlaceSeats() throws Exception {
        //Business class seats
        for(int row = 1; row <= BusinessClassSeat.rows; row++){
            for (String section : BusinessClassSeat.sections) {
                try {
                    seats.add(new BusinessClassSeat(row, section, false, null));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        //Economy class seats
        for(int row = 6; row <= EconomyClassSeat.rows + 5; row++){
            for (String section : EconomyClassSeat.sections) {
                try {
                    seats.add(new EconomyClassSeat(row, section, false, null));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public void setDefaultStateSeats() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/java/lessons/lesson6/booking.txt"))) {
            for (Seat seat : seats) {
                // Пример строки: 1A,ECONOMY,FREE,
                String line = seat.getNumber() + seat.getSection() + "," +
                    seat.getSeatClass() + "," +
                    (!seat.isBooked() ? "FREE" : "BOOKED") + "," + "";
                    //(seat.getPassenger() == null ? "" : seat.getPassengerName()); // тут  переделать
                writer.write(line);
                writer.newLine(); // переход на новую строку
            }
            System.out.println("Файл успешно создан и заполнен!");
        } catch (IOException e) {
            System.out.println("Ошибка при записи файла: " + e.getMessage());
        }
    }

    public ArrayList<Seat> loadFromFile() throws Exception{
        ArrayList<Seat> seats = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/java/lessons/lesson6/booking.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String numberAndSection = parts[0];
                int row = Integer.parseInt(numberAndSection.replaceAll("\\D", ""));
                String section = String.valueOf(numberAndSection.replaceAll("\\d", "").charAt(0));
                String seatClass = parts[1];
                boolean isBooked = parts[2].equals("BOOKED");
                Passenger passenger = null;
                if(parts.length > 3) {
                    for(Passenger pas : passengers) {
                        if(pas.getName().equalsIgnoreCase(parts[3])){
                            passenger = pas;
                            break;
                        }
                    }
                }
                //var passenger = parts.length > 3 ? parts[3] : null;

                Seat seat = seatClass.equalsIgnoreCase("Business") ?
                    new BusinessClassSeat(row, section, isBooked, passenger) :
                    new EconomyClassSeat(row, section, isBooked, passenger);
                seats.add(seat);
//                if(seatClass.equalsIgnoreCase("Business")) {
//                    Seat seat = new BusinessClassSeat(((int) numberAndSection.charAt(0)), String.valueOf(numberAndSection.charAt(1)), isBooked, passenger);
//                    seats.add(seat);
//                }  else {
//                    Seat seat = new EconomyClassSeat(((int) numberAndSection.charAt(0)), String.valueOf(numberAndSection.charAt(1)), isBooked, passenger);
//                    seats.add(seat);
//                }
                //Seat seat = new Seat(number, seatClass);
                //seat.setBooked(isBooked);
                //seat.setPassengerName(passenger);
                //seats.add(seat);
            }
            System.out.println("Данные загружены из файла.");
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
        return seats;
    }
}
