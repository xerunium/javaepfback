package com.takima.backskeleton.DTO;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class QuestionDTO {
    private List<String> reponses;
    private String image;
}
