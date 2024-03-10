package com.te.ems;

import java.util.ArrayList;
import java.util.List;

import com.te.ems.entity.Address;
import com.te.ems.entity.BankAccount;
import com.te.ems.entity.Employee;
import com.te.ems.entity.Technology;
import com.te.ems.repository.EmployeeRepository;

public class Application {

	public static void main(String[] args) {

		EmployeeRepository employeeRepository = new EmployeeRepository();
		Address address1 = Address.builder().addressCity("Chennai").addressState("Tamilnadu").build();
		Address address2 = Address.builder().addressCity("Bangalore").addressState("Karnataga").build();

		List<Address> addresses = new ArrayList<Address>();
		addresses.add(address2);
		addresses.add(address1);

		BankAccount bankAccount = BankAccount.builder().bankAccountNumber(1234567).bankIfsc("hadfc123").build();

		Technology technology1 = Technology.builder().TechnologyName("java").build();
		Technology technology2 = Technology.builder().TechnologyName("Python").build();

		List<Technology> technologies = new ArrayList<Technology>();
		technologies.add(technology1);
		technologies.add(technology2);

//		Employee employee = Employee.builder().employeeEmailId("mk@gmail").employeeName("A").bankAccount(bankAccount)
//				.addresses(addresses).technologies(technologies).build();
		
		 Employee employee=new Employee();
		 employee.setEmployeeName("Chotu");
		 employee.setAddresses(addresses);
		 employee.setBankAccount(bankAccount);
		 employee.setEmployeeEmailId("mk@gmail");
		 employee.setTechnologies(technologies);
		
		
		

		List<Employee> employees = new ArrayList<Employee>();
		employees.add(employee);
//
		technology1.setEmployee(employees);
		technology2.setEmployee(employees);

		address1.setEmployee(employee);
		address2.setEmployee(employee);
		bankAccount.setEmployee(employee);

		int employeeID = employeeRepository.insertEmployee(employee);

		employeeRepository.addTechnology(employeeID, "c#");
//		employeeRepository.addEmailID(employeeID, "ss@outlook.in");
		employeeRepository.addCity(employeeID, "Chennai", "coimbatore");
		
		  List<Employee> tech = employeeRepository.tech("java");
		
		for (Employee employee2 : tech) {
			
			System.out.println();
			System.out.println(employee2.getEmployeeName() );
		}

//		
//		Employee e1 = employeeRepository.getEmplpoyeeID(1);
//		System.out.println(e1);
//		
//		Employee e2 = employeeRepository.getEmplpoyeeID_(1);
//		System.out.println(e2);
	}

}
