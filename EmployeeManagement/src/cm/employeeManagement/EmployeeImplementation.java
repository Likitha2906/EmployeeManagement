package cm.employeeManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import java.sql.SQLException;

public class EmployeeImplementation implements EmployeeInterface{

	Scanner scan=new Scanner(System.in);
	
	@Override
	public void addEmployee() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedatabase","root","Liki@29");
			PreparedStatement ps=connection.prepareStatement("insert into employee values(?,?,?,?,?)");
			System.out.println("Enter employee ID");
			ps.setInt(1, scan.nextInt());
			
			System.out.println("Enter employee name");
			ps.setString(2, scan.next());
			
			System.out.println("Enter employee phone number");
			ps.setString(3, scan.next());
			
			System.out.println("Enter employee email ID");
			ps.setString(4, scan.next());
			
			System.out.println("Enter employee DOJ");
			ps.setString(5, scan.next());
			
			ps.execute();
			connection.close();
			System.out.println("Data saved");
			
		
		}catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

	}
	
	@Override
	public void deleteEmployee() {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedatabase", "root", "Liki@29");
			PreparedStatement ps=connection.prepareStatement("delete from employee where empid=?");
			System.out.println("Enter the Id");
			ps.setInt(1, scan.nextInt());
			ps.execute();
			connection.close();
			System.out.println("Data deleted");

			
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void updateEmployee() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedatabase", "root", "Liki@29");
			System.out.println("1.update name\n2.update phno\n3.updateemail\n4.updateDOJ\nEnter your choice");
			PreparedStatement ps;
			int choice=scan.nextInt();

			switch(choice) {
			case 1:
				ps=connection.prepareStatement("update employee set empname=? where empid=?");
				System.out.println("Enter the new name");
				ps.setString(1, scan.next());
				System.out.println("Enter the id");
				ps.setInt(2, scan.nextInt());
				ps.execute();
				break;
			case 2:
				ps=connection.prepareStatement("update employee set emp_phno=? where empid=?");
				System.out.println("Enter the new phno");
				ps.setString(1, scan.next());
				System.out.println("Enter the id");
				ps.setInt(2, scan.nextInt());
				ps.execute();
				break;
			case 3:
				ps=connection.prepareStatement("update employee set emp_email=? where empid=?");
				System.out.println("Enter the new email");
				ps.setString(1, scan.next());
				System.out.println("Enter the id");
				ps.setInt(2, scan.nextInt());
				ps.execute();
				break;
			case 4:
				ps=connection.prepareStatement("update employee set emp_DOJ=? where empid=?");
				System.out.println("Enter the new DOJ");
				ps.setString(1, scan.next());
				System.out.println("Enter the id");
				ps.setInt(2, scan.nextInt());
				ps.execute();
				break;

			default:
				System.out.println("Invalid choice");
			}	
			connection.close();	
			System.out.println("updated");

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	@Override
	public void getAllEmployeeDetails() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedatabase", "root", "Liki@29");
			PreparedStatement ps=connection.prepareStatement("select * from employee");
			ResultSet resultset=ps.executeQuery();
			while(resultset.next()) {
				System.out.println("employee Id is: "+resultset.getInt(1));
				System.out.println("employee name is :"+resultset.getString(2));
				System.out.println("employee phno is: "+resultset.getString(3));
				System.out.println("employee emaiId is: "+resultset.getString(4));
				System.out.println("employee DOJ is: "+resultset.getString(5));
				System.out.println("----------------------------------");
			}
			ps.execute();
			connection.close();
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
	}


}
