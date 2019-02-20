import java.util.*;
import java.sql.*;
public class Withdraw{
	public void Withdraw(String name){
		String uname = name;
		Option op = new Option();
		newBlnc nb = new newBlnc();
		try{
			Clear c = new Clear();
			Scanner sc = new Scanner(System.in);
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/pin","root","");
			Statement stmt = cn.createStatement();
			String sql = "SELECT *FROM surya WHERE name= '"+uname+"'";
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				int balance = rs.getInt("amount");
				for (int space=0;space<=3;space++){
					System.out.println("\n");
				}
				System.out.print("Enter amount that you want to widthdraw: ");
				
				int withdraw = Integer.parseInt(sc.nextLine());
				System.out.print("\n\t\tPlease wait while the system is checking your current balance details...");
				for(int count=1;count<=5;count++){
						Thread.sleep(1000);
						System.out.print("...");
					}
				
				if((withdraw>=1)&&(balance>=withdraw)){
					String pin = rs.getString("pin");
					System.out.print("\n\n\nPlease enter your pin for verification before withdraw: ");
				
					String pin1 = sc.nextLine();
					System.out.println("Verifying pin...");
					Thread.sleep(3000);
					if(pin.equals(pin1)){
						int newblnc = balance-withdraw;
						sql ="UPDATE surya SET amount='"+newblnc+"' WHERE name = '"+uname+"'";
						stmt.executeUpdate(sql);
						
						System.out.println("\n\n\n\t\tRs. "+withdraw+" has been withdrawn from your account.");
						nb.Checkblnc(uname);
						Thread.sleep(5000);
						c.screen();
						op.UserOption(uname);
					}
					else{
						System.out.println("\n\n\n\t\tSorry. Pin cannot be verified. Please try again.");
						Thread.sleep(3000);
						c.screen();
						op.UserOption(uname);
					}
				}
				else if((withdraw<1)&&(balance>=withdraw)){
						System.out.println("\n\n\n\t\tPlease enter a valid amount for withdraw.\n");
						Thread.sleep(3000);
						c.screen();
						op.UserOption(uname);
					}
				else{
					
					System.out.println("\n\n\n\t\tSorry. There is no sufficient balance in your account.");
					System.out.println("\t\tPlease check your balance and try again later.\n");
					Thread.sleep(3000);
					c.screen();
					op.UserOption(uname);
				}

			}
		}catch(Exception e){
			System.out.println("Error: "+e.getMessage());
		}
	}
}