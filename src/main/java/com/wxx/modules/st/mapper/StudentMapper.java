package com.wxx.modules.st.mapper;

import com.wxx.modules.st.domain.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {
    public Student findStudentById(@Param("id") Integer id);

    //新增学生信息
    public Integer addStudent(Student student);

    //查询所有同学信息
    public Integer deleteByStudent(Student student);

    //查询所有同学信息
    public Integer deleteByStudentName(String studentName);

    //查询所有同学信息
    public Integer updateStudent(Student student);

    //查询所有同学信息
    public List<Student> findStudents();

    //根据Map条件查询所有同学
    public List<Student> findStudentByMap(Map<String, String> params);

    //根据String条件查询所有同学
    public List<Student> findStudentByParams(String studentPhone, String studentName);

    //查询所有同学的所有科目成绩
    public List<Student> findStudentScores();
}

