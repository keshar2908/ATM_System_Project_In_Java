import java.util.*;
public class Option{
	public void UserOption(String name){
		String uname = name;
		Scanner sc = new Scanner(System.in);
		Welcome wc = new Welcome();
		Option op = new Option();
		Database db = new Database();
		Balance bl = new Balance();
		Ministmt ms = new Ministmt();
		Withdraw wd = new Withdraw();
		System.out.print("\n\n\n\t\t\t\tWhat do you want to do??\n\t\t\t\t");
		for(int count=1;count<=24;count++){
			System.out.print(".");
		}
		System.out.println("\n\n\n\t1. Balance Enquiry\t\t\t\t2. Mini Statement");
		System.out.println("\t3. Withdrawl\t\t\t\t\t4. Change Pin");
		System.out.println("\t5. Exit\n\n");
		System.out.print("Input: ");
		int input = Integer.parseInt(sc.nextLine());
		for (int space=0;space<=1;space++){
					System.out.println("\n");
				}
		switch(input){
			case 1:
				bl.Check(uname);
				break;

			case 2:
				ms.Ministat(uname);
				break;

			case 3:
				wd.Withdraw(uname);
				break;

			case 4:
				db.changePin(uname);
				break;

			case 5:
				wc.Shutdown();

			default:
				System.out.println("Please enter a valid option.");
				try{
					Thread.sleep(2000);
				}catch(Exception e){
					System.out.println("Error: "+e.getMessage());
				}
				op.UserOption(uname);

		}
	}
}