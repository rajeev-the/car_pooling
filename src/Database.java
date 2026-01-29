import java.sql.*;
import java.util.Scanner;


public class Database {

    static final String URL =
            "jdbc:postgresql://ep-round-pine-adg4s38s-pooler.c-2.us-east-1.aws.neon.tech:5432/neondb?sslmode=require";


//   static  final String URL = "jdbc:postgresql://ride-app-db.ct66aqec6ma9.ap-south-1.rds.amazonaws.com:5432/postgres?sslmode=verify-full&sslrootcert=/certs/global-bundle.pem";
    static final String USER = "neondb_owner";
    static final String PASSWORD = "npg_wSVpL08aPZlW";
//    static final String PASSWORD = "12345678";

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
