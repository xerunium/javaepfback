import {inject, Injectable} from "@angular/core";
import {ResolveFn} from "@angular/router";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Major} from "../models/major.model";
import {MajorService} from "../services/major.service";
import {QuestionModel} from "../models/question.model";
import {QuestionService} from "../services/question.service";

export const QuestionsResolver: ResolveFn<any> = () => {
  //return inject(QuestionService).getData()
}
