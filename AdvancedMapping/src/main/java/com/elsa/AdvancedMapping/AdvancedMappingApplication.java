package com.elsa.AdvancedMapping;

import com.elsa.AdvancedMapping.dao.AppDAO;
import com.elsa.AdvancedMapping.entity.Course;
import com.elsa.AdvancedMapping.entity.Instructor;
import com.elsa.AdvancedMapping.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AdvancedMappingApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdvancedMappingApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {

		return runner -> {
			createInstructor(appDAO);

			// createInstructor(appDAO);

			// findInstructor(appDAO);

			createInstructorWithCourses(appDAO);
		};
	}

	private void createInstructorWithCourses(AppDAO appDAO){

		// create the instructor
		Instructor tempInstructor = new Instructor("Susan", "Public","susan.public@gmail.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com", "Video Games");

		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// create some courses
		Course tempCourse1 = new Course("Guitar - Ultimate Guide");
		Course tempCourse2 = new Course("Pinball Masterclass");

		// add courses to instructor
		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);

		// save the instructor
		//
		// NOTE: this will ALSO save the courses
		// because of CascadeType.PERSIST
		System.out.println("Saving instructor: " + tempInstructor);
		System.out.println("The courses: " + tempInstructor.getCourses());
		appDAO.save(tempInstructor);

		System.out.println("Done");
	}

	private void deleteInstructor(AppDAO appDAO){

		int theId = 1;
		System.out.println("Deleting instructor id: " + theId);

		appDAO.deleteInstructorById(theId);

		System.out.println("Done!");
	}

	private void findInstructor(AppDAO appDAO){

		int theId = 2;
		System.out.println("Finding instructor id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: " + tempInstructor);

		System.out.println("The associated instructorDetail only: " + tempInstructor.getInstructorDetail());
	}



	private void createInstructor(AppDAO appDAO) {

		// create the instructor
		Instructor tempInstructor = new Instructor("elsa", "wang", "elsa@gamil.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.elsa.com/youtube", "Guitar");

		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// save the instructor
		// NOTE: this will ALSO save the details object
		// because of CascadeType.ALL
		System.out.println("Saving instructor: " + tempInstructor);
		appDAO.save(tempInstructor);

		System.out.println("Done!");

	}


}
