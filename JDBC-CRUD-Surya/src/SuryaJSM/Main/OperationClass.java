package SuryaJSM.Main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


public class OperationClass {
	Scanner sc = new Scanner(System.in);
	Connection con = null;
	ConnectionClass connectionObject = new ConnectionClass();
	PreparedStatement psmt =null;
	public void insertRecord() throws ClassNotFoundException, SQLException {

		
		System.out.println("Enter Student UID: ");
		String studentUID = sc.nextLine();
		System.out.println("Enter Student Name: ");
		String studentName = sc.nextLine();
		System.out.println("Enter Student Course: ");
		String studentCourse = sc.nextLine();
		System.out.println("Enter Student Batch: ");
		int studentBatch = sc.nextInt();
		String insertQuery ="insert into student values(?,?,?,?,?)";
		int count =0;
		if(con == null) {
			con = connectionObject.getConnection();
			psmt = con.prepareStatement(insertQuery);
			count+=1;
			psmt.setInt(1,15);
			psmt.setString(2, studentUID);
			psmt.setString(3, studentName);
			psmt.setString(4, studentCourse);
			psmt.setInt(5, studentBatch);
			int status = psmt.executeUpdate();
			if(status > 0) {
				System.out.println("Record inserted successfully: "+ status);
			}
			else {
				System.out.println("No record inserted !!");
			}
			
		}else {
			System.out.println("Connection already established !!");
		}
		psmt.close();
		con.close();
	}

}
