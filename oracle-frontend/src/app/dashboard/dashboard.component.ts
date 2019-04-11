import {Component, OnInit, OnChanges, SimpleChanges} from "@angular/core";
import { Router } from "@angular/router";
import { LoginAuthenticationService } from "../login-authentication.service";

@Component({
  selector: "app-dashboard",
  templateUrl: "./dashboard.component.html",
  styleUrls: ["./dashboard.component.css"]
})
export class DashboardComponent implements OnInit {

  public currentstatus: boolean;

  constructor(
    private authService: LoginAuthenticationService,
    private router: Router
  ){


  }
  logout() {
    localStorage.removeItem("currentUser");
    this.authService.isLoggedIn();
    this.router.navigate(["login"]);

  }
  ngOnInit() {
    this.authService
      .getStatus()
      .subscribe(currentstatus => {
        this.currentstatus = currentstatus.status;
      });
  }

    // changes.prop contains the old and the new value...


}
