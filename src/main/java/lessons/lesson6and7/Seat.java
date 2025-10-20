package main.java.lessons.lesson6and7;

import java.time.LocalDateTime;

public class Seat {
    private int number;
    private String section;
    private String seatClass;
    private Status status;
    private Passenger passenger;
    private LocalDateTime timeOfBooking;

    public Seat(int number, Status status, Passenger passenger, LocalDateTime timeOfBooking) throws Exception {
        if(number <= 0 || number > 21) throw new Exception("Выбран несуществующий номер места");
        this.number = number;
        this.status = status;
        this.passenger = passenger;
        this.timeOfBooking = timeOfBooking;
    }

    public int getNumber() {
        return number;
    }

    public String getSection() {
        return section;
    }

    public String getSeatClass() {
        return seatClass;
    }

    public Status getStatus() {
        return status;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public String getPassengerName() {
        return passenger.getName();
    }

    public LocalDateTime getTimeOfBooking() {
        return timeOfBooking;
    }

    public void setTimeOfBooking(LocalDateTime localDateTime) {
        this.timeOfBooking = localDateTime;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public void setSeatClass(String seatClass) {
        this.seatClass = seatClass;
    }

    public void setBooked() {
        switch (status) {
            case Status.VACANT -> {
                this.status = Status.BOOKED;
                this.timeOfBooking = LocalDateTime.now();
            }
            case BOOKED -> System.out.println("Это место забронировано");
            case BOUGHT -> System.out.println("Это место уже куплено");
        }
    }

    public void cancelBooking() {
        switch (status) {
            case Status.BOOKED -> {
                this.status = Status.VACANT;
                this.passenger =  null;
                this.timeOfBooking = null;
            }
            case Status.VACANT -> System.out.println("Место свободно");
            case Status.BOUGHT -> System.out.println("Оплаченный билет нельзя оменить");
        }
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }
}

