package main.java.lessons.lesson6;

class Seat {
    private int number;
    private String row;
    private String seatClass;
    private boolean booked;
    private Passenger passenger;

    public Seat(int number, String row, boolean booked, Passenger passenger) throws Exception {
        if(number <= 0 || number > 21) throw new Exception("Выбран несуществующий номер места"); // обернуть в try catch при добавлении через add
        this.number = number;
        this.row = row;
        this.booked = booked;
        this.passenger = passenger;
    }

    public void setSeatClass(String seatClass) {
        this.seatClass = seatClass;
    }

    public void setBooked() throws Exception{
        try {
            if(!booked) {
                booked = true;
            }
        } catch (Exception exception) {
            exception.getMessage();
            exception.getStackTrace();
        }

    }
}
