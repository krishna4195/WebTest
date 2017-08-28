package webtest.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webtest.DbContract;

/**
 * Servlet implementation class Display
 */
@WebServlet("/Display")
public class Display extends HttpServlet {
	private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest res, HttpServletResponse response) throws ServletException, IOException {

    	PrintWriter out = response.getWriter();
		response.setContentType("text/html");
        out.println("<html><body>");
        try {
        	Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection(

                    DbContract.HOST+DbContract.DB_NAME,

                    DbContract.USERNAME,

                    DbContract.PASSWORD);


            System.out.println("Display DB connected");
            Statement stmt = (Statement) con.createStatement();         
            ResultSet res1= stmt.executeQuery("SELECT * FROM registrationform");
            out.println("<table border=1 width=50% height=50%>");
            out.println("<tr><th>FirstName</th><th>LastName</th><th>Dateofbirth</th><th>Gender</th><th>Emailid</th><th>Mobile</th><th>Aadhaar</th><th>UserName</th><th>Address</th><th>JobCategory</th><th>PassedOutYear</th><th>CGPA</th><th>YearOfExperience</th><th>Domain</th></tr>");
            while (res1.next()) {
               /* String n = rs.getString("empid");
                String nm = rs.getString("empname");
                int s = rs.getInt("sal"); */
            	String firstname = res1.getString("firstname");
        		String lastname = res1.getString("lastname");
        		String dateofbirth =res1.getString("dateofbirth");
        		String gender = res1.getString("gender");
        		String email = res1.getString("emailid");
        		String mobile = res1.getString("mobile");
        		String aadhaar = res1.getString("aadhar");
        		String username = res1.getString("username");
        		String address = res1.getString("address");
        		String jobcategory = res1.getString("jobcategory");
        		String passedout = res1.getString("passedoutyear");
        		String cgpa = res1.getString("cgpa");
        		String yearsofexperience = res1.getString("yearofexperience");
        		String domain = res1.getString("domainofwork");
                out.println("<tr><td>"+firstname+"</td><td>"+lastname+"</td><td>"+dateofbirth+"</td><td>"+gender+"</td><td>"+email+"</td><td>"+mobile+"</td><td>"+aadhaar+"</td><td>"+username+"</td><td>"+address+"</td><td>" +jobcategory+"</td><td>"+passedout+"</td><td>" +cgpa+"</td><td>"+yearsofexperience+"</td><td>"+domain+"</td></tr>"); 
            }
            out.println("</table>");
            out.println("</html></body>");
            con.close();
           }
            catch (Exception e) {
            out.println("error");
        }
        
        
        
        
        
        
        
		/*response.getWriter().append("Served at: ").append(request.getContextPath());*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
}
