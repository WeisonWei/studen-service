package com.wxx.modules.st.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Score {
    private Integer id;
    //科目
    private String subject;
    //学生编号
    private String studentId;
    //科目成绩
    private Integer subjectScore;
}
