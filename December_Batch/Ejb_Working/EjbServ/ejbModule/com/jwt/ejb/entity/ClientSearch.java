package com.jwt.ejb.entity;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ClientSearch {

	public static void main(String[] args) {
        EmployeeRemote remote = doLookup();
        Employee employee = remote.searchEmployee(1);
        if (employee!=null) {
        	System.out.println(employee);
        } else {
        	System.out.println("*** Record Not Found ***");
        }
	}
 
    private static EmployeeRemote doLookup() {
        Context context = null;
        EmployeeRemote bean = null;
        try {
            // 1. Obtaining Context
            context = getInitialContext();
            // 2. Lookup and cast
            bean = (EmployeeRemote) context.lookup(LOOKUP_STRING);
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return bean;
    }
 
    private static final String LOOKUP_STRING = "ManageEmployeeBean/remote";
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
