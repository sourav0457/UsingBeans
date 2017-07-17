package com.src.service.impl;

import java.sql.*;

import org.springframework.stereotype.Component;

import com.src.service.DBConnect;

/**
 * @author Sourav.Samanta
 *
 */

@Component("DBConnect")
public class DBconnection implements DBConnect {
	   String JDBC_DRIVER;  
	   String DB_URL;
	   String USER;
	   String PASS;
	  Connection conn;
	   
	   DBconnection( )
	   {
		   JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		   DB_URL = "jdbc:mysql://trainingdb.c4hhsbxtkfor.ap-south-1.rds.amazonaws.com:3306/trainingTable";
		   USER = "root";
		   PASS = "mypassword";
		   try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		   
	   }
	   
	   public Connection dbConnect()
	   {
		   conn = null;
		   try{
			   conn = DriverManager.getConnection(DB_URL, USER, PASS);
		   }catch(SQLException se){
			    return null;
		   }catch(Exception e){
			    return null;
		   }
		   return conn;
	   }
	   
	   
	   
	   
}
