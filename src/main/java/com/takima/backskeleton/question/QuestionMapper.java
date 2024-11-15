package com.takima.backskeleton.question;

import com.takima.backskeleton.contenir.Contenir;

import java.util.ArrayList;

public interface QuestionMapper {
    public static QuestionDTO toDTO(Question question){
        ArrayList<String> description_reponses = new ArrayList<>();
        String image =null;
        for(Contenir contenir : question.getContenirs()) {
            description_reponses.add(contenir.getChoix().getDescription());
            if(contenir.isAnswer()){
                image=contenir.getChoix().getImage();
            }
        }
        return QuestionDTO.builder()
                .id(question.getId())
                .reponses(description_reponses)
                .image(image)
                .build();
    }
}
