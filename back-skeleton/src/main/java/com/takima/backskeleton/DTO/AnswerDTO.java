package com.takima.backskeleton.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AnswerDTO {
    private String description;
    private String image;
}
