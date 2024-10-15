package com.takima.backskeleton.question;

import com.takima.backskeleton.choix.ChoixDao;
import com.takima.backskeleton.choix.AnswerDTO;
import com.takima.backskeleton.choix.Choix;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
    final static Logger logger = LoggerFactory.getLogger(QuestionController.class);

    @Autowired
    public QuestionController(QuestionService questionService, ChoixDao choixDao) {
        this.questionService = questionService;
        this.choixDao = choixDao;
    }

    @GetMapping("/generate")
    public ArrayList<QuestionDTO> getQuestions(@RequestParam Integer nbquestions,
                                               @RequestParam Integer nbChoix){
        List<Question> questions = questionService.generateQuestions(nbquestions, nbChoix);
        ArrayList<QuestionDTO> questionsDTO=new ArrayList<QuestionDTO>();
        for (Question question : questions){
            questionsDTO.add(QuestionMapper.toDTO(question));
        }
        return questionsDTO;
    }

    @PostMapping("/checkAnswer")
    public Boolean checkAnswer(@RequestBody AnswerDTO answerDTO){
        if(choixDao.findByImage(answerDTO.getImage()).isPresent()){
            Choix correctAnswer =choixDao.findByImage(answerDTO.getImage()).get();
            if (answerDTO.getDescription().equals(correctAnswer.getDescription())){
                return true;
            }
        }
return false;
    }
}
