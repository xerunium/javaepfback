import { Component } from '@angular/core';
import {RouterOutlet} from "@angular/router";
import {CommonModule} from "@angular/common";
import { MatButton } from "@angular/material/button"

@Component({
  selector: "admin",
  standalone: true,
  imports: [RouterOutlet, CommonModule, MatButton],
  templateUrl: "./admin.component.html",
  styleUrl: "./admin.component.scss",
})
export class AdminComponent {}
