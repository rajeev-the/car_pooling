import java.util.ArrayList;
import java.util.List;

public class Ride {
    String source;
    String destination;
    int total_seats;
    int available_seats;
    double fare;
     int createdby;

    public Ride(String source, String destination, int total_seats, int available_seats, double fare, int createdby) {
        this.source = source;
        this.destination = destination;
        this.total_seats = total_seats;
         this.available_seats = total_seats; // or throw exception
        this.fare = fare;
        this.createdby = createdby;
    }

    @Override
    public String toString() {
        return "Ride{" +
                "source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", total_seats=" + total_seats +
                ", available_seats=" + available_seats +
                ", fare=" + fare +
                ", users=" + createdby+
                '}';
    }
}
