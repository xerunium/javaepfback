import {Component, OnInit} from '@angular/core';
import {LeaderboardService} from "../services/leaderboard.service";
import {LeaderboardModel} from "../models/leaderboard.model";
import {QuestionModel} from "../models/question.model";
import {NgForOf} from "@angular/common";
import { MatButton } from "@angular/material/button"

@Component({
  selector: "leaderboard",
  standalone: true,
  imports: [NgForOf, MatButton],
  templateUrl: "./leaderboard.component.html",
  styleUrl: "./leaderboard.component.scss",
})
export class LeaderboardComponent implements OnInit {
  leaderboard: LeaderboardModel[] = []

  constructor(private leaderboardService: LeaderboardService) {}

  ngOnInit(): void {
    this.leaderboardService.getLeaderboard().subscribe(
      (data: LeaderboardModel[]) => {
        this.leaderboard = data
      },
      (error) => {
        console.error("Impossible de récupérer le leaderboard", error)
      },
    )
  }
}
