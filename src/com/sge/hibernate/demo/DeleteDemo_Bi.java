package com.sge.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sge.hibernate.demo.entity.Instructor;
import com.sge.hibernate.demo.entity.InstructorDetail;

public class DeleteDemo_Bi {
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
			
			// start a transaction
			session.beginTransaction();

			// get instructor by primary key / id
			int theId = 1;
			
			
			InstructorDetail tempInstructorDetail = 
					session.get(InstructorDetail.class, theId);
			
			System.out.println("Found instructor detail: " + tempInstructorDetail);
			
			// delete the instructor
			
			System.out.println("Deleting: " + tempInstructorDetail);
				
			// Instructor to null	
			
			tempInstructorDetail.getInstructor().setInstructorDetail(null);
			
			// delete the instructorDetail
			
			session.delete(tempInstructorDetail);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}
