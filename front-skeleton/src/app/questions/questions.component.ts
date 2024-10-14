import {Component, OnInit} from '@angular/core';
import {QuestionService} from "../services/question.service";
import { QuestionModel } from '../models/question.model'


@Component({
  selector: 'questions',
  standalone: true,
  imports: [],
  templateUrl: './questions.component.html',
  styleUrl: './questions.component.scss'
})
export class QuestionsComponent implements OnInit{
  image: string ='';
  reponses: string[] = [];

  constructor(private questionService : QuestionService) {}

  ngOnInit() {
    this.questionService.getData().subscribe((question: QuestionModel)=>
    {
      this.reponses= question.reponses
      this.image= question.image
    })
  }
  onSelectAnswer(reponse: string) {
    // Logique de validation ou navigation après la réponse
    console.log('Réponse sélectionnée :', reponse);
  }
}
