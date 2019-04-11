import { Injectable } from '@angular/core';
import { HttpClient }    from '@angular/common/http';
import { Router } from '@angular/router';
import{environment} from '../environments/environment';
import { questions } from 'src/questions';
import {sendAnswer} from 'src/sendAnswer'

@Injectable({
  providedIn: 'root'
})
export class ManaualApiService {

  answer:string = "";

  constructor(private http:HttpClient,private router:Router) { }

//get all questions 
getAllQuestions():any {
  return this.http.get(environment.manaul_answer+"questions")
  
}

// Answer a UnAnsered Questions 
getQuestionByTopic(concept:String):any {
 console.log(environment.manaul_answer+"question/"+concept);
 return this.http.get(environment.manaul_answer+"question/"+concept);
}

//Post a answer 

postAnswer(question:questions):any {
  
 let sendAnswer:sendAnswer =  {
   id: question.id,
   question: question.question,
   answer:this.answer
  };

 console.log(sendAnswer);
 return this.http.post(environment.manaul_answer+"question/"+question.concept, sendAnswer,{responseType:'text'})
 
}
}
