package com.infinite.jsf;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("com.infinite.jsf.EmpnoValidator")
public class EmpnoValidator implements Validator {

	public EmpnoValidator() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
	String error =(String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("dberror");
	if (error!="null") {
		System.out.println("Db Error from Program " +error);
		//String detail = new String(error);
		FacesMessage msg = 
				new FacesMessage("Db Error", 
						error);
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
	}
	}

}
