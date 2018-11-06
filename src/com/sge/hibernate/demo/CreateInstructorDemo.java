package com.sge.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sge.hibernate.demo.entity.Course;
import com.sge.hibernate.demo.entity.Instructor;
import com.sge.hibernate.demo.entity.InstructorDetail;


public class CreateInstructorDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			

			
			Instructor tempInstructor = 
					new Instructor("Luis", "Agero", "luis@hotmail.com");
			
			InstructorDetail tempInstructorDetail =
					new InstructorDetail(
							"http://www.youtube.com",
							"Bajo");		
			
			// start a transaction
			session.beginTransaction();
			
			
			Course c = new Course("cursillo macra");
			
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			tempInstructor.add(c);
			
			// save the instructor
			System.out.println("Saving instructor: " + tempInstructor);
			session.save(tempInstructor);					
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}





