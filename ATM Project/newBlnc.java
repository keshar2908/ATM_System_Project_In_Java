import java.util.*;
import java.sql.*;
public class newBlnc{
	public void Checkblnc(String name){
		try{
			String uname = name;
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/pin","root","");
			Statement stmt = cn.createStatement();
			String sql = "SELECT *FROM surya WHERE name='"+uname+"'";
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				String newamt = rs.getString("amount");
				System.out.println("\t\tYour new amount is Rs. "+newamt);
				System.out.println("\n");
			}
		}catch(Exception e){
			System.out.println("Error: "+e.getMessage());
		}
	}
}