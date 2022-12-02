package com.infinite.hib;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

@NamedQueries(  
	    {  
	        @NamedQuery(  
	        name = "showEmploy",  
	        query = "from Employ"  
	        ),
	        @NamedQuery(
	        	name="searchEmploy",
	        	query="from Employ where empno=:empno"
	        ),
	        @NamedQuery(
		        name="showDepartmentFilter",
		        query="from Employ where dept=:dept AND basic > :basic"
		    ),
	    }  
	)  

@ManagedBean
@Entity
@Table(name="Employ")
public class Employ {

	@Id
	@Column(name="empno")
	private int empno;
	
	@Column(name="name")
	private String name;
	
	@Column(name="dept")
	private String dept;
	
	@Column(name="desig")
	private String desig;
	
	@Column(name="basic")
	private int basic;

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getDesig() {
		return desig;
	}

	public void setDesig(String desig) {
		this.desig = desig;
	}

	public int getBasic() {
		return basic;
	}

	public void setBasic(int basic) {
		this.basic = basic;
	}
	
}
