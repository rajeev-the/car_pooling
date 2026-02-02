import java.sql.*;
import java.util.Scanner;


public class Database {

    static final String URL =
            "jdbc:postgresql://ep-round-pine-adg4s38s-pooler.c-2.us-east-1.aws.neon.tech:5432/neondb?sslmode=require";


    static final String USER = "neondb_owner";
    static final String PASSWORD = "npg_0aSoWuOmNw4j";

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
