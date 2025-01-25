package com.htc.servlet.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.htc.servlet.Dao.EmployeeDao;
import com.htc.servlet.Entity.Employee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<a href='index.html'>Add New Employee</a>");
		out.println("<h1>Employees List</h1>");
		
		List<Employee> list=EmployeeDao.getAllEmployees();
		
		out.print("<table border='1' width='100%'");
		out.print("<tr><th>Id</th>"
				+ "<th>Name</th>"
				+ "<th>Password</th>"
				+ "<th>Email</th>"
				+ "<th>Country</th>"
				+ "<th>Edit</th>"
				+ "<th>Delete</th>"
				+ "</tr>");
		for(Employee e:list){
			out.print("<tr><td>"+e.getEmpId()+"</td>"
					+ "<td>"+e.getName()+"</td>"
							+ "<td>"+e.getPassword()+"</td>"
									+ "<td>"+e.getEmail()+"</td>"
											+ "<td>"+e.getCountry()+"</td>"
													+ "<td><a href='EditServlet?id="+e.getEmpId()+"'>edit</a></td>"
															+ "<td><a href='DeleteServlet?id="+e.getEmpId()+"'>delete</a></td>"
																	+ "</tr>");
		}
		out.print("</table>");
		
		out.close();
	}
}
