import { Component, OnInit } from '@angular/core';
import {LoginAuthenticationService} from "../login-authentication.service";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  title = "Oracle IT helpDesk";
  constructor(private authService:LoginAuthenticationService) {
  }

  ngOnInit() {
    this.authService.isLoggedIn();
  }

}
