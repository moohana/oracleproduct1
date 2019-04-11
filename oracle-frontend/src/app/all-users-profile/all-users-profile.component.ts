import { Component, OnInit } from '@angular/core';
import {UserService} from "../user.service";

@Component({
  selector: 'app-all-users-profile',
  templateUrl: './all-users-profile.component.html',
  styleUrls: ['./all-users-profile.component.css']
})
export class AllUsersProfileComponent implements OnInit {

  loginuser:any;
  users:any;

  constructor(private  userService:UserService) {
    this.loginuser = JSON.parse(localStorage.getItem("currentUser"));
  }

  ngOnInit() {
    this.userService.getAllUsers(this.loginuser.token).subscribe(users => {
      this.users = users;
    });
  }
}
