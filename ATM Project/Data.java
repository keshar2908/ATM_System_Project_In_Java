import java.util.*;
import java.sql.*;
public class Data{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		try{

			String sql;
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost","root","");
			Statement stmt = cn.createStatement();
			try{
				sql = "CREATE DATABASE pin";
				stmt.executeUpdate(sql);
				System.out.println("Database created.");
				throw new Exception();
			}catch(Exception e){
				System.out.println("Checking Database.");
			}
				Thread.sleep(2000);
				sql = "USE pin";
				stmt.executeUpdate(sql);
				System.out.println("Using database.");
				Thread.sleep(2000);
			try{
				sql = "CREATE TABLE surya (name VARCHAR(40) NOT NULL UNIQUE KEY, pin INT(4) NOT NULL AUTO_INCREMENT PRIMARY KEY, amount INT(10))";
				stmt.executeUpdate(sql);
				System.out.println("Table created.");
				throw new Exception();
			}catch(Exception e){
				System.out.println("Checking database table...");
			}
			Thread.sleep(2000);
			String ssql = "USE pin";
			stmt.executeUpdate(ssql);

			System.out.print("Enter your name: ");
			String name = sc.nextLine();

			System.out.print("Enter your pin: ");
			int pin = Integer.parseInt(sc.nextLine());
			Thread.sleep(1000);

			if((pin>=1000)&&(pin<=9999)){
				System.out.print("Enter amount: ");
				int amount = Integer.parseInt(sc.nextLine());

				Thread.sleep(2000);

				ssql = "INSERT INTO surya VALUES ('"+name+"','"+pin+"','"+amount+"')";
				stmt.executeUpdate(ssql);
				System.out.println("Datas inserted.");
			}else{
				System.out.println("Sorry. Only 4 digit pin is valid, ranging from 1000 to 9999.");
				System.out.println("Please try again.");
				Thread.sleep(2000);
			}
			

		}catch(Exception e){
			System.out.println("Error: "+e.getMessage());
			System.out.println("Please try again with different name or pin...");
		}
	}
}