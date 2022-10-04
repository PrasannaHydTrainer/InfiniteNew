package com.java.jsf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
@ManagedBean
@RequestScoped
public class User {

	 int id;
	    String name;
	    String email;
	    String password;
	    String gender;
	    String address;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
	    Connection connection;
		public Connection getConnection(){
	        try{
	            Class.forName("com.mysql.cj.jdbc.Driver");   
	            connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/Users","root","root");
	        }catch(Exception e){
	            System.out.println(e);
	        }
	        return connection;
	    }
		
		 public ArrayList<User> usersList(){
		        ArrayList<User> usersList = null;
				try{
		            usersList = new ArrayList<User>();
		            connection = getConnection();
		            Statement stmt=getConnection().createStatement();  
		            ResultSet rs=stmt.executeQuery("select * from users");  
		            while(rs.next()){
		                User user = new User();
		                user.setId(rs.getInt("id"));
		                user.setName(rs.getString("name"));
		                user.setEmail(rs.getString("email"));
		                user.setPassword(rs.getString("password"));
		                user.setGender(rs.getString("gender"));
		                user.setAddress(rs.getString("address"));
		                usersList.add(user);
		            }
		            connection.close();        
		        }catch(Exception e){
		            System.out.println(e);
		        }
		        return usersList;
		    }
}
