package com.takima.backskeleton.controllers;

import com.takima.backskeleton.DAO.QuestionDao;
import com.takima.backskeleton.DTO.QuestionDTO;
import com.takima.backskeleton.DTO.QuestionMapper;
import com.takima.backskeleton.models.Question;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class QuestionController {

    private QuestionDao questionDao;
    @GetMapping("/{nbquestions}")
    public ArrayList<QuestionDTO> getQuestions(@RequestParam Integer nbquestions){
        //Reprendre liste de service guilhem
        ArrayList<Question> questions=new ArrayList<Question>();
        ArrayList<QuestionDTO> questionsDTO=new ArrayList<QuestionDTO>();
        for (Question question : questions){
            questionsDTO.add(QuestionMapper.toDTO(question));
        }
        return questionsDTO;
    }
}
