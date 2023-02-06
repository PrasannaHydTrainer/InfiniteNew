package com.infinite.jsf;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("com.infinite.jsf.PhoneNoValidator")
public class PhoneNoValidator implements Validator {

	private static final String EMAIL_PATTERN = "\\d{10}";

	private Pattern pattern;
	private Matcher matcher;
	
	public PhoneNoValidator(){
		  pattern = Pattern.compile(EMAIL_PATTERN);
	}
	
	@Override
	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		
		matcher = pattern.matcher(value.toString());
		if(!matcher.matches()){
			
			FacesMessage msg = 
				new FacesMessage("Phone No Validation...", 
						"Mobile No Contains min. 10 characters...");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);

		}
	
		if (value.toString().contains("9999999999")) {
			FacesMessage msg = 
					new FacesMessage("Phone No Validation...", 
							"This Number already Booke...");
				msg.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ValidatorException(msg);
		}

	}

}
