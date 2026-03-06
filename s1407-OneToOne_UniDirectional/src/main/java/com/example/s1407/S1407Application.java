package com.example.s1407;

import com.example.s1407.dao.TeacherDAO;
import com.example.s1407.dao.TeacherDetailDAO;
import com.example.s1407.entity.Teacher;
import com.example.s1407.entity.TeacherDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class S1407Application {

	public static void main(String[] args) {
		SpringApplication.run(S1407Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(TeacherDAO teacherDAO,TeacherDetailDAO teacherDetailDAO) {
		return runner -> {
			createTeacher(teacherDAO);
		};
	}
	private void createTeacher(TeacherDAO teacherDAO) {
		Teacher teacher = new Teacher();
		teacher.setFirstName("Tuan Anh");
		teacher.setLastName("Bui");
		teacher.setEmail("bta@gmail.com");

		TeacherDetail teacherDetail = new TeacherDetail();
		teacherDetail.setGender(true);
		teacherDetail.setAddress("HP");
		teacherDetail.setYoutubeChannel("bta youtube");

		teacher.setTeacherDetail(teacherDetail);

		System.out.println("Saving teacher ..." + teacher);

		teacherDAO.save(teacher);

		System.out.println("Done");

	}
}
