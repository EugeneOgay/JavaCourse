package main.java.lessons.lesson6;

class Seat {
    private final int number;
    private String section;
    private String seatClass;
    private boolean isBooked;
    private Passenger passenger;

    public Seat(int number, boolean booked, Passenger passenger) throws Exception {
        if(number <= 0 || number > 21) throw new Exception("Выбран несуществующий номер места"); // обернуть в try catch при добавлении через add
        this.number = number;
        this.isBooked = booked;
        this.passenger = passenger;
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

    public boolean isBooked() {
        return isBooked;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public String getPassengerName() {
        return passenger.getName();
    }

    public void setSection(String section) {
        this.section = section;
    }

    public void setSeatClass(String seatClass) {
        this.seatClass = seatClass;
    }

    public void setBooked() throws Exception{
        try {
            if(!isBooked) {
                isBooked = true;
            }
        } catch (Exception exception) {
            exception.getMessage();
            exception.getStackTrace();
        }
    }

    public void cancelBooking() {
        if(isBooked) {
            isBooked = false;
        }
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }
}
