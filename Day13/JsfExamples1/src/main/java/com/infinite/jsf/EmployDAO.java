package com.infinite.jsf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class EmployDAO implements Serializable {

	public List<Employ> showEmploy() {
		List<Employ> employList = new ArrayList<Employ>();
		employList.add(new Employ(1, "Gaurav", "Java", "Developer", 84245.33));
		employList.add(new Employ(2, "Harshit", "J2EE", "Expert", 90442.33));
		employList.add(new Employ(3, "Swathi", "MySql", "Programmer", 88933.33));
		employList.add(new Employ(4, "Abhishek", "Angular", "Tester", 89043.33));
		employList.add(new Employ(5, "Sireesha", "React", "Manager", 85677.33));
		return employList;
	}
}
