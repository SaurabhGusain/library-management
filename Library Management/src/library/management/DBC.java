package library.management;
import java.sql.*;
public class DBC {
    public static Connection getConnection(){
        Connection con=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","1234");
        }catch(Exception e){
            System.out.println(e);
        }
        return con;
    }
}
