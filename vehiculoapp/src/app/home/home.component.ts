import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  nombres:string = "Ho Chi Minh Tolosa Morales";
  identificacion:number = 72051587;
  celular:number = 3006593203

  constructor() {

  }

  ngOnInit() {
  }

}
