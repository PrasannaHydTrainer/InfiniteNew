package com.infinite.hib;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;

@ManagedBean 
@SessionScoped
public class RadioBean {

	private String radioValue;

	private String radioText;
	
	
	public String getRadioText() {
		return radioText;
	}

	public void setRadioText(String radioText) {
		this.radioText = radioText;
	}

	public String getRadioValue() {
		return radioValue;
	}

	public void setRadioValue(String radioValue) {
		this.radioValue = radioValue;
	}
	
	private String gen;
	
	public void radioChanged(ValueChangeEvent e){
		//assign new value to localeCode
		this.gen = e.getNewValue().toString();
	}

	public String getGen() {
		return gen;
	}

	public void setGen(String gen) {
		this.gen = gen;
	}

	public Gender[] getGender() {
		return Gender.values();
	}
	
}
