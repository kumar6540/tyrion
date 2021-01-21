package com.order.store;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.order.Data.loginDTO;

@Repository
@Service("logservice")
public class Loginstore {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	 
	 
	
	  String sql="select * from login where uname=? and pass=?";
	    String sql1="insert into login (uname, pass) values(?, ?)";
		
	    
	    String url ="jdbc:mysql://localhost/college";
		String user="root";
		String password = "123456789";
		Integer i=null;
		boolean b = false;
		
		public boolean check (String uname, String pass) throws ClassNotFoundException  {


			try {
				
				
				  Class.forName("com.mysql.cj.jdbc.Driver");
				  
				  Connection conn = (Connection)
				  DriverManager.getConnection(url,user,password);
				  
				  PreparedStatement st = (PreparedStatement) conn.prepareStatement(sql);
				  
				  st.setString(1, uname); st.setString(2, pass);
				  
				  ResultSet rs= st.executeQuery();
				 
				 
			//	ResultSet rs = (ResultSet) jdbcTemplate.queryForObject(sql, new String[] {uname,pass}, loginDTO.class);
				
				
				if(rs.next()) {
					
					b=true;
					
					//conn.close();
					
				} 	
			}catch(SQLException s) {
				
				s.printStackTrace();
			}
			return b;
			
			
		
		}
		
		
		
		public int StoreCredentials(String uname, String pass) {
                 
			try {
				
				Class.forName("com.mysql.jdbc.Driver");
				
				Connection conn = (Connection) DriverManager.getConnection(url,user,password);
				
				PreparedStatement st = (PreparedStatement) conn.prepareStatement(sql1);
				
				st.setString(1, uname);
				st.setString(2, pass);
				
				System.out.println(uname +" "+pass);
				i= st.executeUpdate();
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			return i;
			
			
			
		}


}
