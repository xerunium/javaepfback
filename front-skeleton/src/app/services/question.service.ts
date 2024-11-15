import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable, tap} from 'rxjs';
import {QuestionModel} from '../models/question.model'
import {AnswerModel} from "../models/answer.model";

@Injectable({
  providedIn: 'root'
})
export class QuestionService {

  private apiGet = 'http://localhost:8080/questions/generate?nbquestions=10&nbChoix=';
  private apiPost = 'http://localhost:8080/questions/checkAnswer'
  private nbChoix: number = 2

  constructor(private http: HttpClient) {
  }

  getData(): Observable<QuestionModel[]> {
    console.log(this.apiGet.concat(this.nbChoix.toString()))
    return this.http.get<QuestionModel[]>(this.apiGet.concat(this.nbChoix.toString())).pipe(
      tap(data => console.log('Données récupérées de l\'API:', data))
    );
  }

  checkAnswer(reponse: AnswerModel): Observable<boolean> {
    return this.http.post<boolean>(this.apiPost, reponse);
  }

  setDifficulty(difficulty: string) {
    switch (difficulty) {
      case 'Simple':
        this.nbChoix = 2
        break;
      case 'Moyen':
        this.nbChoix = 4
        break;
      case 'Atroce':
        this.nbChoix = 4
    }
  }
}
