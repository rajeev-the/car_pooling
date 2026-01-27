import java.sql.*;
import java.util.Scanner;

public class StudentCRUD {

    static final String URL =
            "jdbc:postgresql://ep-round-pine-adg4s38s-pooler.c-2.us-east-1.aws.neon.tech:5432/neondb?sslmode=require";

    static final String USER = "neondb_owner";
    static final String PASSWORD = "npg_wSVpL08aPZlW";

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // CREATE
    static void insertStudent() {
        try (Connection con = getConnection()) {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Age: ");
            int age = sc.nextInt();

            String sql = "INSERT INTO student VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setInt(3, age);

            ps.executeUpdate();
            System.out.println("✅ Student Inserted");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // READ
    static void readStudents() {
        try (Connection con = getConnection()) {

            String sql = "SELECT * FROM student";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            System.out.println("\nID   Name   Age");
            System.out.println("----------------");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + "   " +
                                rs.getString("name") + "   " +
                                rs.getInt("age")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // UPDATE
    static void updateStudent() {
        try (Connection con = getConnection()) {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter ID: ");
            int id = sc.nextInt();

            System.out.print("Enter New Age: ");
            int age = sc.nextInt();

            String sql = "UPDATE student SET age=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, age);
            ps.setInt(2, id);

            ps.executeUpdate();
            System.out.println("✅ Student Updated");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE
    static void deleteStudent() {
        try (Connection con = getConnection()) {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter ID: ");
            int id = sc.nextInt();

            String sql = "DELETE FROM student WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);
            ps.executeUpdate();

            System.out.println("✅ Student Deleted");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // MENU
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== POSTGRES JDBC CRUD =====");
            System.out.println("1. Insert");
            System.out.println("2. View");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("5. Exit");
            System.out.print("Choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> insertStudent();
                case 2 -> readStudents();
                case 3 -> updateStudent();
                case 4 -> deleteStudent();
                case 5 -> {
                    System.out.println("👋 Bye");
                    System.exit(0);
                }
                default -> System.out.println("❌ Invalid Choice");
            }
        }
    }
}