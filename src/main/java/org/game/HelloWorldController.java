package org.game;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HelloWorldController {
	String message = "Welcome to Spring, ";

	@RequestMapping("/admission")
	public ModelAndView getForm() {
		// System.out.println("in controller");
		ModelAndView mv = new ModelAndView("form1");
		return mv;
	}

	@RequestMapping(value = "/admissionForm", method = RequestMethod.POST)
	public ModelAndView submitAdmissionForm(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		// System.out.println("in controller");
		
		ModelAndView mv = new ModelAndView("hello");
		mv.addObject("message", message);
		mv.addObject("name", name);
		return mv;
	}

	@RequestMapping("/db")
	public String db() {
		final String dbUrl = "jdbc:mysql://localhost/test";
		final String dbClass = "com.mysql.jdbc.Driver";
		final String query = "select * from answer";
		final String username = "root";
		final String password = "root";
		try {
			Class.forName(dbClass);
			Connection connection = DriverManager.getConnection(dbUrl,
					username, password);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				String tableName = resultSet.getString(1);
				System.out.println("Table name : " + tableName);
			}
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "hello";
	}
	
}
