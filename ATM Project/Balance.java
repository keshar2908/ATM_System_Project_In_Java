import java.util.*;
import java.sql.*;
public class Balance{
	public void Check(String name){
		String uname = name;
		Welcome wc = new Welcome();
		Option op = new Option();
		Clear c = new Clear();
		Scanner sc = new Scanner(System.in);
		try{
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/pin","root","");
			Statement stmt = cn.createStatement();
			String sql = "SELECT *FROM surya WHERE name ='"+uname+"'";
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				String balance = rs.getString("Amount");
				for (int space=0;space<=3;space++){
					System.out.println("\n");
				}
				
				System.out.print("\t\tPlease wait. System is checking database.");
				for(int count=1;count<=5;count++){
					Thread.sleep(1000);
					System.out.print(".....");
				}
				c.screen();
				System.out.println("\n\n\t\tYour current balance is: "+balance+"\n\n\n");
				Thread.sleep(2000);
				System.out.print("\t\t\t\tDo you want to continue??\n\t\t\t\t");
				for(int count=1;count<=25;count++){
					System.out.print(".");
				}
				System.out.println("\n\n\n\n\t\t\t\t1. Yes\t\t\t\t2. No");
				System.out.print("\n\n\n\nChoose an option: ");
				int input = Integer.parseInt(sc.nextLine());
				for (int space=0;space<=3;space++){
					System.out.println("\n");
				}
				if(input==1){
					System.out.print("\n\n\t\tYou'll be redirected to previous menu in 5 seconds.\n\t\tPlease wait.");
					for(int count=1;count<=5;count++){
						Thread.sleep(1000);
						System.out.print(".....");
					}
					c.screen();
					op.UserOption(uname);
				}
				else if (input==2){
					wc.Shutdown();
					
				}
				else{
					System.out.println("\t\tSorry. The system halted.");
					System.out.print("\t\tYou'll be redirected to previous menu in 5 seconds.\n\t\tPlease wait.");
					for(int count=1;count<=5;count++){
						Thread.sleep(1000);
						System.out.print(".....");
					}
					c.screen();
					System.out.println("\n");
					op.UserOption(uname);
				}
			}

		}catch(Exception e){
			System.out.println("Error: "+e.getMessage());
		}
	}
}