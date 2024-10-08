package com.takima.backskeleton.DTO;


import com.takima.backskeleton.models.Choix;
import com.takima.backskeleton.models.Contenir;
import com.takima.backskeleton.models.Question;

import java.util.ArrayList;

public interface QuestionMapper {
    public static QuestionDTO toDTO(Question question){
        ArrayList<String> description_reponses = new ArrayList<>();
        byte[] image =null;
        for(Contenir contenir : question.getContenirs()) {
            description_reponses.add(contenir.getChoix().getDescription());
            if(contenir.isAnswer()){
                image=contenir.getChoix().getImage();
            }
        }
        return QuestionDTO.builder()
                .reponses(description_reponses)
                .image(image)
                .build();
    }
}
