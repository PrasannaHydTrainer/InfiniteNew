package com.infinite.jsf;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="eDao")
@SessionScoped
public class EmployDaoImpl implements EmployDAO {

	Connection connection;
	PreparedStatement pst;
	
	@Override
	public List<Employ> showEmployDao() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Employ";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		List<Employ> employList = new ArrayList<Employ>();
		Employ employ = null;
		while(rs.next()) {
			employ = new Employ();
			employ.setEmpno(rs.getInt("empno"));
			employ.setName(rs.getString("name"));
			employ.setDept(rs.getString("dept"));
			employ.setDesig(rs.getString("desig"));
			employ.setBasic(rs.getInt("basic"));
			employList.add(employ);
		}
		connection.close();
		pst.close();
		return employList;
	}

	@Override
	public String searchEmployDao(int empno) throws ClassNotFoundException, SQLException {
		Map<String,Object> sessionMap = 
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();		

		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Employ WHERE Empno=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, empno);
		ResultSet rs = pst.executeQuery();
		Employ employ = null;
		if (rs.next()) {
			employ = new Employ();
			employ.setEmpno(rs.getInt("empno"));
			employ.setName(rs.getString("name"));
			employ.setDept(rs.getString("dept"));
			employ.setDesig(rs.getString("desig"));
			employ.setBasic(rs.getInt("basic"));
            sessionMap.put("editEmploy", employ);
		}
		return "UpdateEmploy.xhtml?faces-redirect=true";
	}

	@Override
	public String addEmployDao(Employ employ)  {
		try {
			connection = ConnectionHelper.getConnection();
			String cmd = "insert into Employ(empno,name,dept,desig,basic) "
					+ " values(?,?,?,?,?)";
			pst = connection.prepareStatement(cmd);
			pst.setInt(1, employ.getEmpno());
			pst.setString(2, employ.getName());
			pst.setString(3, employ.getDept());
			pst.setString(4, employ.getDesig());
			pst.setInt(5, employ.getBasic());
			pst.executeUpdate();
			return "EmployShow.xhtml?faces-redirect=true";
		} catch (ClassNotFoundException | SQLException e) {
			String error = e.getMessage();
			Map<String,Object> sessionMap = 
					FacesContext.getCurrentInstance().getExternalContext().getSessionMap();		
			sessionMap.put("dberror", error);
			System.out.println("Hitting Exception");
			System.out.println(sessionMap.get("dberror").toString());
			return "CreateEmploy.xhtml?faces-redirect=true";
			// TODO Auto-generated catch block
	//		e.printStackTrace();
		}
		

	}

	@Override
	public int authenticate(String user, String pwd) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String encr=EntryptPassword.getCode(pwd);
		System.out.println("User Name " +user);
		System.out.println(encr);
		String cmd = "select count(*) cnt from login where userName=? AND passcode=?";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, user);
		pst.setString(2, encr.trim());
		ResultSet rs = pst.executeQuery();
		rs.next();
		int count = rs.getInt("cnt");
		return count;
	}

	@Override
	public String updateEmployDao(Employ employNew) throws ClassNotFoundException, SQLException {
			String cmd = "update employ set name=?, Dept=?, desig=?, "
					+ " Basic =? where empno=?";
			connection = ConnectionHelper.getConnection();
			pst = connection.prepareStatement(cmd);
			pst.setString(1, employNew.getName());
			pst.setString(2, employNew.getDept());
			pst.setString(3, employNew.getDesig());
			pst.setInt(4, employNew.getBasic());
			pst.setInt(5, employNew.getEmpno());
			pst.executeUpdate();
//			return "Employ Record Updated...";
		return "EmployShow.xhtml?faces-redirect=true";
	}

	@Override
	public String deleteEmployDao(int empno) throws ClassNotFoundException, SQLException {
			connection = ConnectionHelper.getConnection();
			String cmd = "delete from Employ where empno=?";
			pst = connection.prepareStatement(cmd);
			pst.setInt(1, empno);
			pst.executeUpdate();
			return "EmployShow.xhtml?faces-redirect=true";
	}

	@Override
	public String addUser(String userName, String passCode) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String encPwd = EntryptPassword.getCode(passCode);
		String cmd = "Insert into Login(UserName,PassCode) "
				+ " values(?,?)";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, userName);
		pst.setString(2, encPwd);
		pst.executeUpdate();
		return "User Account Created...";
	}
}
