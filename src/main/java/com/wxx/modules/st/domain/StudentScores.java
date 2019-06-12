package com.wxx.modules.st.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentScores {
    private Integer id;
    private String studentName;
    private String studentPhone;
    private List<Score> scores;
}

