package com.infinite.hib;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class MainProg {

	public static void main(String[] args) {
		SessionFactory sessionFactory = 
				new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
	    Question question1=new Question();    
	    question1.setQname("What is Java?");    

	    Answer ans1=new Answer();    
	    ans1.setAnswerName("Java is a programming language");    
	    ans1.setPostedBy("Prasanna Pappu");    
	        
	    Answer ans2=new Answer();    
	    ans2.setAnswerName("By using Java We can make any kind of Application");    
	    ans2.setPostedBy("Sunil Kumar");    
	    
	    List<Answer> lstAnswers1 = new ArrayList<Answer>();
	    lstAnswers1.add(ans1);
	    lstAnswers1.add(ans2);

	    Question question2=new Question();    
	    question2.setQname("What is Servlet?");    

	    Answer ans3=new Answer();    
	    ans3.setAnswerName("Servlet is an Interface");    
	    ans3.setPostedBy("Malissa");    
	        
	    Answer ans4=new Answer();    
	    ans4.setAnswerName("Servlet is an API");    
	    ans4.setPostedBy("Naresh");    

	    ArrayList<Answer> list2=new ArrayList<Answer>();    
	    list2.add(ans3);    
	    list2.add(ans4);    

	    question1.setAnswers(lstAnswers1);
	    question2.setAnswers(list2);    

	    session.save(question1);
	    session.save(question2);
	    transaction.commit();
	    System.out.println("Tables created...");
	}
}
