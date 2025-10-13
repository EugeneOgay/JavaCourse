package main.java.lessons.lesson6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Airplane {
    private ArrayList<Seat> seats = new ArrayList<>();
    private final ArrayList<Passenger> passengers = new ArrayList<>();

    public void setPassengers() {
        passengers.add(new Passenger("Tom"));
        passengers.add(new Passenger("Kevin"));
        passengers.add(new Passenger("John"));
        passengers.add(new Passenger("Brad"));
        passengers.add(new Passenger("Dylan"));
    }

    private void setEmptyPlaceSeats() throws Exception {
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

    public void setDefaultStateSeats() throws Exception {
        setEmptyPlaceSeats();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/java/lessons/lesson6/booking.txt"))) {
            for (Seat seat : seats) {
                String line = seat.getNumber() + seat.getSection() + "," +
                    seat.getSeatClass() + "," +
                    (!seat.isBooked() ? "FREE" : "BOOKED") + "," + "";
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Файл успешно создан и заполнен!");
        } catch (IOException e) {
            System.out.println("Ошибка при записи файла: " + e.getMessage());
        }
    }

    private void rewriteFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/java/lessons/lesson6/booking.txt"))) {
            for (Seat seat : seats) {
                String line = seat.getNumber() + seat.getSection() + "," +
                    seat.getSeatClass() + "," +
                    (!seat.isBooked() ? "FREE" : "BOOKED") + "," +
                (seat.getPassenger() == null ? "" : seat.getPassengerName());
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Файл успешно создан и заполнен!");
        } catch (IOException e) {
            System.out.println("Ошибка при записи файла: " + e.getMessage());
        }
    }

private void loadFromFile() throws Exception{
    ArrayList<Seat> loadedSeats = new ArrayList<>();
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

            Seat seat = seatClass.equalsIgnoreCase("Business") ?
                new BusinessClassSeat(row, section, isBooked, passenger) :
                new EconomyClassSeat(row, section, isBooked, passenger);
            loadedSeats.add(seat);
        }
        System.out.println("Данные загружены из файла.");
    } catch (IOException e) {
        System.out.println("Ошибка при чтении файла: " + e.getMessage());
    }
    seats = loadedSeats;
}

    public void Reserve(String passengerName, String numberAndSection, String seatClass) throws Exception {
        loadFromFile();
        int row = Integer.parseInt(numberAndSection.replaceAll("\\D", ""));
        String section = String.valueOf(numberAndSection.replaceAll("\\d", "").charAt(0));
        Passenger passenger = null;
        for(Passenger pas : passengers){
            if(pas.getName().equalsIgnoreCase(passengerName)) {
                passenger = pas;
                break;
            }
        }
        if(passenger == null) {
            System.out.println("Нет пассажира с таким именем");
            return;
        }

        Seat seat = seats.stream().filter(s -> s.getNumber() == row && s.getSection().equalsIgnoreCase(section)
                && s.getSeatClass().equalsIgnoreCase(seatClass)).findFirst().orElse(null);

        assert seat != null;
        seat.setPassenger(passenger);
        seat.setBooked();
        rewriteFile();
    }

    public void cancelReservation(String passengerName, String numberAndSection, String seatClass) throws Exception {
        loadFromFile();
        int row = Integer.parseInt(numberAndSection.replaceAll("\\D", ""));
        String section = String.valueOf(numberAndSection.replaceAll("\\d", "").charAt(0));

        Seat seat = seats.stream().filter(s -> s.getNumber() == row && s.getSection().equalsIgnoreCase(section)
            && s.getSeatClass().equalsIgnoreCase(seatClass)).findFirst().orElse(null);

        assert seat != null;
        if(!seat.isBooked()) {
            System.out.printf("Место %s класса %s не занято", numberAndSection, seatClass);
        }
        if (!seat.isBooked() || !seat.getPassenger().getName().equalsIgnoreCase(passengerName)) {
            System.out.println("Место забронировано другим пассажиром и вы не можете снять бронь");
        } else if (seat.isBooked() && seat.getPassengerName().equalsIgnoreCase(passengerName)) {
            seat.cancelBooking();
            seat.setPassenger(null);
            rewriteFile();
        }
    }

    public void showSeatInfo(String numberAndSection) throws Exception {
        loadFromFile();
        int row = Integer.parseInt(numberAndSection.replaceAll("\\D", ""));
        String section = String.valueOf(numberAndSection.replaceAll("\\d", "").charAt(0));
        Seat seat = seats.stream().filter(s -> s.getNumber() == row && s.getSection().equalsIgnoreCase(section))
            .findFirst().orElse(null);
        if (!seat.isBooked()) {
            System.out.printf("Ряд: %d, секция: %s, класс: %s, статус: свободно", row, section, seat.getSeatClass());
        } else System.out.printf("Ряд: %d, секция: %s, класс: %s, статус: занято, пассадир: %s", row, section, seat.getSeatClass(), seat.getPassengerName());
    }

    //вывод инфы  о всех местах
}
