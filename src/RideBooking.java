import java.util.ArrayList;
import java.util.List;

public class RideBooking {

   public   List<Ride> rideList1 = new ArrayList<Ride>();
   public  List<User> userList = new ArrayList<User>();

   public List<Booking> bookingList = new ArrayList<Booking>();

    public void   createdRide(String source, String destination, int total_seats, int available_seats, double fare,User user){
         Ride r1 = new  Ride(source,destination,total_seats,available_seats,fare);
         userList.add(user);
         r1.users.add(user);
         rideList1.add(r1);
    }

    public void creaBooking( Ride ride , User user, Integer total_seats){

        Booking booking = new Booking(user,ride,total_seats);
        bookingList.add(booking);
    }




    public void  deleteRide(Ride ride){
        rideList1.remove(ride);
    }

    public List<Ride> getRideList(){
        return rideList1;
    }
    public void addUser(Ride ride,User user){

        if(rideList1.contains(ride)){
           Ride ride1 = rideList1.get(rideList1.indexOf(ride));
           ride1.users.add(user);
        }

    }

    public   void registerUser(String username, Integer password, String email){
        User user = new User(username,password,email);
        userList.add(user);
    }

    public  void loginUser(String username , Integer password){

        if(userList.contains(username)){
            System.out.println(username+"User is Login");
        }
    }

    public  void updateUser(User user,String username ,Integer password  , String email){
        if(userList.contains(user)){
           User user1 = userList.get(userList.indexOf(user));
           user1.email = email;
           user1.password = password;
           user1.username = username;
        }

    }

    // update ride
    //






}
