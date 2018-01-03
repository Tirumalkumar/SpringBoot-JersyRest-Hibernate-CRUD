package com.employee.endpoint;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.employee.entity.Employee;
import com.employee.service.IEmployeeService;

@Component
@Path("/employee")
public class EmployeeEndpoint {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeEndpoint.class);	
	@Autowired
	private IEmployeeService employeeService;
	@GET
	@Path("/detailsall")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEmployeeDetails() {
		List<Employee> list = employeeService.getAllEmployees(); 
		return Response.ok(list).build();
	}
	@GET
	@Path("/getEmp/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEmployeeById(@PathParam("id") Integer id) {
		Employee employee = employeeService.getEmployeeById(id);
		return Response.ok(employee).build();
	}
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addEmployee(@RequestBody Employee employee) {
        boolean isAdded = employeeService.addEmployee(employee);
        if (!isAdded) {
        	logger.info("Employee already exits.");
	        return Response.status(Status.CONFLICT).build();
        }
        return Response.created(URI.create("/spring-app/employee/"+ employee.getEmployeeid())).build();
	}	
	@PUT
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)	
	public Response updateEmployee(@RequestBody Employee employee) {
		employeeService.updateEmployee(employee);
		return Response.ok(employee).build();
	}
	@DELETE
	@Path("/deleteEmp/{id}")
	@Consumes(MediaType.APPLICATION_JSON)		
	public Response deleteEmployee(@PathParam("id") Integer id) {
		employeeService.deleteEmployee(id);
		return Response.noContent().build();
	}	

}
