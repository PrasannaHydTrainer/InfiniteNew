package com.java.ejb;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class EmployBean
 */
@Stateless
@Remote(EmployBeanRemote.class)
public class EmployBean implements EmployBeanRemote {

	static EmployDAO edao;
	static {
		edao = new EmployDAO();
	}
    /**
     * Default constructor. 
     */
    public EmployBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Employ> showEmployBean() throws ClassNotFoundException, SQLException {
			return edao.showEmploy();
	}

	@Override
	public Employ searchEmployBean(int empno) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return edao.searchEmploy(empno);
	}

	@Override
	public String addEmployBean(Employ employ) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return edao.addEmploy(employ);
	}

	@Override
	public String deleteEmployBean(int empno) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return edao.deleteEmploy(empno);
	}

	@Override
	public String updateEmployBean(Employ employ) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return edao.updateEmploy(employ);
	}

}
