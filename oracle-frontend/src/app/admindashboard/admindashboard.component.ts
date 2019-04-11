import { Component, OnInit } from "@angular/core";
import { UserService } from "../user.service";
import { LoginAuthenticationService } from "../login-authentication.service";

@Component({
  selector: "app-admindashboard",
  templateUrl: "./admindashboard.component.html",
  styleUrls: ["./admindashboard.component.css"]
})
export class AdmindashboardComponent implements OnInit {

  constructor(
    private authService: LoginAuthenticationService,
    private userService: UserService
  ) {

  }
  ngOnInit(): void {
  }


}
