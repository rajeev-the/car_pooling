import java.time.Instant;

public class User {
     Integer user_id;
     String username;
    String password;
     String email;
     String driving_license;
     Instant exprire;
     String vehicle_number;
     Instant timezone = Instant.now();

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password=" + password +
                ", email='" + email + '\'' +
                '}';
    }

    public String getVehicle_number() {
        return vehicle_number;
    }

    public void setVehicle_number(String vehicle_number) {
        this.vehicle_number = vehicle_number;
    }

    public Instant getExprire() {
        return exprire;
    }

    public void setExprire(Instant exprire) {
        this.exprire = exprire;
    }

    public String getDriving_license() {
        return driving_license;
    }

    public void setDriving_license(String driving_license) {
        this.driving_license = driving_license;
    }
}
