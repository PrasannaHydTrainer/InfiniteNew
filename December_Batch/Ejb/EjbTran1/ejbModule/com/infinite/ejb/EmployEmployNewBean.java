package com.infinite.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class EmployHibEmployBean
 */
@Stateless
public class EmployEmployNewBean implements EmployEmployNewBeanRemote {

    /**
     * Default constructor. 
     */
    public EmployEmployNewBean() {
        // TODO Auto-generated constructor stub
    }

    @PersistenceContext(unitName="EmployeeService") 
    private EntityManager manager;

	@Override
	public String addEmployDao(Employ employ) {
	//	new EmployDaoImpl().addEmployDao(employ);
		manager.persist(employ);
		return "Employ Record Added...";
	}

}
