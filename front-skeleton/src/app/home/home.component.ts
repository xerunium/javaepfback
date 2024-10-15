import { Component, OnInit } from "@angular/core"

@Component({
  selector: "home",
  templateUrl: "./home.component.html",
  styleUrls: ["./home.component.scss"],
})
export class HomeComponent implements OnInit {
  selectedDifficulty: string = 'Simple';
  nomFamille: string = '';
  constructor() {}

  ngOnInit(): void {}
}
