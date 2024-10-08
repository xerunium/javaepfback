package com.takima.backskeleton.controllers;

import com.takima.backskeleton.DAO.QuestionDao;
import com.takima.backskeleton.models.Question;
import com.takima.backskeleton.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("questions")
@RestController
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;
    private final QuestionDao questionDao;


}
