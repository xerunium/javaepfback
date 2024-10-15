package com.takima.backskeleton.question;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class QuestionDTO {
    private Long id;
    private List<String> reponses;
    private String image;
}
