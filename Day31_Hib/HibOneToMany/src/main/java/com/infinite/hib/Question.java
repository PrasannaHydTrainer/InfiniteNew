package com.infinite.hib;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity  
@Table(name="questions_11")
public class Question {

	@Id   
	@GeneratedValue(strategy=GenerationType.TABLE)  
	private int id;
	
	private String qname;
	
	@OneToMany(cascade = CascadeType.ALL)  
	@JoinColumn(name="qid")  
	private List<Answer> answers;
	
	
	public List<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQname() {
		return qname;
	}
	public void setQname(String qname) {
		this.qname = qname;
	}
	
	
}
