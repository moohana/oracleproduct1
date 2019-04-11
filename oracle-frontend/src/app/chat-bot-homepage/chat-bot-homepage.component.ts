import {Component, HostListener, OnInit} from "@angular/core";
import {ItChatServiceService} from "../it-chat-service.service";
import {CdkDragDrop, moveItemInArray, transferArrayItem} from '@angular/cdk/drag-drop';


interface Status {
  accepted: boolean;
  answered: boolean;
}
interface Query {
  question: string;
  answer: string;
}
interface UserQuery {
  queryAnswer: Query;
  status: Status;
}

@Component({
  selector: "app-chat-bot-homepage",
  templateUrl: "./chat-bot-homepage.component.html",
  styleUrls: ["./chat-bot-homnpepage.component.css"]
})
export class ChatBotHomepageComponent implements OnInit {
  constructor(private chatService: ItChatServiceService) {}

  queryAnswer: Query = {
    question: "",
    answer: ""
  };
  status: Status = {
    accepted: false,
    answered: false
  };

  queryList: any = [];
  botItems:any=[  {"icon":"fas fa-dollar-sign","name":"Stock"},
                  {"icon":"fas fa-train","name":"Train"},
                  {"icon":"fas fa-plane","name":"Air-Ticket"},
                  {"icon":"fas fa-cloud","name":"Weather"}
                ];
  botBasket:any=[{"icon":"fas fa-cloud","name":"Weather"}];

  ngOnInit() {

  }
  // chat sending and receiving
  onSubmit(value) {
    let jsonQuery = JSON.stringify({ queryAnswer: this.queryAnswer, status: this.status });
    console.log("submitted" + jsonQuery);
    this.queryList.push(JSON.parse(jsonQuery));
    this.chatService.getQuery(jsonQuery).subscribe((value1 :any) => {
      console.log(value1);
      value1.forEach(data=>{
      this.queryList.push(data)});
    });
    console.log(this.queryList);

    value.reset();
  }

  // drag event handle
  drop(event: CdkDragDrop<any[]>) {
    if (event.previousContainer === event.container) {
      moveItemInArray(event.container.data, event.previousIndex, event.currentIndex);
    } else {
      transferArrayItem(event.previousContainer.data,
        event.container.data,
        event.previousIndex,
        event.currentIndex);
    }
  }
  // after accepted answer
  submitAccepted(data){
    data.status.accepted  =true;
    data.queryAnswer.id=10;
    this.chatService.saveQuery(data).subscribe((value1 :any) => {
      console.log(value1);
    });
  }

}
