package com.infinite.jsf;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Test implements Serializable {

	public String sayHello() {
		return "Hello";
	}
}
