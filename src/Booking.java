public class Booking {
    User user;
    Ride ride;
    int total_seats;

    public Booking(User user, Ride ride, int total_seats) {
        this.user = user;
        this.ride = ride;
        this.total_seats = total_seats;
    }

}
