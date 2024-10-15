import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { QuestionModel } from '../models/question.model'

@Injectable({
  providedIn: 'root'
})
export class QuestionService {

  private apiUrl = 'http://localhost:8080/questions/generate?nbquestions=1&nbChoix=3';

  constructor(private http: HttpClient) { }

  getData(): Observable<QuestionModel> {
    return this.http.get<QuestionModel>(this.apiUrl);
  }
}
