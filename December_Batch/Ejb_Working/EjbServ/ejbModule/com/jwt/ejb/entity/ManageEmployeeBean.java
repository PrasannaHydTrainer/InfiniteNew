package com.jwt.ejb.entity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
 
/**
 * Session Bean implementation class ManageEmployeeBean
 */
@Stateless
public class ManageEmployeeBean implements EmployeeRemote {
 
    @PersistenceContext(unitName = "EmpMgmtPU")
    private EntityManager entityManager;
 
    public ManageEmployeeBean() {
 
    }
 
    public boolean addEmployee(Employee employee) {
        entityManager.persist(employee);
        return true;
    }

	@Override
	public Employee searchEmployee(int id) {
		Employee employee = entityManager.find(Employee.class, id);
		return employee;
	}
 
}


