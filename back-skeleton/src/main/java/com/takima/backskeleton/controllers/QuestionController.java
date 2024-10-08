package com.takima.backskeleton.controllers;

import com.takima.backskeleton.DAO.QuestionDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QuestionController {

    private QuestionDao questionDao;
//    @GetMapping("generatequestions/{nbquestion}")
//    public generateQuestions(@RequestParam Integer nbquestions){
//        return questionDao
//    }
//

}
