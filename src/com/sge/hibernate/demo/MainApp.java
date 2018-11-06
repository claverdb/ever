package com.sge.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sge.hibernate.demo.entity.Instructor;
import com.sge.hibernate.demo.entity.InstructorDetail;

public class MainApp {
	
	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		int theId = 1;
		Instructor tempInstructor = session.get(Instructor.class, theId);
		
		System.out.println("tempInstructor: " + tempInstructor);
		
		System.out.println("courses: "+ tempInstructor.getCourses());;
	}

}
