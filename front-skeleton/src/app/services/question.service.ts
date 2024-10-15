import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Observable, tap} from 'rxjs';
import { QuestionModel } from '../models/question.model'
import {AnswerModel} from "../models/answer.model";

@Injectable({
  providedIn: 'root'
})
export class QuestionService {

  private apiGet = 'http://localhost:8080/questions/generate?nbquestions=2&nbChoix=3';
  private apiPost = 'http://localhost:8080/questions/checkAnswer'

  constructor(private http: HttpClient) { }

  getData(): Observable<QuestionModel[]>{
    return this.http.get<QuestionModel[]>(this.apiGet).pipe(
      tap(data => console.log('Données récupérées de l\'API:', data))
    );
  }
  checkAnswer(reponse : AnswerModel): Observable<boolean>{
    return this.http.post<boolean>(this.apiPost, reponse);
  }
}
