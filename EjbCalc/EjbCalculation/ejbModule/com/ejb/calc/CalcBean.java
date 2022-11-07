package com.ejb.calc;

import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class CalcBean
 */
@Stateless
@Remote(CalcBeanRemote.class)
public class CalcBean implements CalcBeanRemote {

    /**
     * Default constructor. 
     */
    public CalcBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public int sum(int a, int b) {
		// TODO Auto-generated method stub
		return a+b;
	}

	@Override
	public int sub(int a, int b) {
		// TODO Auto-generated method stub
		return a-b;
	}

	@Override
	public int mult(int a, int b) {
		// TODO Auto-generated method stub
		return a*b;
	}

}
