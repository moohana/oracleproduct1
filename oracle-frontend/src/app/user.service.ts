import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from "rxjs";
import { environment } from '../environments/environment';
@Injectable({
  providedIn: "root"
})
export class UserService {
  savedLink=environment.savedData;
  loginLink=environment.loginData;
  allUserLink=environment.allUserData;
  singleUserLink=environment.singleUserData;


  constructor(private http: HttpClient) {
    this.http = http;
  }

  saveUser(user: any): Observable<any> {
    const headers = new HttpHeaders({ "Access-Control-Allow-Orgin": "*" });
    return this.http.post(this.savedLink, user, {
      headers: headers
    });
  }
  loginUser(user: any): Observable<any> {
    const headers = new HttpHeaders({ "Access-Control-Allow-Orgin": "*" });
    return this.http.post(this.loginLink, user, {
      headers: headers
    });
  }
  getAllUsers(token: any): Observable<any> {
    const headers = new HttpHeaders({ Authorization: "Bearer " + token });
    return this.http.get(this.allUserLink, { headers: headers });
  }
  getUser(token: any): Observable<any> {
    const headers = new HttpHeaders({ Authorization: "Bearer " + token });
    return this.http.get(this.singleUserLink, { headers: headers });
  }
}
