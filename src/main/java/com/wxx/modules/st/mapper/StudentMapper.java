package com.wxx.modules.st.mapper;

import com.wxx.modules.st.domain.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StudentMapper {
    List<Student> findStudentsBystIds(@Param("stIds") String studentIds);
}

