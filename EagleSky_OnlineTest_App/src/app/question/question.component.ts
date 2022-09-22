import { IfStmt } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { interval } from 'rxjs';
import { QuestionService } from './../service/question.service';

@Component({
  selector: 'app-question',
  templateUrl: './question.component.html',
  styleUrls: ['./question.component.scss']
})
export class QuestionComponent implements OnInit {

  public name: String = "";
  public questionList: any = [];
  public currentQuestion: number = 0;
  public points: number = 0;
  counter = 60;
  correctAnswer: number = 0;
  incorrectAnswer: number = 0;
  interval$: any;
  progress: String = "0";
  isQuizCompleted : boolean = false;
  constructor(private QuestionService: QuestionService) { }

  ngOnInit(): void {
    this.name = localStorage.getItem("name")!;
    this.getAllQuestion();
    this.startCounter();
  }
  getAllQuestion() {
    this.QuestionService.getQuestionJson()
      .subscribe(res => {
        this.questionList = res.questions;
      })

  }
  nextQuestion() {
    this.currentQuestion++;
  }
  previousQuestion() {
    this.currentQuestion--;

  }
  answer(currentQun: number, option: any) {
     
    if(currentQun === this.questionList.length){
      this.isQuizCompleted = true;
      this.stopCounter();

    }
    if (option.correct) {
      this.points += 10;
      this.correctAnswer++;
      setTimeout(()=> {
        this.currentQuestion++;
        this.resetCounter();
        this.getProgressPresent();
      },1000);
    
    } else {
      setTimeout(() =>{
        this.currentQuestion++;
        this.incorrectAnswer++;
        this.resetCounter();
        this.getProgressPresent();
      },1000);
      this.points -= 10; 
      
    }
  }
  startCounter() {
    this.interval$ = interval(1000)
      .subscribe(val => {
        this.counter--;
        if (this.counter === 0) {
          this.currentQuestion++;
          this.counter = 60;
          this.points -= 10;
        }
      })
    setTimeout(() => {
      this.interval$.unsubscribe();
    }, 600000);
  }
  stopCounter() {
    this.interval$.unsubscribe();
    this.counter = 0;
  }
  resetCounter() {
    this.stopCounter();
    this.counter = 60;
    this.startCounter();
    
  }
  resetQuiz() {
    console.log("runining");
    this.resetCounter();
    this.getAllQuestion();
    this.points = 0;
    this.counter = 60;
    this.currentQuestion = 0;
    this.progress = "0";
  }
  getProgressPresent() {
    this.progress = ((this.currentQuestion/this.questionList.length) * 100).toString();
    return this.progress;

  }




}
