package com.infinite.cms;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@ManagedBean(name="health")
@SessionScoped
@Table(name="Health")
@Entity
public class Health {

	@Id
	@Column(name="healthId")
	private int healthId;

	@Column(name="insuranceName")
	private String insuranceName;
	
	@Column(name="diseasesCovered")
	private String diseasesCovered;

	public int getHealthId() {
		return healthId;
	}

	public void setHealthId(int healthId) {
		this.healthId = healthId;
	}

	public String getInsuranceName() {
		return insuranceName;
	}

	public void setInsuranceName(String insuranceName) {
		this.insuranceName = insuranceName;
	}

	public String getDiseasesCovered() {
		return diseasesCovered;
	}

	public void setDiseasesCovered(String diseasesCovered) {
		this.diseasesCovered = diseasesCovered;
	}

	@Override
	public String toString() {
		return "Health [healthId=" + healthId + ", insuranceName=" + insuranceName + ", diseasesCovered="
				+ diseasesCovered + "]";
	}
	
	
}
