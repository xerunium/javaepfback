package com.takima.backskeleton.choix;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AnswerDTO {
    private String description;
    private String image;

    @Override
    public String toString() {
        return "AnswerDTO{" +
                "description='" + description + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
