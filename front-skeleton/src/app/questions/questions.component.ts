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
  image: string | undefined;
  reponses: string[] | undefined;
  questions: QuestionModel | undefined;
  selectedReponse: string | undefined;


  constructor(private route: ActivatedRoute) {}

  ngOnInit() {
    this.questions = this.route.snapshot.data["reponses"][0];
    this.reponses = this.questions?.reponses;
    this.image =this.questions?.image;
  }

  onSelectReponse(reponse: string) {
    this.selectedReponse = reponse;
  }

  onSubmit() {

  }
  onSelectAnswer(reponse: string) {
    // Logique de validation ou navigation après la réponse
    console.log('Réponse sélectionnée :', reponse);
  }
}
