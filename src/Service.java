import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class Service {



    ///  ------------ Rides -----------------------------------//

   ///  Create the  Ride
   public Ride createRide(String source, String destination,
                          int total_seats, int available_seats,
                          double fare, int createdby) {

       Ride ride = null;

       try (Connection con = Database.getConnection()) {

           String query = """
            INSERT INTO rides
            (source, destination, total_seats, available_seats, fare, created_by, created_at)
            VALUES (?, ?, ?, ?, ?, ?, ?)
        """;

           PreparedStatement ps =
                   con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

           ps.setString(1, source);
           ps.setString(2, destination);
           ps.setInt(3, total_seats);
           ps.setInt(4, available_seats);
           ps.setDouble(5, fare);
           ps.setInt(6, createdby);
           ps.setTimestamp(7, new Timestamp(System.currentTimeMillis()));

           ps.executeUpdate();

           ResultSet rs = ps.getGeneratedKeys();
           if (rs.next()) {
               int rideId = rs.getInt(1);

               ride = new Ride(
                       rideId,
                       source,
                       destination,
                       total_seats,
                       available_seats,
                       fare,
                       createdby
               );
               System.out.println("Ride " + rideId + " has been created");
           }

       } catch (Exception e) {
           e.printStackTrace();
       }

       return ride;
   }



    ///  return the matched Ride by source and destination
    public List<Integer> matchRide(String source, String destination) {

        List<Integer> rideIds = new ArrayList<>();

        try (Connection con = Database.getConnection()) {

            PreparedStatement ps = con.prepareStatement(
                    "SELECT id FROM rides WHERE source = ? AND destination = ? AND created_at BETWEEN ? AND ?"
            );

            ps.setString(1, source);
            ps.setString(2, destination);

            LocalDateTime now = LocalDateTime.now();
            Timestamp start = Timestamp.valueOf(now.minusMinutes(5));
            Timestamp end   = Timestamp.valueOf(now.plusMinutes(5));

            ps.setTimestamp(3, start);
            ps.setTimestamp(4, end);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                rideIds.add(rs.getInt("id"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return rideIds;
    }

    ///---------------------------------- Users -------------------------------------------------///

    /// created User On DataBase
    public  User createuser(String username, String password, String email){

        try(Connection con = Database.getConnection()){

            String query = "INSERT INTO users (username,password,email) VALUES (?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2,password);
            ps.setString(3,email);

            ps.executeUpdate();
            System.out.println("User created successfully");
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return new User(username,password,email);

    }


    /// add the details in Users
    public int addcardetails(String driving_license , String vehicle_number , int curruser ){

        //create a function for of User whether Exits or ot vaildation

        try(Connection con = Database.getConnection()){

            PreparedStatement ps = con.prepareStatement(" UPDATE  users SET driving_license = ?, vehicle_number = ? WHERE user_id = ? ");
            ps.setString(1, driving_license);
            ps.setString(2, vehicle_number);
            ps.setInt(3, curruser);
            ps.executeUpdate();
            System.out.println("User driving license and vehicle number  added  successfully");

        }
        catch (Exception e){
            e.printStackTrace();
            return 0;
        }
        return curruser;
    }

    ///




    /// --------------------------------------------Booking ------------------------------------------------///

    /// created  Booking DataBase

    public Booking createBooking( User user, Ride  ride , int total_seat , int total_price){

        try(Connection con = Database.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO bookings (user_id, ride_id, total_seats, total_price) VALUES (?, ?, ?, ?)"
            );


            ps.setInt(1, user.user_id);
            ps.setInt(2, ride.ride_id);
            ps.setInt(3, total_seat);
            ps.setDouble(4, total_price);

            ps.executeUpdate();

            System.out.println("Booking created successfully");
        }

        catch (Exception e){
            e.printStackTrace();
        }

        return   new Booking(user,ride,total_seat,total_price);
    }

    ///  get user  past and current Booking
    public List<Booking> get_Book_of_users(User user){
        List<Booking> bookings = new ArrayList<>();

        try (Connection con = Database.getConnection()){
            PreparedStatement ps = con.prepareStatement(

                    "SELECT b.*, r.* FROM bookings b " +
                            "JOIN rides r ON b.ride_id = r.ride_id " +
                            "WHERE b.user_id = ?"

            );
            ps.setInt(1, user.user_id);
            ResultSet rs = ps.executeQuery();



            while (rs.next()) {

                Ride ride = new Ride(
                        rs.getInt("ride_id"),
                        rs.getString("source"),
                        rs.getString("destination"),
                        rs.getInt("total_seats"),
                        rs.getInt("available_seats"),
                        rs.getDouble("price"),
                        rs.getInt("created_at")

                );
                Booking booking = new Booking( user ,ride,rs.getInt("total_seats"),rs.getDouble("total_price"),rs.getTimestamp("booking_time"));
                bookings.add(booking);
            }

        }
        catch (Exception e){
            e.printStackTrace();
            return bookings;
        }

        return bookings;
    }





//    public  List<Booking> getbooking(){
//     return bookings;
//    }
//
//    public  List<Ride> getRides(){
//        return Rides;
//    }









}
