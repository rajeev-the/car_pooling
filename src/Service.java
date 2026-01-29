import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class Service {
    List<Ride> Rides = new ArrayList<>();
    List<User> userss = new ArrayList<>();
   List<Booking> bookings = new ArrayList<>();


    public void createdride(String source, String destination, int total_seats,int available_seats ,  double fare, int createdby){

          try(Connection con = Database.getConnection()){

              String query = """
                       INSERT INTO rides
                          (source, destination, total_seats, available_seats, fare, created_by)
                          VALUES (?, ?, ?, ?, ?, ?)
                      """;
              PreparedStatement ps = con.prepareStatement(query);
              ps.setString(1, source);
              ps.setString(2, destination);
              ps.setInt(3, total_seats);
              ps.setInt(4, available_seats);
              ps.setDouble(5, fare);
              ps.setInt(6, createdby);
              ps.executeUpdate();
              System.out.println("Rider created successfully");


          } catch (Exception e) {
              e.printStackTrace();
          }


        Ride ride1= new Ride(source,destination,total_seats ,available_seats ,fare,createdby);
    }

    public void joinBook(Ride ride,User adduser){

        if(Rides.contains(ride)){
            Booking booking2 = new Booking(adduser,ride,ride.total_seats,ride.fare);
        }
        else{
            System.out.println("Ride not found");
        }

    }

    public Ride matchride(String source, String destination){

        for (Ride ride : Rides) {
            if(ride.destination.equals(destination)  &&  ride.source.equals(source) ){
                return ride;
            }
        }

        return null;
    }


 /// created User
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

    public void addcardetails(String driving_license , String vehicle_number , User curruser ){

         if(userss.contains(curruser)){
            // update the vehicle_number ,driving_license of currcet user
         }
    }

    public  List<Booking> getbooking(){
     return bookings;
    }

    public  List<Ride> getRides(){
        return Rides;
    }









}
