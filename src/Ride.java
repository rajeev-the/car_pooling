import java.util.ArrayList;
import java.util.List;

public class Ride {
    String source;
    String destination;
    int total_seats;
    int available_seats;
    double fare;
    List<User> users;

    public Ride(String source, String destination, int total_seats, int available_seats, double fare) {
        this.source = source;
        this.destination = destination;
        this.total_seats = total_seats;

        if (available_seats >= 0 && available_seats <= total_seats) {
            this.available_seats = available_seats;
        } else {
            this.available_seats = total_seats; // or throw exception
        }

        this.fare = fare;
        this.users = new ArrayList<User>();
    }

    @Override
    public String toString() {
        return "Ride{" +
                "source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", total_seats=" + total_seats +
                ", available_seats=" + available_seats +
                ", fare=" + fare +
                ", users=" + users.toString() +
                '}';
    }
}
