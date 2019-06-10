package com.wxx.modules.st.common;

import com.wxx.modules.st.domain.Student;
import com.wxx.modules.st.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Init implements CommandLineRunner {

    @Autowired
    StudentService studentService;

    @Override
    public void run(String... args) throws Exception {

        studentService.setStudent("1", new Student("Evan", 18));
        studentService.setStudent("2", new Student("Weison", 19));
        studentService.setStudent("3", new Student("Lucas", 17));
        studentService.setStudent("4", new Student("Leo", 16));
        studentService.setStudent("5", new Student("Andy", 15));

    }
}
 

