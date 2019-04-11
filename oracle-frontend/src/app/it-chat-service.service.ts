import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { HttpHeaders, HttpClient } from "@angular/common/http";

@Injectable({
  providedIn: "root"
})
export class ItChatServiceService {
  constructor(private http: HttpClient) {}
  //get chat response
  private options = {
    headers: new HttpHeaders()
      .set("Content-Type", "application/json")
      .append("Access-Control-Allow-Origin", "*")
  };
  getQuery(queryAnswer) {
    return this.http.post(
      "http://localhost:8090/api/v1/getanswer",
      queryAnswer,
      this.options
    );
  }
  saveQuery(queryAnswer) {
    return this.http.post(
      "http://localhost:8090/api/v1/saveanswer",
      queryAnswer,
      this.options
    );
  }
}
