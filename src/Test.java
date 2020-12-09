
import java.sql.*;
import java.util.Scanner;

public class Test {


    public static void main(String[] args) throws SQLException {
        Connection connection=null;
        Statement stm;
        Scanner sce = new Scanner(System.in);
        System.out.println("enter name ");
        String name = sce.next();
        System.out.println("enter addresse ");
        String address = sce.next();

        try {

            System.out.println("Connecting to database...");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:/school ", "root", "");
            stm = connection.createStatement();
            String query = "INSERT INTO students (id_student,student_name,student_address) VALUES (null,'" + name + "','" + address + "')";
            stm.executeUpdate(query);

            String select = "SELECT * FROM students";
            ResultSet res=stm.executeQuery(select);
            while ( res.next()){
                System.out.println("id : "+res.getInt("id_student")+" ,name : "+ res.getString("student_name")+" ,address : "+ res.getString("student_address"));
        }
            String update="UPDATE students SET student_name ='loes' WHERE student_name='sasa'";
            stm.executeUpdate(update);
            connection.close();
            res.close();
            stm.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(connection!=null)
                    connection.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println(" THanks Goodbye!");


    }
}
