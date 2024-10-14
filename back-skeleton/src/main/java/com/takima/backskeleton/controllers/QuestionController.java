package com.takima.backskeleton.controllers;

import com.takima.backskeleton.DAO.ChoixDao;
import com.takima.backskeleton.DAO.QuestionDao;
import com.takima.backskeleton.DTO.AnswerDTO;
import com.takima.backskeleton.DTO.QuestionDTO;
import com.takima.backskeleton.DTO.QuestionMapper;
import com.takima.backskeleton.models.Choix;
import com.takima.backskeleton.models.Question;
import com.takima.backskeleton.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RequestMapping("questions")
@RestController
@RequiredArgsConstructor
public class QuestionController {

    private QuestionDao questionDao;
    private QuestionService questionService;
    private ChoixDao choixDao;
    @Autowired
    public QuestionController(QuestionService questionService, ChoixDao choixDao) {
        this.questionService = questionService;
        this.choixDao = choixDao;
    }

    @GetMapping("/{nbquestions}")
    public ArrayList<QuestionDTO> getQuestions(@PathVariable Integer nbquestions){
        List<Question> questions = questionService.generateQuestions(nbquestions, 4);
        ArrayList<QuestionDTO> questionsDTO=new ArrayList<QuestionDTO>();
        for (Question question : questions){
            questionsDTO.add(QuestionMapper.toDTO(question));
        }
        return questionsDTO;
    }

    @PostMapping("/checkAnswer")
    public ResponseEntity<Boolean> checkAnswer(@RequestBody AnswerDTO answerDTO){
        if(choixDao.findByImage(answerDTO.getImage()).isPresent()){
            Choix correctAnswer =choixDao.findByImage(answerDTO.getImage()).get();
            if (answerDTO.getDescription().equals(correctAnswer.getDescription())){
                return ResponseEntity.ok(true);
            }
        }
return ResponseEntity.ok(false);
    }
}
