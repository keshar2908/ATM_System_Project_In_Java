import java.sql.*;
import java.util.*;
public class Database{
	public void changePin(String name){
		String uname = name;
		Scanner sc = new Scanner(System.in);
		Option op = new Option();
		Update up = new Update();
		try{
			Clear c = new Clear();
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/pin","root","");
			Statement stmt = cn.createStatement();
			String sql = "SELECT *FROM surya WHERE name ='"+uname+"'";
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				String pin = rs.getString("pin");
				for(int i=1;i<=3;i++){
					System.out.print("Please enter your pin for the verification: ");
				
					String pin1 = sc.nextLine();
					System.out.println("\t\tSystem is checking database. Please wait...");
					Thread.sleep(3000);
					if(pin1.equals(pin)){
						System.out.println("\n\n\t\tYour pin has been verified.");
						c.screen();
						up.Info(uname);
						break;

				
					}else{
						System.out.println("\n\n\t\tPin not verified.");
						continue;
					}

				}
				System.out.println("\n\t\tYou entered wrong pin for three times.");
				Thread.sleep(2000);
				System.out.println("\n\t\tPlease wait for 5 seconds.\n\t\tYou'll be redirected to previous menu...\n\n");
				Thread.sleep(5000);
				c.screen();
				op.UserOption(uname);


			}



		}catch(Exception e){
			System.out.println("Error: "+e.getMessage());
		}
	}
}