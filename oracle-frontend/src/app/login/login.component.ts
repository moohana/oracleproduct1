import { Component, OnInit } from "@angular/core";
import { UserService } from "../user.service";
import { Router } from "@angular/router";
import { LoginAuthenticationService } from "../login-authentication.service";

@Component({
  selector: "app-login",
  templateUrl: "./login.component.html",
  styleUrls: ["./login.component.css"]
})
export class LoginComponent implements OnInit {
  public user: any = {};
  msg:string=null;


  constructor(
    private userService: UserService,
    private router: Router,
    private authService: LoginAuthenticationService
  ) {

  }

  ngOnInit() {}

  loginUser(user: any) {
    this.userService.loginUser(user).subscribe(response => {
      if (response) {
        localStorage.setItem("currentUser", JSON.stringify(response));
        this.authService.isLoggedIn();
        this.msg=null;
        this.router.navigateByUrl("/profile");

      }
    },
      (error) => {
      this.msg=error.error.message;
    });
  }
}
