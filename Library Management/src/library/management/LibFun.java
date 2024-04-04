
package library.management;
import java.sql.*;
public class LibFun {
    public static int save(String name,String pass,String email,String address,String city,String phone){
		int status=0;
		try{
			Connection con=(Connection) DBC.getConnection();
			PreparedStatement ps=(PreparedStatement) con.prepareStatement("insert into librarian(name,password,email,address,city,contact) values(?,?,?,?,?,?)");
			ps.setString(1,name);
			ps.setString(2,pass);
			ps.setString(3,email);
			ps.setString(4,address);
			ps.setString(5,city);
			ps.setString(6,phone);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
    public static int delete(int id){
		int status=0;
		try{
			Connection con=DBC.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from librarian where id=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
    public static boolean validate(String name,String password){
		boolean status=false;
		try{
			Connection con=DBC.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from librarian where name=? and password=?");
			ps.setString(1,name);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			status=rs.next();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
}
