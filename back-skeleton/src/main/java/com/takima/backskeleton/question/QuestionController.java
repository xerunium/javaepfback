package com.takima.backskeleton.question;

import com.takima.backskeleton.choix.ChoixDao;
import com.takima.backskeleton.choix.AnswerDTO;
import com.takima.backskeleton.choix.Choix;
import lombok.RequiredArgsConstructor;
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
