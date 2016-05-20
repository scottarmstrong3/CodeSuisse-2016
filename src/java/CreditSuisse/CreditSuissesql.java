package CreditSuisse;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hiriakc
 */

    import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




// Adapted from http://www.vogella.com/tutorials/MySQLJava/article.html
public class CreditSuissesql {

	     // JDBC driver name and database URL
	     static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	     static final String DB_URL = "jdbc:mysql://localhost/CodeSuisse";

	     //  Database credentials
	     static final String USER = "root";
	     static final String PASS = "Skicellogolf18";
	     
	     public static void main(String[] args) {
	     Connection conn = null;
	     Statement stmt = null;
	     try{
	        //STEP 2: Register JDBC driver
	        Class.forName("com.mysql.jdbc.Driver");

	        //STEP 3: Open a connection
	        System.out.println("Connecting to database...");
	        conn = DriverManager.getConnection(DB_URL,USER,PASS);

	        //STEP 4: Execute a query
	        System.out.println("Creating statement...");
	        stmt = conn.createStatement();
	        String sql;
	        sql = "SELECT SCREEN, column_3, column_4, column_5 FROM CodeSuisse.company_data_Table_1";
	        ResultSet rs = stmt.executeQuery(sql);

	        //STEP 5: Extract data from result set
	        while(rs.next()){
	           //Retrieve by column name
	           String SCREEN  = rs.getString("SCREEN");
	           String column_3 = rs.getString("column_3");
	           String column_4 = rs.getString("column_4");
	           String column_5 = rs.getString("column_5");

	           //Display values
	           System.out.print("Stock name: " + SCREEN);
	           System.out.print(", Abbreviation: " + column_3);
	           System.out.print(", Country: " + column_4);
	           System.out.println(", Market Capitalization: " + column_5);
	        }
	        //STEP 6: Clean-up environment
	        rs.close();
	        stmt.close();
	        conn.close();
	     }catch(SQLException se){
	        //Handle errors for JDBC
	        se.printStackTrace();
	     }catch(Exception e){
	        //Handle errors for Class.forName
	        e.printStackTrace();
	     }finally{
	        //finally block used to close resources
	        try{
	           if(stmt!=null)
	              stmt.close();
	        }catch(SQLException se2){
	        }// nothing we can do
	        try{
	           if(conn!=null)
	              conn.close();
	        }catch(SQLException se){
	           se.printStackTrace();
	        }//end finally try
	     }//end try
	     System.out.println("Goodbye!");
	  }//end main
	  }//end FirstExample

    

