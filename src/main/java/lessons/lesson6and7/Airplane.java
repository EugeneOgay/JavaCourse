package main.java.lessons.lesson6and7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Airplane {
    private ArrayList<Seat> seats = new ArrayList<>();
    private ArrayList<Passenger> passengers = new ArrayList<>();
    private LocalDateTime timeOfDeparture;

    public void setPassengers() {
        passengers.add(new Passenger("Tom"));
        passengers.add(new Passenger("Kevin"));
        passengers.add(new Passenger("John"));
        passengers.add(new Passenger("Brad"));
        passengers.add(new Passenger("Dylan"));
    }

    public void setTimeOfDeparture(LocalDateTime timeOfDeparture) {
        if(timeOfDeparture.isBefore(LocalDateTime.now())) throw new IllegalArgumentException("Время вылета не может быть прошедшей даты");
        this.timeOfDeparture = timeOfDeparture;
    }

    public void setDefaultStateSeats() {
        setEmptyPlaceSeats();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/java/lessons/lesson6and7/booking.txt"))) {
            for (Seat seat : seats) {
                String line = seat.getNumber() + seat.getSection() + "," +
                    seat.getSeatClass() + "," +
                    seat.getStatus().toString() + "," + "";
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Ошибка при записи файла: " + e.getMessage());
        }
    }

    private void rewriteFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/java/lessons/lesson6and7/booking.txt"))) {
            for (Seat seat : seats) {
                String line = seat.getNumber() + seat.getSection() + "," +
                    seat.getSeatClass() + "," +
                    seat.getStatus().toString() + "," +
                    (seat.getPassenger() == null ? "" : seat.getPassengerName()) + "," +
                    (seat.getTimeOfBooking() == null ? "" : seat.getTimeOfBooking().toString());
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Ошибка при записи файла: " + e.getMessage());
        }
    }

private void loadFromFile() {
    ArrayList<Seat> loadedSeats = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader("src/main/java/lessons/lesson6and7/booking.txt"))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            String numberAndSection = parts[0];
            int row = Integer.parseInt(numberAndSection.replaceAll("\\D", ""));
            String section = String.valueOf(numberAndSection.replaceAll("\\d", "").charAt(0));
            String seatClass = parts[1];
            Status status = Status.valueOf(parts[2]);
            Passenger passenger = null;
            if(parts.length > 3) {
                for(Passenger pas : passengers) {
                    if(pas.getName().equalsIgnoreCase(parts[3])){
                        passenger = pas;
                        break;
                    }
                }
            }
            LocalDateTime bookingTime = null;
            if(parts.length > 4) {
                bookingTime = LocalDateTime.parse(parts[4]);
            }

            Seat seat = seatClass.equalsIgnoreCase("Business") ?
                new BusinessClassSeat(row, section, status, passenger, bookingTime) :
                new EconomyClassSeat(row, section, status, passenger, bookingTime);
            loadedSeats.add(seat);
        }
    } catch (IOException e) {
        System.out.println("Ошибка при чтении файла: " + e.getMessage());
    } catch (Exception e) {
        System.out.println(e.getMessage());
        System.err.println("Ошибка при создании места: " + e.getMessage());
    }
    seats = loadedSeats;
    checkBookingTime();
    rewriteFile();
}

    public void reserve(String passengerName, String numberAndSection, String seatClass) {
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
        if(timeOfDeparture.isBefore(LocalDateTime.now())) throw new IllegalArgumentException("Самолет уже вылетел");

        if(seat.getStatus() == Status.VACANT) {
            seat.setPassenger(passenger);
            seat.setBooked();
            seat.setTimeOfBooking(LocalDateTime.now());
            rewriteFile();
            System.out.printf("Место %s заброванировано на имя %s", numberAndSection, passengerName);
        }

        if(seat.getStatus() == Status.BOUGHT) {
            System.out.println("Это место уже выкуплено");
            return;
        }

        if (seat.getStatus() == Status.BOOKED && !seat.getPassenger().getName().equalsIgnoreCase(passengerName)) {
            System.out.println("Место уже забронировано другим пассажиром");
        }
    }

    public void cancelReservation(String passengerName, String numberAndSection, String seatClass) {
        loadFromFile();
        int row = Integer.parseInt(numberAndSection.replaceAll("\\D", ""));
        String section = String.valueOf(numberAndSection.replaceAll("\\d", "").charAt(0));

        Seat seat = seats.stream().filter(s -> s.getNumber() == row && s.getSection().equalsIgnoreCase(section)
            && s.getSeatClass().equalsIgnoreCase(seatClass) ).findFirst().orElse(null);
        if (seat == null) {
            System.out.printf("Нет места с номером %s, секцией %s и класса %s", row, section, seatClass);
            return;
        }
        if(seat.getStatus() == Status.VACANT) {
            System.out.printf("Место %s класса %s не занято", numberAndSection, seatClass);
            return;
        }
        if(seat.getStatus() == Status.BOUGHT) {
            System.out.println("Купленный билет нельзя отменить");
            return;
        }
        if (seat.getStatus() == Status.BOOKED && !seat.getPassenger().getName().equalsIgnoreCase(passengerName)) {
            System.out.println("Место забронировано другим пассажиром и вы не можете снять бронь");
        } else {
            seat.cancelBooking();
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
        switch (seat.getStatus()) {
            case Status.VACANT -> System.out.printf("Ряд: %d, секция: %s, класс: %s, статус: свободно\n",
                row, section, seat.getSeatClass());
            case Status.BOOKED -> System.out.printf("Ряд: %d, секция: %s, класс: %s, статус: забронировано, пассажир: %s\n",
                row, section, seat.getSeatClass(), seat.getPassengerName());
            default -> System.out.printf("Ряд: %d, секция: %s, класс: %s, статус: куплено, пассажир: %s\n",
                row, section, seat.getSeatClass(), seat.getPassengerName());
        }
    }

    public void showAllSeats() {
        loadFromFile();
        System.out.println("Статус по местам: \n");
        for(Seat seat : seats){
            switch (seat.getStatus()) {
                case Status.VACANT -> System.out.printf("Ряд: %d, секция: %s, класс: %s, статус: свободно\n",
                    seat.getNumber(), seat.getSection(), seat.getSeatClass());
                case Status.BOOKED -> System.out.printf("Ряд: %d, секция: %s, класс: %s, статус: забронировано, пассажир: %s\n",
                    seat.getNumber(), seat.getSection(), seat.getSeatClass(), seat.getPassengerName());
                default -> System.out.printf("Ряд: %d, секция: %s, класс: %s, статус: куплено, пассажир: %s\n",
                    seat.getNumber(), seat.getSection(), seat.getSeatClass(), seat.getPassengerName());
            }
        }
    }

    private void checkBookingTime() {
        for(Seat seat : seats) {
            if(seat.getTimeOfBooking() != null){
                Duration difference = Duration.between(seat.getTimeOfBooking(), LocalDateTime.now());
                if (seat.getStatus() == Status.BOOKED && difference.toMinutes() > 24) {
                    seat.cancelBooking();
                }
            }
        }
    }

    private void setEmptyPlaceSeats() {
        addSeats(1, BusinessClassSeat.rows, BusinessClassSeat.sections, "Business");
        addSeats(6, EconomyClassSeat.rows + 5, EconomyClassSeat.sections, "Economy");
    }

    private void addSeats(int startRow, int rows, String[] sections, String seatClass) {
        for(int row = startRow; row <= rows; row++){
            for (String section : sections) {
                try {
                    if (seatClass.equals("Business")) {
                        seats.add(new BusinessClassSeat(row, section, Status.VACANT, null, null));
                    } else {
                        seats.add(new EconomyClassSeat(row, section, Status.VACANT, null, null));
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    System.err.println("Ошибка при создании места: " + e.getMessage());
                }
            }
        }
    }
}
