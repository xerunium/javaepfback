import { Component, OnInit } from "@angular/core"
import { Router } from "@angular/router"
import { MatButtonToggleChange } from "@angular/material/button-toggle"

@Component({
  selector: "home",
  templateUrl: "./home.component.html",
  styleUrls: ["./home.component.scss"],
})
export class HomeComponent implements OnInit {
  selectedDifficulty: string = "Simple"
  username: string = ""
  background: string = ""

  constructor(private router: Router) {}

  ngOnInit(): void {}

  startQuiz() {
    this.router.navigate(["/quiz"], { queryParams: { difficulty: this.selectedDifficulty, username: this.username } })
  }

  onChange($event: MatButtonToggleChange) {
    if (this.selectedDifficulty === "Simple") {
      this.background = "https://chat-chou.com/wp-content/uploads/2023/10/chats-les-plus-mignons.jpg"
    }
    if (this.selectedDifficulty === "Moyen") {
      this.background = "https://static.wikia.nocookie.net/something-wicked/images/7/73/Hell.jpg/revision/latest?cb=20171103211145"
    }
    if (this.selectedDifficulty === "Atroce") {
      this.background = "https://static.actu.fr/uploads/2021/03/13807881863-639a90e969-o.jpg"
    }
  }
}
