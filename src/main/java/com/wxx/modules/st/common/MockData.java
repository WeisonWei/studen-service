package com.wxx.modules.st.common;

import com.wxx.modules.st.domain.Student;
import com.wxx.modules.st.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MockData implements CommandLineRunner {

    @Autowired
    StudentService studentService;

    @Override
    public void run(String... args) throws Exception {
        studentService.setStudent("1", new Student(1, "Evan", 18, "female", "111", "Evan house", 1));
        studentService.setStudent("2", new Student(2, "Rouse", 19, "female", "112", "Rouse house", 2));
        studentService.setStudent("3", new Student(3, "Lucas", 17, "male", "113", "Lucas house", 2));
        studentService.setStudent("4", new Student(4, "Jack", 16, "male", "114", "Jack house", 4));
        studentService.setStudent("5", new Student(5, "Lry", 15, "female", "115", "Lry house", 0));
    }
}
 

