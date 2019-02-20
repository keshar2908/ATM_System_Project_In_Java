import java.util.*;
public class Welcome{
	public void WelcomeScreen(){
		Welcome wc = new Welcome();
		Clear c = new Clear();
		PinVerify pv = new PinVerify();
		try{
			c.screen();
		}catch(Exception e){
			System.out.println("Error: "+e.getMessage());
		}
		Scanner sc = new Scanner(System.in);
		for(int space=0;space<=2;space++){
			System.out.println("\n");
		}
		System.out.print("\t\t\t\tWelcome to the ATM program created by Surya Ghising.\n\t\t\t\t");
		for(int count=1;count<=51;count++){
			System.out.print(".");
			try{
				Thread.sleep(100);
			}catch(Exception e){
				System.out.println("Error: "+e.getMessage());
			}
		}
		for (int space=0;space<=2;space++){
			System.out.println("\n");
		}
		System.out.print("\t\t\t\tPlease select an option\n\t\t\t\t");
		for(int count=1;count<=24;count++){
			System.out.print(".");
		}
		System.out.println("\n\n\n\n\t\t1. Enter your Pin \t\t\t\t2. Cancel");
		for (int space=0;space<=3;space++){
			System.out.print("\n");
		}
		System.out.print("Option: ");
		int a = Integer.parseInt(sc.nextLine());
		switch(a){
			case 1:
				pv.VerifyPin();
				break;

			case 2:
				wc.Shutdown();

			default:
				System.out.println("\t\tInvalid input. System halted.");
				try{
					Thread.sleep(1000);
				}catch(Exception e){
					System.out.println("Error: "+e.getMessage());
				}
				System.out.println("\t\tSystem restarts...");
				try{
					Thread.sleep(2000);
				}catch(Exception e){
					System.out.println("Error: "+e.getMessage());
				}
				wc.WelcomeScreen();
		}
	}	
	public void Shutdown(){
		System.out.print("\n\n\t\t\t**********Thank you for using this ATM Machine.**********\n\t\t\t\t");
		System.out.print("  ");
		for(int count=1;count<=37;count++){
			System.out.print(".");
		}
		try{
			Thread.sleep(1000);
		}catch(Exception e){
			System.out.println("Error: "+e.getMessage());
		}
		System.out.println("\n\n\n\n\t\tHope to see you soon. \n\n\t\tThe system will automatically shutdown in 5 seconds...");
		for(int count=5;count>=1;count--){
			System.out.println("\t\t"+count);
			try{
				Thread.sleep(1000);
			}catch(Exception e){
				System.out.println("Error: "+e.getMessage());
			}
		}
		System.out.println("\n\n\n\n\n");
		System.exit(0);
	}
}