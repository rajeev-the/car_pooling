public class User {
     String username;
     Integer password;
     String email;

    public User(String username, Integer password, String email) {
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
}
