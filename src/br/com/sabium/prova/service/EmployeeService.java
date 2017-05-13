package br.com.sabium.prova.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;

import br.com.sabium.prova.dao.EmployeeDao;
import br.com.sabium.prova.model.Employee;

@Path("/employeeService")
public class EmployeeService {
	
	@GET
	@Path("/employeesOnSeveralProjects")
	@Produces("application/json")
	public Response findEmployeesOnSeveralProjects() throws JSONException {
		JSONObject jsonObject = new JSONObject();
		EmployeeDao dao = new EmployeeDao();
		List<Employee> employees = dao.findEmployeesOnSeveralProjects();
		jsonObject.put("employees", employees);
		return Response.status(200).entity(jsonObject).build();
	}

}
