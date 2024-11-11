import {Injectable} from "@angular/core";
import {HttpClient, HttpParams} from "@angular/common/http";
import {LeaderboardModel} from "../models/leaderboard.model";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class LeaderboardService {

  private apiGet = 'http://localhost:8080/leaderboard/get';
  private apiPost = 'http://localhost:8080/leaderboard/save';

  constructor(private http: HttpClient) {
  }

  saveLeaderboard(username: string, score: number, temps: number) {
    const body = {username, score, temps};
    const headers = {'Content-Type': 'application/json'};
    this.http.post(this.apiPost, body, {headers}).subscribe(
      response => console.log('Réponse reçue'),
      error => console.error('Erreur lors de l\'envoi:', error)
    );
  }

  getLeaderboard(): Observable<LeaderboardModel[]> {
    return this.http.get<LeaderboardModel[]>(this.apiGet);
  }
}
