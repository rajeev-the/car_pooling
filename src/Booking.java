public class Booking {
    User user;
    Ride ride;
    int total_seats;
    double total_price;

    public Booking(User user, Ride ride, int total_seats, double total_price) {
        this.user = user;
        this.ride = ride;
        this.total_seats = total_seats;
        this.total_price = total_price;
    }

}
