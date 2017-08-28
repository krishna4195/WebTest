package webtest;

import java.io.IOException;
import java.io.PrintWriter;
//	import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webtest.service.Loginservice;

@SuppressWarnings("serial")
@WebServlet("/LoginCheck")
public class LoginCheck extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String query;
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		PrintWriter printWriter = response.getWriter();
		try {
			Class.forName("org.postgresql.Driver");

			Connection con = DriverManager.getConnection(

					DbContract.HOST + DbContract.DB_NAME,

					DbContract.USERNAME,

					DbContract.PASSWORD);

			System.out.println("DB connected");
			Statement stmt = (Statement) con.createStatement();
			query = "SELECT name, password FROM Registration;";
			stmt.executeQuery(query);
			ResultSet rs = stmt.getResultSet();

			while (rs.next()) {
				rs.getString("name");
				rs.getString("password");
				Loginservice loginService = new Loginservice();
				boolean result = loginService.authenticate(username, password);
				if (result) {
					response.sendRedirect("regform.html");
					return;
				} else {
					printWriter.println("<script type=\"text/javascript\">");
					printWriter.println("alert('User or password incorrect');");
					printWriter.println("location='index.html';");
					printWriter.println("</script>");

					/*
					 * response.sendRedirect("index.html"); return;
					 */
				}
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}