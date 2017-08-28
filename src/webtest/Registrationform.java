package webtest;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Registrationform
 */
@WebServlet("/Registrationform")
public class Registrationform extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		   response.setContentType("text/html;charset=UTF-8");
		//PrintWriter out = response.getWriter();
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String dateofbirth =request.getParameter("dateofbirth");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String aadhaar = request.getParameter("aadhaar");
		String username = request.getParameter("username");
		String address = request.getParameter("address");
		String jobcategory = request.getParameter("jobcategory");
		String passedout = request.getParameter("passedout");
		String cgpa = request.getParameter("cgpa");
		String yearsofexperience = request.getParameter("yearsofexperience");
		String domain = request.getParameter("domain");
		

		System.out.println("Details entered" );
		

		
		try {


		           Class.forName("org.postgresql.Driver");

		           Connection con = DriverManager.getConnection(

		                   DbContract.HOST+DbContract.DB_NAME,

		                   DbContract.USERNAME,

		                   DbContract.PASSWORD);

		            

		           System.out.println("DB connected");
		           
		PreparedStatement ps = con.prepareStatement("INSERT INTO registrationform VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

		ps.setString(1,firstname);
		ps.setString(2,lastname);
		ps.setString(3,dateofbirth);
		ps.setString(4,gender);
		ps.setString(5,email);
		ps.setString(6,mobile);
		ps.setString(7,aadhaar);
		ps.setString(8,username);
		ps.setString(9,address);
		ps.setString(10,jobcategory);
		ps.setString(11,passedout);
		ps.setString(12,cgpa);
		ps.setString(13,yearsofexperience);
		ps.setString(14,domain);
		ps.executeUpdate();
		System.out.println("Values entered in the database");
		response.sendRedirect("success.html");
		

		} catch (Exception se) {
		se.printStackTrace();
		} 


	}

}
