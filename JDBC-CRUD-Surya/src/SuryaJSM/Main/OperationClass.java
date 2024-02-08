package SuryaJSM.Main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class OperationClass {
	
	Scanner sc = new Scanner(System.in);
	Connection con = null;
	ConnectionClass connectionObject = new ConnectionClass();
	PreparedStatement psmt = null;
	int count = 0;
public void insertRecord() throws ClassNotFoundException, SQLException {
			
		System.out.println("Enter Student UID: ");
		String studentUID = sc.nextLine();
		System.out.println("Enter Student Name: ");
		String studentName = sc.nextLine();
		System.out.println("Enter Student Course: ");
		String studentCourse = sc.nextLine();
		System.out.println("Enter Student Batch: ");
		int studentBatch = sc.nextInt();
		
	if(con == null) {
			con = connectionObject.getConnection();
		String countStatus = "select max(ID) from Student";
		PreparedStatement psmt0 = con.prepareStatement(countStatus);
		ResultSet rs = psmt0.executeQuery();
		if(rs.next()) {
			count = rs.getInt(1);
		}
		String insertQuery ="insert into student values(?,?,?,?,?)";
		

			psmt = con.prepareStatement(insertQuery);
			count+=1;
			
			psmt.setInt(1,count);
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
		psmt0.close();	
		}else {
			System.out.println("Connection already established !!");
		}
		
		psmt.close();
		con.close();
	}
	
	

public void updateRecord() throws ClassNotFoundException, SQLException {
	System.out.println("Enter student UID: ");
	String studentUID = sc.next();
	
	String searchQuery = "select * from student where studentUID = ?";
	con= connectionObject.getConnection();
	PreparedStatement psmt1= con.prepareStatement(searchQuery);
	psmt1.setString(1, studentUID);
	
	ResultSet rs= psmt1.executeQuery();
	if(rs.next()) {
		System.out.println("Student UID: "+rs.getString(2));
		System.out.println("Student Name: "+rs.getString(3));
		System.out.println("Student Course: "+rs.getString(4));
		System.out.println("Student Batch: "+rs.getInt(5));
	}
	else {
		System.out.println("No Record Found !!");
	}
	
	System.out.println("Enter updated course: ");
	String updatedCourse=sc.next();
	String updatedQuery = "update student set studentCourse = ? where studentUID =?";
	PreparedStatement  psmt2= con.prepareStatement(updatedQuery);
	psmt2.setString(1,updatedCourse);
	psmt2.setString(2,studentUID);
	
	
	int status = psmt2.executeUpdate();
	if(status>0) {
		System.out.println("Record Updated Successfully !!");
	}else {
		System.out.println("Something Went WWrong ...");
	}
	psmt1.close();
	psmt2.close();
	con.close();
	
	
  }

public void delete() throws ClassNotFoundException, SQLException {
	System.out.println("Enter student UID: ");
	String studentUID = sc.next();
	
	String searchQuery = "select * from student where studentUID = ?";
	con= connectionObject.getConnection();
	PreparedStatement psmt1= con.prepareStatement(searchQuery);
	psmt1.setString(1, studentUID);
	
	ResultSet rs= psmt1.executeQuery();
	if(rs.next()) {
		System.out.println("Student UID: "+rs.getString(2));
		System.out.println("Student Name: "+rs.getString(3));
		System.out.println("Student Course: "+rs.getString(4));
		System.out.println("Student Batch: "+rs.getInt(5));
	}
	else {
		System.out.println("No Record Found !!");
	}
	System.out.println("DO you confirm to delete the record ? 1/Yes, 0/No");
	int reply = sc.nextInt();
	if(reply==1) {
		 String deleteQuery = "Delete from student where studentUID= ?";
		 PreparedStatement psmt2 = con.prepareStatement(deleteQuery);
		 psmt2.setString(1, studentUID);
		 
		 int status1 = psmt2.executeUpdate();
		 if(status1>0) {
			 System.out.println("Record deleted succussfully !!");
		 }else {
			 System.out.println("No record found...");
		 }
	}
 }

public void display_One() throws SQLException, ClassNotFoundException {
	System.out.println("Enter student UID: ");
	String studentUID = sc.next();
	
	String searchQuery = "select * from student where studentUID = ?";
	con= connectionObject.getConnection();
	PreparedStatement psmt1= con.prepareStatement(searchQuery);
	psmt1.setString(1, studentUID);
	
	ResultSet rs= psmt1.executeQuery();
	if(rs.next()) {
		System.out.println("Student UID: "+rs.getString(2));
		System.out.println("Student Name: "+rs.getString(3));
		System.out.println("Student Course: "+rs.getString(4));
		System.out.println("Student Batch: "+rs.getInt(5));
	}
	else {
		System.out.println("No Record Found !!");
	}
	
}

public void display_All() throws ClassNotFoundException, SQLException {

	String searchQuery = "select * from student";
	con= connectionObject.getConnection();
	PreparedStatement psmt1= con.prepareStatement(searchQuery);

	
	ResultSet rs= psmt1.executeQuery();
	if(rs.next()) {
		while(rs.next()) {
			System.out.println("Student UID: "+rs.getString(2));
			System.out.println("Student Name: "+rs.getString(3));
			System.out.println("Student Course: "+rs.getString(4));
			System.out.println("Student Batch: "+rs.getInt(5));
		}
	}else {
		System.out.println("No Record Found !!");
	}
	
	
}


}












