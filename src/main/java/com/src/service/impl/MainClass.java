package com.src.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.src.service.CrudOperations;
import com.src.service.DBConnect;


/**
 * @author Sourav.Samanta
 *
 */

@Component("auto")
public class MainClass {
	
	public static ApplicationContext ctx;
	
	@Autowired
	private CrudOperations db;
	
	static{
		//ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		ctx = new AnnotationConfigApplicationContext(ConfigurationClass.class);
		
	}
	
	public void execute(){
		db = (CrudOperations)ctx.getBean("CrudOperations");
		DBConnect dbConnectconnect=(DBConnect)ctx.getBean("DBConnect");
		//db.setBeanData(dbConnectconnect);
		String insertQuery;
		
		//String dropQuery="DROP TABLE SOURAV IF EXISTS;";
		//db.insert(dropQuery);
		
		
		String createQuery;
				createQuery = "CREATE TABLE SOURAV12 " +
                "(id INTEGER not NULL, " +
                " name VARCHAR(255), " + 
                " PRIMARY KEY ( id ));";
		db.create(createQuery);
		
		insertQuery = "INSERT INTO SOURAV " +
          		"VALUES (1, 'Sourav');";
		db.insert(insertQuery);
		insertQuery = "INSERT INTO SOURAV " +
                "VALUES (2, 'Samith');";
		db.insert(insertQuery);
		insertQuery = "INSERT INTO SOURAV " +
                "VALUES (3, 'Shrey');";
		db.insert(insertQuery);
		insertQuery = "INSERT INTO SOURAV " +
                "VALUES (4, 'Prakhar');";
		db.insert(insertQuery);
		insertQuery = "INSERT INTO SOURAV " +
                "VALUES (5, 'Praveen');";
		db.insert(insertQuery);*/
		try {
			db.selectvalues();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void main(String args[]){
		MainClass main = (MainClass)ctx.getBean("auto");
		main.execute();
	}
		
		
}
