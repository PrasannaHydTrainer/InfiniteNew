package com.java.ejb;
import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ClientProg {
	public static void main(String[] args) {
        EmployeeBeanRemote remote = doLookup();
        Employee employee = new Employee();
        employee.setFirstName("Mukesh");
        employee.setLastName("Kumar");
        employee.setEmail("mrajnitro@gmail.com");
 
        Employee employee1 = new Employee();
        employee1.setFirstName("Ravi");
        employee1.setLastName("Raj");
        employee1.setEmail("ravi@gmail.com");
        remote.addEmployee(employee);
        remote.addEmployee(employee1);
        
        List<Employee> employList = remote.showEmployee();
        for (Employee employee2 : employList) {
			System.out.println(employee2);
		}
        Employee employee3 = new Employee();
        employee3.setId(1);
        employee3.setFirstName("Chandu");
        employee3.setLastName("Deeti");
        employee3.setEmail("deeti@gmail.com");
        System.out.println(remote.updateEmployee(employee3));
        
    }
 
    private static EmployeeBeanRemote doLookup() {
        Context context = null;
        EmployeeBeanRemote bean = null;
        try {
            // 1. Obtaining Context
            context = getInitialContext();
            // 2. Lookup and cast
            bean = (EmployeeBeanRemote) context.lookup(LOOKUP_STRING);
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return bean;
    }
 
    private static final String LOOKUP_STRING = "EmployeeBean/remote";
    /*
     *  * location of JBoss JNDI Service provider the client will use. It should
     * be * URL string.
     */
    private static final String PROVIDER_URL = "jnp://localhost:1099";
    /*
     *  * specifying the list of package prefixes to use when loading in URL *
     * context factories. colon separated
     */
    private static final String JNP_INTERFACES = "org.jboss.naming:org.jnp.interfaces";
    /*
     *  * Factory that creates initial context objects. fully qualified class
     * name.
     */
    private static final String INITIAL_CONTEXT_FACTORY = "org.jnp.interfaces.NamingContextFactory";
    private static Context initialContext;
 
    public static Context getInitialContext() throws NamingException {
        if (initialContext == null) {
            // Properties extends HashTable
            Properties prop = new Properties();
            prop.put(Context.INITIAL_CONTEXT_FACTORY, INITIAL_CONTEXT_FACTORY);
            prop.put(Context.URL_PKG_PREFIXES, JNP_INTERFACES);
            prop.put(Context.PROVIDER_URL, PROVIDER_URL);
            initialContext = new InitialContext(prop);
        }
        return initialContext;
    }
}
