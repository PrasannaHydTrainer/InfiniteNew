package com.ejb.calc;

import javax.ejb.Remote;

@Remote
public interface CalcBeanRemote {
	int sum(int a, int b);
	int sub(int a, int b);
	int mult(int a, int b);
}
