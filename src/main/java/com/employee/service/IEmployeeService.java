package com.employee.service;

import java.util.List;

import com.employee.entity.Employee;

public interface IEmployeeService {
	 List<Employee> getAllEmployees();
     Employee getEmployeeById(int employeeid);
     boolean addEmployee(Employee employee);
     void updateEmployee(Employee employee);
     void deleteEmployee(int employeeid);
     
     

}
