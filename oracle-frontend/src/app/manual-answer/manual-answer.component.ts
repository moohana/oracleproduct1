import { Component, OnInit } from '@angular/core';
import{questions} from 'src/questions'
import{userQuery} from 'src/userQuery'
import { from } from 'rxjs';
import { ManaualApiService } from '../manaual-api.service'

@Component({
  selector: 'app-manual-answer',
  templateUrl: './manual-answer.component.html',
  styleUrls: ['./manual-answer.component.css']
})
export class ManualAnswerComponent implements OnInit {


  question:questions[] = []
  userQuery:userQuery[] = []

  constructor(private manual_api:ManaualApiService) { }
  ngOnInit() {

    this.manual_api.getAllQuestions().subscribe(data => {

      console.log(data);

     this.question = [];
    let userQuery:[userQuery] = data;

    for(var i = 0;i <userQuery.length;i++){

    let questionList:[questions] =  data[i].query;
    for(var j = 0;j<questionList.length;j++){
      questionList[j].concept = userQuery[i].concept;
      this.question.push(questionList[j]);
    }
    }
    console.log(questions)

  })
  }

   // Search the Unanswered question by topic name 

searchByTopic(topic:string){
  console.log(topic);
  this.manual_api.getQuestionByTopic(topic).subscribe(data => {
    console.log(data.query);
    let questionList:questions[] = data.query;
    this.question = questionList;
    console.log(data);
 })
}

  //card data
  submitAnswer(question:questions,answer:string):any{
    this.manual_api.answer = answer;
    console.log(answer)
    this.postData(question)
  }
  
  postData(quest:questions){
  
  this.manual_api.postAnswer(quest).subscribe((data) => {
    console.log(data);
    const index = this.question.indexOf(quest, 0);
    if (index > -1) {
       this.question.splice(index, 1);
    }
  })
  
  }
}
