import {Component, OnInit} from '@angular/core';
import {QuestionService} from "../services/question.service";
import {QuestionModel} from '../models/question.model'
import {CommonModule} from "@angular/common";
import {ActivatedRoute} from "@angular/router";
import {AnswerModel} from "../models/answer.model";


@Component({
  selector: 'questions',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './questions.component.html',
  styleUrl: './questions.component.scss'
})
export class QuestionsComponent implements OnInit {
  currentImage: string="";
  reponses?: string[]
  quiz?: QuestionModel[]
  selectedReponseDTO?: AnswerModel
  currentQuestion: number = 0
  score : number = 0
  difficulty : string ='facile'


  constructor(private route: ActivatedRoute, private questionService: QuestionService) {
  }

  ngOnInit() {
    if (this.currentQuestion === 0) {
      this.getDifficulty()
      this.questionService.getData().subscribe(
        (data: QuestionModel[]) => {
          this.quiz = data;
          this.reponses = this.quiz?.[0].reponses
          this.currentImage = this.quiz?.[0].image
          this.currentQuestion++
        }
      )
    }
  }
  getDifficulty(){
    this.route.queryParams.subscribe(params => {
      this.difficulty = params['difficulty'] || this.difficulty; // Par défaut 'facile'
      this.questionService.setDifficulty(this.difficulty);
    })
  }
  async onSelectReponse(selectedAnswer: string) {
    //Creation DTO pour envoi API
    this.selectedReponseDTO = {
      description:selectedAnswer,
      image:this.currentImage
    }
    console.log(this.selectedReponseDTO)
    //Verification réponse
     this.questionService.checkAnswer(this.selectedReponseDTO).subscribe((result: boolean) => {
       if (result) {
         this.score++;
         console.log("Réponse correcte ! Score : ", this.score);
       } else {
         console.log("Réponse incorrecte.");
       }
     }, error => {
       console.error("Erreur lors de la vérification de la réponse : ", error);
     });
    await this.delay(3000);
     //Passage à la prochaine question si existante
    this.update()
  }
  update(): void{
    if(this.quiz?.[this.currentQuestion]!=null){
      this.reponses=this.quiz?.[this.currentQuestion].reponses;
      this.currentImage=this.quiz?.[this.currentQuestion].image;
      this.currentQuestion++
    }
  }
  delay(ms: number): Promise<void> {
    return new Promise(resolve => setTimeout(resolve, ms));
  }

}
