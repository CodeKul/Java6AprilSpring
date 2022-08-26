package com.codekul.java6AprilSpring;

import com.codekul.java6AprilSpring.aop.BoysStudent;
import com.codekul.java6AprilSpring.aop.GirlStudent;
import com.codekul.java6AprilSpring.aop.Human;
import com.codekul.java6AprilSpring.di.Student;
import com.codekul.java6AprilSpring.ioc.SimConfig;
import com.codekul.java6AprilSpring.ioc.Vodafone;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Java6AprilSpringApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Java6AprilSpringApplication.class, args);

//		Vodafone vodafone = context.getBean(Vodafone.class);
//
//		vodafone.data();
//		vodafone.calling();

		BoysStudent boysStudent = context.getBean(BoysStudent.class);
		boysStudent.studyBoy();

		GirlStudent girlStudent = context.getBean(GirlStudent.class);
		girlStudent.studyGirl();

//		Student student = context.getBean(Student.class);
//		student.callSubject();
//
//		Student student1 = context.getBean(Student.class);
//		student1.callSubject();;
	}

	@GetMapping("hii")
	public String hii(){
		return "Hello world";
	}


}
