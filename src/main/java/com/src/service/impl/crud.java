package com.src.service.impl;

import java.sql.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.src.service.CrudOperations;
import com.src.service.DBConnect;


/**
 * @author Sourav.Samanta
 *
 */
@Component("CrudOperations")
public class crud implements CrudOperations{
	
	/*public crud(DBConnect dbConnect) {
		super();
		this.dbConnect = dbConnect;
	}*/

	DBConnect db;
	Connection con;
	Statement stmt;
	
	@Autowired
	private DBConnect dbConnect;
	//private static ApplicationContext ctx;
	
	/*public void setBeanData(DBConnect dbConnect){
		this.dbConnect=dbConnect;
	}*/
	
	/*static{
		ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
	}
	
	crud(){
		db = (DBConnect)ctx.getBean("DBConnect");	//Syntax: ctx.getBean(id_of_bean)
	}*/
	
	public void create(String query){
		
		con = dbConnect.dbConnect();
		if(con!=null){
			try {
				stmt=con.createStatement();
				stmt.executeUpdate(query);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally{
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public void insert(String query){
		con = db.dbConnect();
		if(con!=null){
			try {
				stmt=con.createStatement();
				stmt.executeUpdate(query);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally{
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void delete(String query){
		con = db.dbConnect();
		if(con!=null){
			try {
				stmt=con.createStatement();
				stmt.executeUpdate(query);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally{
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void selectvalues() throws ClassNotFoundException {
		
		con = db.dbConnect();
		if(con!=null){
			try{
				stmt = con.createStatement();
			    
				String sql = "SELECT * FROM SOURAV" ;
				ResultSet rs = stmt.executeQuery(sql); 

				while(rs.next()){
			        //Retrieve by column name
			        int id  = rs.getInt("id");
			     
			        String name = rs.getString("name");
			        

			        //Display values
			        System.out.print("ID: " + id);
			       
			        System.out.print("Name: " + name);
			        
				}
			    
				}
				catch(SQLException se){
					   
				    se.printStackTrace();
				 }
			finally{
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
	}

}
