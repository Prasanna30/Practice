	package com.prasanna.example.CodingChallenge1;

import java.util.ArrayList;
import java.util.List;

import com.prasanna.example.CodingChallenge1.Models.Department;
import com.prasanna.example.CodingChallenge1.Models.Employee;

/**
 * Hello world!
 *
 */
public class App {
	
	
	public static Employee createDeveloper() {
		return new Employee("Developer", 2000,null);
	}
	
	public static Employee createQATester() {
		return new Employee("QA Tester", 1000,null);
	}
	
	public static Employee createManager(List<Employee> emps) {
		return new Employee("Manager",600,emps);
	}
	

	public static Department loadDepartment() {
		Department department = new Department();

		List<Employee> reporteesOfB = new ArrayList<Employee>();
		reporteesOfB.add(createDeveloper());
		reporteesOfB.add(createQATester());
		Employee managerB = createManager(reporteesOfB);
		
		List<Employee> reporteesOfA = new ArrayList<Employee>();
		reporteesOfA.add(managerB);
		Employee managerA = createManager(reporteesOfA);

		
		
		Employee managerD = createManager(null);
		
		//Employee manager

		List<Employee> employesOfC = new ArrayList<Employee>();
		employesOfC.add(managerD);
		
		Employee managerC = createManager(employesOfC);


		List<Employee> reporteesOfE = new ArrayList<Employee>();
		reporteesOfE.add(createDeveloper());
		Employee managerE = createManager(reporteesOfE);

		List<Employee> managers = new ArrayList<Employee>();
		managers.add(managerA);
		managers.add(managerE);
		managers.add(managerC);

		department.setEmployees(managers);
		
		
		System.out.println("Manager A's Cost: "+ costOfEmployee(managerA));
		System.out.println("Manager B's Cost: "+ costOfEmployee(managerB));
		System.out.println("Manager C's Cost: "+ costOfEmployee(managerC));
		System.out.println("Manager D's Cost: "+ costOfEmployee(managerD));
		System.out.println("Manager E's Cost: "+ costOfEmployee(managerE));

		return department;
	}

	public static int costOfDepartment(Department dept) {
		int totalcost = 0;

		for (Employee e : dept.getEmployees()) {
			totalcost += costOfEmployee(e);
		}

		return totalcost;
	}

	public static int costOfEmployee(Employee emp) {
		int totalCost = emp.getMonthlyCost();
		if (emp.getReportees() != null) {
			for (Employee e : emp.getReportees()) {
				totalCost += costOfEmployee(e);
			}
		}
		return totalCost;
	}

	public static void main(String[] args) {
		Department dept = loadDepartment();
		int cost = costOfDepartment(dept);
		System.out.println("cost of dept " + cost);
		
		
		

	}
}
