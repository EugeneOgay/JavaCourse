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

    private void setEmptyPlaceSeats() {
        //Business class seats
        for(int row = 1; row <= BusinessClassSeat.rows; row++){
            for (String section : BusinessClassSeat.sections) {
                try {
                    seats.add(new BusinessClassSeat(row, section, false, null));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    e.printStackTrace();
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
                    e.printStackTrace();
                }
            }
        }
    }

    public void setDefaultStateSeats() {
        setEmptyPlaceSeats();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/java/lessons/lesson6/booking.txt"))) {
            for (Seat seat : seats) {
                String line = seat.getNumber() + seat.getSection() + "," +
                    seat.getSeatClass() + "," +
                    (!seat.isBooked() ? "FREE" : "BOOKED") + "," + "";
                writer.write(line);
                writer.newLine();
            }
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
        } catch (IOException e) {
            System.out.println("Ошибка при записи файла: " + e.getMessage());
        }
    }

private void loadFromFile() {
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
    } catch (IOException e) {
        System.out.println("Ошибка при чтении файла: " + e.getMessage());
    } catch (Exception e) {
        System.out.println(e.getMessage());
        e.printStackTrace();
    }
    seats = loadedSeats;
}

    public void Reserve(String passengerName, String numberAndSection, String seatClass) {
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
        if (seat == null) {
            System.out.printf("Нет места с номером %s, секцией %s и класса %s", row, section, seatClass);
            return;
        }

        seat.setPassenger(passenger);
        try {
            seat.setBooked();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        rewriteFile();
        System.out.printf("Место %s заброванировано на имя %s", numberAndSection, passengerName);
    }

    public void cancelReservation(String passengerName, String numberAndSection, String seatClass) {
        loadFromFile();
        int row = Integer.parseInt(numberAndSection.replaceAll("\\D", ""));
        String section = String.valueOf(numberAndSection.replaceAll("\\d", "").charAt(0));

        Seat seat = seats.stream().filter(s -> s.getNumber() == row && s.getSection().equalsIgnoreCase(section)
            && s.getSeatClass().equalsIgnoreCase(seatClass) && s.getPassengerName().
            equalsIgnoreCase(passengerName)).findFirst().orElse(null);
        if (seat == null) {
            System.out.printf("Нет места с номером %s, секцией %s и класса %s", row, section, seatClass);
            return;
        }

        if(!seat.isBooked()) {
            System.out.printf("Место %s класса %s не занято", numberAndSection, seatClass);
            return;
        }
        if (seat.isBooked() && !seat.getPassenger().getName().equalsIgnoreCase(passengerName)) {
            System.out.println("Место забронировано другим пассажиром и вы не можете снять бронь");
        } else if (seat.isBooked() && seat.getPassengerName().equalsIgnoreCase(passengerName)) {
            seat.cancelBooking();
            seat.setPassenger(null);
            rewriteFile();
            System.out.printf("Бронь места %s на имя %s снята", numberAndSection, passengerName);
        }
    }

    public void showSeatInfo(String numberAndSection) {
        loadFromFile();
        int row = Integer.parseInt(numberAndSection.replaceAll("\\D", ""));
        String section = String.valueOf(numberAndSection.replaceAll("\\d", "").charAt(0));
        Seat seat = seats.stream().filter(s -> s.getNumber() == row && s.getSection().equalsIgnoreCase(section))
            .findFirst().orElse(null);
        if (seat == null) {
            System.out.printf("Нет места с номером %s и секцией %s", row, section);
            return;
        }
        if (!seat.isBooked()) {
            System.out.printf("Ряд: %d, секция: %s, класс: %s, статус: свободно\n",
                row, section, seat.getSeatClass());
        } else System.out.printf("Ряд: %d, секция: %s, класс: %s, статус: занято, пассажир: %s\n",
            row, section, seat.getSeatClass(), seat.getPassengerName());
    }

    public void showAllSeats() {
        loadFromFile();
        System.out.println("Статус по местам: \n");
        for(Seat seat : seats){
            if (!seat.isBooked()) {
                System.out.printf("Ряд: %d, секция: %s, класс: %s, статус: свободно\n",
                    seat.getNumber(), seat.getSection(), seat.getSeatClass());
            } else System.out.printf("Ряд: %d, секция: %s, класс: %s, статус: занято, пассажир: %s\n",
                seat.getNumber(), seat.getSection(), seat.getSeatClass(), seat.getPassengerName());
        }
    }
}
