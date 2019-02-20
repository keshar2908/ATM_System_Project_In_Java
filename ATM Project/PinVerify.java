import java.util.*;
import java.sql.*;
public class PinVerify extends Main{
	public void VerifyPin(){
		Scanner sc = new Scanner(System.in);
		Welcome wc = new Welcome();
		Option op = new Option();
		Clear c = new Clear();
		try{
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/pin","root","");
			Statement stmt = cn.createStatement();
			int i;
			for (int space=0;space<=3;space++){
					System.out.println("\n");
				}
			for(i=1;i<=3;i++){
				System.out.print("Please enter your 4 digit pin: ");
				String pin = sc.nextLine();
				System.out.print("\n\n");
				System.out.print("\t\tVerifying pin. Please wait");
				for(int count=1;count<=20;count++){
					System.out.print(".");
					Thread.sleep(100);
				}
				String sql = "SELECT *FROM surya WHERE pin = '"+pin+"'";
				ResultSet rs = stmt.executeQuery(sql);
				if(rs.next()){
					String uname = rs.getString("name");
					c.screen();
					for (int space=0;space<=2;space++){
						System.out.println("\n");
					}
					
					System.out.print("\t\t\t\tWelcome "+uname);
					System.out.print("\n\t\t\t\t");
					for(int count=1;count<=14;count++){
						System.out.print(".");
						Thread.sleep(100);
					}
					op.UserOption(uname);
					break;
				}
				else{
					for (int space=0;space<=2;space++){
					System.out.println("\n");
				}
					System.out.println("\t\tSorry. Wrong Pin.");
					for (int space=0;space<=2;space++){
					System.out.println("\n");
				}
					continue;
				}

			}
			
				
			if(i==4){
				System.out.println("\t\tSorry. You entered the wrong pin for three times. So your pin has been blocked for 15 minutes.");
				Thread.sleep(3000);
				System.out.println("\t\tPlease come back later.");
				Thread.sleep(1000);
				for(i=1;i<=50;i++){
					for (int space=0;space<=3;space++){
					System.out.println("\n");
				}
					System.out.print("Enter 0 to exit: ");
					int zero = Integer.parseInt(sc.nextLine());
					if(zero==0){
						wc.Shutdown();
						
					}else{
						continue;
					}
				}
			}
		}catch(Exception e){
			System.out.println("Error: "+e.getMessage());
		}
	}
}