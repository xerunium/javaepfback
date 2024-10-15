import { Component, OnInit } from "@angular/core"
import {Router} from "@angular/router";

@Component({
  selector: "home",
  templateUrl: "./home.component.html",
  styleUrls: ["./home.component.scss"],
})
export class HomeComponent implements OnInit {
  selectedDifficulty: string = 'Simple';
  nomFamille: string = '';
  constructor(private router : Router) {}

  ngOnInit(): void {}

  startQuiz() {
    this.router.navigate(['/quiz'], { queryParams: { difficulty: this.selectedDifficulty } });

  }
}
