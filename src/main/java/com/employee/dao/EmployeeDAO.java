package com.employee.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.employee.entity.Employee;
@Transactional
@Repository
public class EmployeeDAO implements IEmployeeDAO {
	@PersistenceContext	
	private EntityManager entityManager;	
	
	
public Employee getEmployeeById(int employeeId) {
		return entityManager.find(Employee.class, employeeId);
	}
	@SuppressWarnings("unchecked")
public List<Employee> getAllEmployees() {
		String hql = "FROM Employee as emp ORDER BY emp.employeeid";
		System.out.println("Tirumal......");
		return (List<Employee>) entityManager.createQuery(hql).getResultList();
		
	}	

	public void addEmployee(Employee employee) {
		System.out.println("...reached.....addEmployee");
		entityManager.persist(employee);
	}

	public void updateEmployee(Employee employee) {
		Employee emp = getEmployeeById(employee.getEmployeeid());
		emp.setEmployeeid(employee.getEmployeeid());
		emp.setEname(employee.getEname());
		emp.setAge(employee.getAge());
		entityManager.flush();
	}

	public void deleteEmployee(int employeeId) {
		entityManager.remove(getEmployeeById(employeeId));
	}

	public boolean EmployeeExists(int employeeId) {
		String hql = "FROM Employee as emp WHERE emp.employeeid = ?";
		int count = entityManager.createQuery(hql).setParameter(1, employeeId).getResultList().size();
		return count > 0 ? true : false;
	}
}
