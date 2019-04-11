import {Component, OnInit} from "@angular/core";
import {UserService} from "../user.service";
import {LoginAuthenticationService} from "../login-authentication.service";
import {FormControl, FormGroupDirective, NgForm, Validators} from '@angular/forms';
import {register} from "ts-node";

@Component({
  selector: "app-signup",
  templateUrl: "./signup.component.html",
  styleUrls: ["./signup.component.css"]
})
export class SignupComponent implements OnInit {
  user: any = {};
  registerSuccessMsg: any = "";
  registered: boolean = false;
  alreadyRegistered: boolean = false;

  constructor(
    private userService: UserService,
    private authService: LoginAuthenticationService
  ) {

  }

  ngOnInit() {
  }

  saveUser(user: any, userForm: any) {
    user.enable = true;
    user.role = "USER";
    this.userService.saveUser(user).subscribe(response => {
      console.log(response);
      this.alreadyRegistered = false;
      this.registered = true;
      this.registerSuccessMsg = response.message;
      userForm.reset();
    },
      (error)=>{
        this.registered = false;
        this.alreadyRegistered=true;
        this.registerSuccessMsg=error.error.message;
      }
    );
  }
}
