package web.crm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;


@WebServlet("/TDBconnectoin")
public class TDBconnectoin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jdbcUrl ="jdbc:mysql://localhost:3306/web_customer_tracker";
        String sqlDriver="com.mysql.cj.jdbc.Driver";
        String username ="root";
        String password ="MysqL2022J";
		
        
        try {
        	PrintWriter out =response.getWriter();
        	out.println("Connecting to database "+jdbcUrl);
        	
        	Class.forName(sqlDriver);
        	
    	Connection myConn = DriverManager.getConnection(jdbcUrl,username,password)	;
//       	Statement stat = myConn.createStatement(); 
//      	ResultSet resultRQ2= stat.executeQuery("SELECT * FROM customer where id=1");
//        	
//			 while(resultRQ2.next()) {
//				 System.out.println("firstName : "+resultRQ2.firstName+ ("lastName")+ " "+resultRQ2.lastName + ("email")+resultRQ2.email );
//			 }
 //s     	System.out.println(resultRQ2.getRow());
        	

        	
        	System.out.println("SUCCESS!!!");
        	
        	myConn.close();
        	
        	
        }catch(Exception e) {
        	e.printStackTrace();
        		throw new ServletException(e);
        }
		
	}

}
