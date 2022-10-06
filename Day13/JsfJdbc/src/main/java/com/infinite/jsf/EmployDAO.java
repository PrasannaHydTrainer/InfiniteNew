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

@ManagedBean
@SessionScoped
public class EmployDAO {

	Connection connection;
	PreparedStatement pst;
	
	public String updateEmploy(Employ employNew) 
			throws ClassNotFoundException, SQLException {
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
			return "Employ Record Updated...";
	} 
	public String deleteEmploy(int empno)
			throws ClassNotFoundException, SQLException {
			connection = ConnectionHelper.getConnection();
			String cmd = "delete from Employ where empno=?";
			pst = connection.prepareStatement(cmd);
			pst.setInt(1, empno);
			pst.executeUpdate();
		return "Employ Record Not Found...";
	}
	public String addEmploy(Employ employ) 
			throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "insert into Employ(name,dept,desig,basic) "
				+ " values(?,?,?,?)";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, employ.getName());
		pst.setString(2, employ.getDept());
		pst.setString(3, employ.getDesig());
		pst.setInt(4, employ.getBasic());
		pst.executeUpdate();
		//return "Record Inserted...";
		  return "EmployShow.xhtml?faces-redirect=true";
	}
	
	public String searchEmploy(int empno)
			throws ClassNotFoundException, SQLException {
		Map<String,Object> sessionMap = 
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();		
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Employ where empno=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, empno);
		ResultSet rs = pst.executeQuery();
		Employ employ = null;
		if(rs.next()) {
			employ = new Employ();
			employ.setEmpno(rs.getInt("empno"));
			employ.setName(rs.getString("name"));
			employ.setDept(rs.getString("dept"));
			employ.setDesig(rs.getString("desig"));
			employ.setBasic(rs.getInt("basic"));
            sessionMap.put("editEmploy", employ);

		}
        return "/UpdateEmploy.xhtml?faces-redirect=true";
	}
	public List<Employ> showEmploy() throws 
				ClassNotFoundException, SQLException {
		List<Employ> employList = new ArrayList<Employ>();
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Employ";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
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
		return employList;
	}
}



