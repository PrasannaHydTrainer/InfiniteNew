package com.java.ejb;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Session Bean implementation class EmployeeBean
 */
@Stateless
@Remote(EmployeeBeanRemote.class)
public class EmployeeBean implements EmployeeBeanRemote {

	 @PersistenceContext(unitName = "EmpMgmtPU")
	 private EntityManager entityManager;
	 
    /**
     * Default constructor. 
     */
    public EmployeeBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public boolean addEmployee(Employee employee) {
		entityManager.persist(employee);
		return true;
	}

	@Override
	public Employee searchEmployee(int id) {
		Employee employee = entityManager.find(Employee.class, id);
		return employee;
	}

	@Override
	public List<Employee> showEmployee() {
		  Query query = entityManager.createQuery("SELECT e FROM Employee e");
		    return (List<Employee>) query.getResultList();
	}

	@Override
	public String updateEmployee(Employee employeeNew) {
		Employee employeeFound = searchEmployee(employeeNew.getId());
		if (employeeFound!=null) {
			entityManager.merge(employeeNew);
			return "Updated...";
		}
		return "Not Found...";
	}

}
