package com.beingjavaguys.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.beingjavaguys.model.Employee;
import com.beingjavaguys.model.Status;
import com.beingjavaguys.model.User;
import com.beingjavaguys.services.DataServices;
import com.beingjavaguys.services.UserService;

@Controller
@RequestMapping("/employee")
public class RestController {

	static final Logger logger = Logger.getLogger(RestController.class);

	@Autowired
	DataServices dataServices;

	@Autowired
	UserService userService;

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Status addEmployee(@RequestBody Employee employee) {
		try {
			dataServices.addEntity(employee);
			return new Status(1, "Employee added Successfully !");
		} catch (Exception e) {
			// e.printStackTrace();
			return new Status(0, e.toString());
		}

	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public @ResponseBody Status deleteEmployee(@PathVariable("id") long id) {

		try {
			dataServices.deleteEntity(id);
			return new Status(1, "Employee deleted Successfully !");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}

	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody List<Employee> getEmployee() {

		List<Employee> employeeList = null;
		try {
			employeeList = dataServices.getEntityList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return employeeList;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody Employee getEmployee(@PathVariable("id") long id) {
		Employee employee = null;
		try {
			employee = dataServices.getEntityById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return employee;
	}

	@RequestMapping(value = "/string", method = RequestMethod.GET)
	@ResponseBody
	public String getTestString() {
		return "Testowa odpowied�";
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	@ResponseBody
	public List<User> getUsers() {

		List<User> users = null;
		try {
			users = userService.getAllMoodleUsers();
			logger.debug(users.size());
			System.out.println(users.size());

		} catch (Exception e) {
			logger.error(e.getMessage());
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		return users;
	}
}
