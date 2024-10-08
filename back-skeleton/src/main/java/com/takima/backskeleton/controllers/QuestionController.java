package com.takima.backskeleton.controllers;

import com.takima.backskeleton.DAO.QuestionDao;
import com.takima.backskeleton.DTO.QuestionDTO;
import com.takima.backskeleton.DTO.QuestionMapper;
import com.takima.backskeleton.models.Question;
import com.takima.backskeleton.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RequestMapping("questions")
@RestController
@RequiredArgsConstructor
public class QuestionController {

    private QuestionDao questionDao;
    private QuestionService questionService;
    @GetMapping("/{nbquestions}")
    public ArrayList<QuestionDTO> getQuestions(@RequestParam Integer nbquestions){
        //Reprendre liste de service guilhem
        List<Question> questions = questionService.generateQuestions(nbquestions, 4);
        ArrayList<QuestionDTO> questionsDTO=new ArrayList<QuestionDTO>();
        for (Question question : questions){
            questionsDTO.add(QuestionMapper.toDTO(question));
        }
        return questionsDTO;
    }
}
