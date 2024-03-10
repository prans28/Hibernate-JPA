package com.te.ems.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.te.ems.entity.Address;
import com.te.ems.entity.Employee;
import com.te.ems.entity.Technology;

public class EmployeeRepository {

	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Mysql01");
	private EntityManager entityManager = entityManagerFactory.createEntityManager();

	// Insert ,update, delete -should be packed under the transaction
	// TODO : to create a method that insert employee data in the database

	public int insertEmployee(Employee employee) {

		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();

		return employee.getEmployeeId();

	}

	// TODO : create a method to get employee data from employee
	public Employee getEmplpoyeeID_(int employeeID) {

		return entityManager.getReference(Employee.class, employeeID);

	}

	public Employee getEmplpoyeeID(int employeeID) {

		return entityManager.find(Employee.class, employeeID);

	}

	// TODO : update Technology

	public int addTechnology(int employeeId, String TechnologyName) {
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();

		Employee employeeFromDB = entityManager.getReference(Employee.class, employeeId);

		employeeFromDB.getTechnologies()
				.add(com.te.ems.entity.Technology.builder().TechnologyName(TechnologyName).build());
		entityManager.persist(employeeFromDB);

		entityTransaction.commit();

		return employeeId;

	}
//
//	public int addEmailID(int employeeId, String emailID) {
//		EntityTransaction entityTransaction = entityManager.getTransaction();
//		entityTransaction.begin();
//
//		Employee employeeFromDB = entityManager.getReference(Employee.class, employeeId);
//
//		employeeFromDB.setEmployeeEmailId(emailID);
//		entityManager.persist(employeeFromDB);
//
//		entityTransaction.commit();
//
//		return employeeId;
//
//	}
//
//	public int addCity(int employeeId, String oldCity, String updateCity) {
//
//		EntityTransaction entityTransaction = entityManager.getTransaction();
//		entityTransaction.begin();
//
//		Employee employeeFromDB = entityManager.getReference(Employee.class, employeeId);
//
//		List<Address> addresses = employeeFromDB.getAddresses();
//
//		for (Address address : addresses) {
//			if (address.getAddressCity().equalsIgnoreCase(oldCity)) {
//
//				address.setAddressCity(updateCity);
//
//			}
//
//		}
//		entityManager.persist(employeeFromDB);
//		entityTransaction.commit();
//
//		return employeeId;
//
//	}

	public List<Employee> tech(String tech) {

		Technology technology = entityManager.getReference(Technology.class, tech);
		if (technology == null)
			return null;

		return technology.getEmployee();

	}

	public void addCity(int employeeID, String string, String string2) {
		// TODO Auto-generated method stub
		
	}

}
