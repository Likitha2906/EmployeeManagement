package cm.employeeManagement;

import java.util.Scanner;

public class Employee {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		EmployeeInterface emp= new EmployeeImplementation();
		
		while(true) {
			System.out.println("EmpoyeeDatabase");
			System.out.println("1.AddEmployee\n2.DeleteEmployee\n3.UpdateEmployee\n4.GetAllEmployeeDetails");
			System.out.println("Enter your choice");
			int choice=scan.nextInt();
			switch(choice) {
			case 1:
				emp.addEmployee();
				break;
			case 2:
				emp.deleteEmployee();
				break;
			case 3:
				emp.updateEmployee();
				break;
			case 4:
				emp.getAllEmployeeDetails();
				break;
			default:
				System.out.println("Invalid choice");
			}
		}
		
	}

}
