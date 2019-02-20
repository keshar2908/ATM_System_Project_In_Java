import java.util.*;
import java.sql.*;
public  class Update extends Database{
	public void Info(String uname){
		Scanner sc = new Scanner(System.in);
		Option op = new Option();
		String username = uname;
		try{
			Clear c = new Clear();
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/pin","root","");
			Statement stmt = cn.createStatement();

			System.out.print("\n\n\n\nEnter new pin: ");
			String pin1 = sc.nextLine();
			System.out.print("\n\n\nVerify new pin: ");
			String pin2 = sc.nextLine();
			if(pin1.equals(pin2)){
				System.out.println("\n\n\t\tUpdating new pin...");
				Thread.sleep(3000);
			String sql = "UPDATE surya SET pin = '"+pin1+"' WHERE name = '"+username+"'";
			stmt.executeUpdate(sql);
			if(pin2==username){
				System.out.println("No change has been detected. Pin is set to previous pin.");
			}else{
				System.out.println("\n\n\t\tThank you. Your pin has been successfully updated.");
			}
			System.out.println("\t\tRedirecting to the previous menu in few seconds...");
			Thread.sleep(5000);
			c.screen();
			op.UserOption(username);


		}
		else{
			Thread.sleep(3000);
			System.out.println("\n\n\t\tPins do not match. Please try again.");
			Thread.sleep(1000);
			System.out.println("\t\tRedirecting to the previous menu in few seconds...");
			Thread.sleep(3000);
			c.screen();
			op.UserOption(username);
			
		}
		

		}catch(Exception e){
			System.out.println("Error: "+e.getMessage());
		}
	}
}