import java.util.*;
import java.sql.*;
public class Ministmt{
	public void Ministat(String name){

		Option op = new Option();
		try{
			Clear c = new Clear();
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/pin","root","");
			Statement stmt = cn.createStatement();
			String uname = name;
			String sql = "SELECT *FROM surya WHERE name = '"+uname+"'";
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				String balance = rs.getString("amount");
				System.out.println("\t\tPlease wait. The system is accessing your datas.");
				System.out.print("\t\t");
					for(int count=1;count<=48;count++){
						Thread.sleep(100);
						System.out.print(".");
					}
					c.screen();
				System.out.print("\n\n\n\n\t\t\t\tAccount Info:\n\t\t\t\t");
				for(int count=1;count<=13;count++){
						Thread.sleep(100);
						System.out.print(".");
					}
				System.out.println("\n\n\n\t\t\t\tName: "+uname);
				System.out.println("\t\t\t\tCurrent balance: "+balance);
				System.out.print("\n\n\t\tYou'll be redirected to previous menu in 5 seconds.\n\t\tPlease wait.");
					for(int count=1;count<=5;count++){
						Thread.sleep(1000);
						System.out.print(".....");
					}
				Thread.sleep(3000);
				c.screen();
				op.UserOption(uname);
			}
		}catch(Exception e){
			System.out.println("Error: "+e.getMessage());
		}
	}
}