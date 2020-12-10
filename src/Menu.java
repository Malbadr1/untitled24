import java.sql.*;
import java.util.Scanner;

public class Menu {

    public static Scanner scanner = new Scanner(System.in);

    public static void menu() {
        System.out.println("1. Display all students");
        System.out.println("2. Display all courses");
        System.out.println("3. Display all student_courses");
        System.out.println("4. Quit");

    }

    static final String JDBC_Driver = "com.mysql.cj.jdbc.Driver";
    static final String url = "jdbc:mysql://localhost:3306/school" + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    Connection connection = null;


    public void students() {
        try {
            Class.forName(JDBC_Driver);

            System.out.println("All students...");
            connection = DriverManager.getConnection(url, USERNAME, PASSWORD);
            System.out.println("Creating statement...");
            Statement statement = connection.createStatement();
            String select = "SELECT * FROM students";
            ResultSet res = statement.executeQuery(select);
            while (res.next()) {
                System.out.println("id : " + res.getInt("id_student") + " ,name : " + res.getString("student_name") + " ,address : " + res.getString("student_address"));
            }

        } catch (SQLException sql) {
            sql.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void courses() {
        try {
            Class.forName(JDBC_Driver);

            //STEP 3: Open a connection
            System.out.println("All courses...");
            connection = DriverManager.getConnection(url, USERNAME, PASSWORD);

            Statement statement = connection.createStatement();
            String sql;
            sql = "SELECT * FROM courses";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                System.out.println("id : " + rs.getInt("id_courses") + " ,name : " + rs.getString("course_name"));
            }
        } catch (SQLException sql) {
            sql.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void enrollments() {
        try {

            Class.forName(JDBC_Driver);

            //STEP 3: Open a connection
            System.out.println("All enrollments...");
            connection = DriverManager.getConnection(url, USERNAME, PASSWORD);

            Statement statement = connection.createStatement();
            String sql;
            sql = "SELECT * FROM enrollments";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                System.out.println("id : " + rs.getInt("id_enroll") + " ,id_courses : " + rs.getInt("fk_id_student") +"id_student"+ rs.getInt("fk_id_student"));
            }
        } catch (SQLException sql) {
            sql.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void UserInput() {
        int n = 0;
        try {
            do {
                Scanner userinput = new Scanner(System.in);
                System.out.println("Enter Your Choice");
                int x = userinput.nextInt();
                if (x >= 0 && x <= 4) {
                    switch (x) {
                        case 1: {
                            Menu me = new Menu();
                            me.students();
                            break;
                        }
                        case 2: {
                            Menu me = new Menu();
                            me.courses();
                            break;
                        }
                        case 3: {
                            Menu me = new Menu();
                            me.enrollments();
                            break;
                        }
                        case 4: {
                            System.out.println("Exit");
                            n = -1;
                            break;
                        }


                    }
                } else {
                    System.out.println("Enter Valid number");
                }
            } while (n == 0);
            System.out.println("Thanks bye");
        } catch (NumberFormatException e) {
            System.out.println("Enter numeric value");
        }
    }
}
class menu_main {
    public static void main(String[] args) {
        Menu me1 = new Menu();
        me1.menu();
        me1.UserInput();
    }
}
