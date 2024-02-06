package SuryaJSM.Main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		OperationClass op = new OperationClass();
		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("Enter 1 for insert record");
			System.out.println("Enter 2 for delete record");
			System.out.println("Enter 3 for update record");
			System.out.println("Enter 4 for display_One record");
			System.out.println("Enter 5 for display_All record");
			int reply = sc.nextInt();
			
			switch(reply) {
			case 1:
				op.insertRecord();
				break;
			case 2:
				op.delete();
				break;
			case 3:
				op.updateRecord();
				break;
			case 4:
				op.display_One();
				break;
			case 5:
				op.display_All();
				break;
			default:
				System.out.println("Invalid Input");
			}}while(true);
		}
	
	
}
	


