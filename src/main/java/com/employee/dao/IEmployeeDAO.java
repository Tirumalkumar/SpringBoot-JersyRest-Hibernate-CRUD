package com.employee.dao;

import java.util.List;
import com.employee.entity.Employee;
public interface IEmployeeDAO {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(int employeeid);
    void addEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployee(int employeeid);
    boolean EmployeeExists(int employeeid);
}
 