package com.wxx.modules.st.service;

import com.wxx.modules.st.domain.Student;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class MockStudentService {

    private Map<String, Student> StudentMap = new ConcurrentHashMap<>();


    public Mono<Student> addStudent(Mono<Student> Student) {
        Set<String> strings = StudentMap.keySet();
        Optional<String> max = strings.stream().max(String::compareTo);
        Mono<Student> StudentMono = Student.flatMap(StudentElement -> {
            StudentMap.put(String.valueOf(Integer.valueOf(max.get() + 1)), StudentElement);
            return Mono.just(StudentElement);
        });
        return StudentMono;
    }

    public Mono<Student> findStudentById(String StudentId) {
        Student Student = StudentMap.getOrDefault(StudentId,
                new Student(5, "Lry", 15, "female", "115", "Lry house", 0));
        return Mono.just(Student);
    }

    public Flux<Student> findStudentList() {
        List<Student> StudentList = new ArrayList<>();
        Set<Map.Entry<String, Student>> entries = StudentMap.entrySet();
        entries.stream().forEach(entry -> StudentList.add(entry.getValue()));
        return Flux.fromStream(StudentList.stream());
    }
}

