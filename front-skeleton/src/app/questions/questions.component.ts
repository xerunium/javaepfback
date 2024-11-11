import {Component, OnDestroy, OnInit} from '@angular/core';
import {QuestionService} from "../services/question.service";
import {QuestionModel} from '../models/question.model'
import {CommonModule} from "@angular/common";
import {ActivatedRoute, Router} from "@angular/router";
import {AnswerModel} from "../models/answer.model";
import {LeaderboardService} from "../services/leaderboard.service";


@Component({
  selector: 'questions',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './questions.component.html',
  styleUrl: './questions.component.scss'
})
export class QuestionsComponent implements OnInit, OnDestroy {
  currentImage: string = "";
  reponses?: string[]
  quiz?: QuestionModel[]
  selectedReponseDTO?: AnswerModel
  currentQuestion: number = 0
  score: number = 0
  difficulty: string = 'facile'
  username: string = 'user'
  elapsedTime: number = 0;
  private timer: any;


  constructor(private route: ActivatedRoute,
              private questionService: QuestionService,
              private leaderboardService: LeaderboardService,
              private router: Router) {
  }

  ngOnDestroy(): void {
    this.stopTimer();
  }

  ngOnInit() {
    if (this.currentQuestion === 0) {
      this.startTimer();
      this.getDifficultyAndUsername()
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

  startTimer() {
    this.timer = setInterval(() => {
      this.elapsedTime++;
    }, 1000);
  }

  stopTimer() {
    clearInterval(this.timer);
  }

  getDifficultyAndUsername() {
    this.route.queryParams.subscribe(params => {
      this.difficulty = params['difficulty'] || this.difficulty; // Par défaut 'facile'
      this.username = params['username'];
      this.questionService.setDifficulty(this.difficulty);
    })
  }

  async onSelectReponse(selectedAnswer: string) {
    //Creation DTO pour envoi API
    this.selectedReponseDTO = {
      description: selectedAnswer,
      image: this.currentImage
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
    await this.delay(500);
    //Passage à la prochaine question si existante
    this.update()
  }

  async update(): Promise<void> {
    if (this.quiz?.[this.currentQuestion] != null) {
      this.reponses = this.quiz?.[this.currentQuestion].reponses;
      this.currentImage = this.quiz?.[this.currentQuestion].image;
      this.currentQuestion++
    } else {
      this.leaderboardService.saveLeaderboard(this.username, this.score, this.elapsedTime);
      this.stopTimer();
      await this.delay(100); //Temps pour que le score s'enregistre dans BDD avant de charger le leaderboard
      this.router.navigate(['/leaderboard']);

    }
  }

  delay(ms: number): Promise<void> {
    return new Promise(resolve => setTimeout(resolve, ms));
  }

}
