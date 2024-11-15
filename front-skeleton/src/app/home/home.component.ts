import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";

@Component({
  selector: "home",
  templateUrl: "./home.component.html",
  styleUrls: ["./home.component.scss"],
})
export class HomeComponent implements OnInit {
  selectedDifficulty: string = "";
  username: string = "";
  background: string = "";

  constructor(private router: Router) {}

  ngOnInit(): void {
    this.updateBackground();
  }

  updateBackground() {
    switch (this.selectedDifficulty) {
      case "Simple":
        this.background = "url('https://chat-chou.com/wp-content/uploads/2023/10/chats-les-plus-mignons.jpg')";
        break;
      case "Moyen":
        this.background = "url('https://static.actu.fr/uploads/2021/03/13807881863-639a90e969-o.jpg')";
        break;
      case "Atroce":
        this.background = "url('https://images.squarespace-cdn.com/content/v1/5ff618e1c6d974239d969567/230652e2-84b5-47f8-aa35-df2ad53ae763/joseph-z-whyd-god-create-hell-isnt-he-supposed-to-be-good.jpg')";
        break;
      default:
        this.background = "";
    }
  }

  startQuiz() {
    if(this.username.trim() === "" ){
      this.router.navigate(["/quiz"], {
        queryParams: { difficulty: this.selectedDifficulty, username: "Anonymous" },
      });
    }else{
    this.router.navigate(["/quiz"], {
      queryParams: { difficulty: this.selectedDifficulty, username: this.username },
    });
    }
  }
}
