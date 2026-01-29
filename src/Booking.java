import java.sql.Timestamp;
import java.time.Instant;

public class Booking {
    int user;
    int ride;
    int total_seats;
    double total_price;
    Timestamp booking_time;

    public Booking(int user, int ride, int total_seats, double total_price) {
        this.user = user;
        this.ride = ride;
        this.total_seats = total_seats;
        this.total_price = total_price;
    }
    public Booking(int user, int ride, int total_seats, double total_price, Timestamp booking_time) {
        this.user = user;
        this.ride = ride;
        this.total_seats = total_seats;
        this.total_price = total_price;
        this.booking_time = booking_time;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "user=" + user +
                ", ride=" + ride +
                ", total_seats=" + total_seats +
                ", total_price=" + total_price +
                ", booking_time=" + booking_time +
                '}';
    }
}
