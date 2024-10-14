import {Component, OnInit} from '@angular/core';
import {QuestionService} from "../services/question.service";
import { QuestionModel } from '../models/question.model'
import {CommonModule} from "@angular/common";
import {ActivatedRoute} from "@angular/router";


@Component({
  selector: 'questions',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './questions.component.html',
  styleUrl: './questions.component.scss'
})
export class QuestionsComponent implements OnInit{
  image: string ='';
  reponses: string[] | undefined;
  questions: QuestionModel | undefined;

  constructor(private route: ActivatedRoute) {}

  ngOnInit() {
    this.questions = this.route.snapshot.data["reponses"][0];
    this.reponses = this.questions?.reponses;
    console.log(this.questions);
    console.log(this.reponses);
    /*this.questionService.getData().subscribe((question: QuestionModel)=>
    {
      this.reponses= question.reponses
      this.image= question.image
    })*/
  }
}
