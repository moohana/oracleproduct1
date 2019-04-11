import { Component, OnInit } from "@angular/core";
import { LoginAuthenticationService } from "../login-authentication.service";
import { UserService } from "../user.service";

@Component({
  selector: "app-userdashboard",
  templateUrl: "./userdashboard.component.html",
  styleUrls: ["./userdashboard.component.css"]
})
export class UserdashboardComponent implements OnInit {
  public loginuser: any = {};
  public user: any = {};

  constructor(
    private authService: LoginAuthenticationService,
    private userService: UserService
  ) {
    this.authService.isLoggedIn();
    this.loginuser = JSON.parse(localStorage.getItem("currentUser"));
  }

  ngOnInit() {
    this.userService.getUser(this.loginuser.token).subscribe(user => {
      this.user = user;
    });
  }
}
