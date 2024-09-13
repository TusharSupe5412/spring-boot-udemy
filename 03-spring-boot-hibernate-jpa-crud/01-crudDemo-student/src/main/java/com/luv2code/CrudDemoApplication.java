package com.luv2code;

import com.luv2code.dao.StudentDao;
import com.luv2code.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDao){
		return test ->{

			//createStudent(studentDao);

			createMultipleStudents(studentDao);

			//readStudent(studentDao);

			//getAllStudents(studentDao);

			//getStudentsByLastName(studentDao);

			//updateStudent(studentDao);

			//deleteStudent(studentDao);

			//deleteAllStudents(studentDao);
		};
	}

	private void deleteAllStudents(StudentDao studentDao) {
		System.out.println("DELETING ALL THE STUDENTS");
		int noOfRowsDeleted = 	studentDao.deleteAll();
		System.out.println("No of rows deleted : "+ noOfRowsDeleted);
	}

	private void deleteStudent(StudentDao studentDao) {

		int id = 2;

		System.out.println("deleting student of id :"+id);
		studentDao.delete(id);
	}

	private void updateStudent(StudentDao studentDao) {

		//retrieve student based on the id
		int studentId = 1;
		Student myStudent = studentDao.finById(studentId);

		// change first name to ashish
		myStudent.setFirstName("Ashish");

		// Update the student
		studentDao.update(myStudent);

		//display the updated student

		System.out.println("Updated student name :"+myStudent	);


	}

	private void getStudentsByLastName(StudentDao studentDao) {

		// get list of students
		List<Student> getStudentsByLastName = studentDao.findByLastName("rajpurohit");

		//display list of students
		for(Student temStudents : getStudentsByLastName){
			System.out.println(temStudents);
		}
	}

	private void getAllStudents(StudentDao studentDao) {

		// get list of students
		List<Student> allStudents = studentDao.findAll();

		// display list of students

		System.out.println("display list of students :");
		for (Student temp : allStudents){
			System.out.println(temp);
		}
	}

	private void readStudent(StudentDao studentDao) {


		//Create a student object

		Student s = new Student("Tushar","Supe","tsupe222@gamil.com");

		// save the student object

		studentDao.save(s);

		// display id of saved object

		System.out.println("User successfully saved in db : "+s.getId());

		//get student object

		Student myStudent = studentDao.finById(s.getId());

		// display the student

		System.out.println("Our student is :" + myStudent);
	}

	private void createMultipleStudents(StudentDao studentDao) {

		System.out.println("Saving multiple students to db");
		Student s1 = new Student("Shivam","sangle","shivi@gamil.com");
		Student s2 = new Student("Vikas","varma","vikas@gamil.com");
		Student s3 = new Student("swarup","rajpurohit","swarup@gamil.com");

		studentDao.save(s1);
		studentDao.save(s2);
		studentDao.save(s3);
	}

	private void createStudent(StudentDao studentDao) {

		//Create a student object

		Student s = new Student("Tushar","Supe","tsupe222@gamil.com");

		// save the student object

		studentDao.save(s);

		// display id of saved object

		System.out.println("User successfully saved in db : "+s.getId());

	}
}
