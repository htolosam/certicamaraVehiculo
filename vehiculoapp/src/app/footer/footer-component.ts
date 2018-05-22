import { Component } from '@angular/core';

@Component({
  styleUrls: ['./footer-component.css'],
  selector: 'app-footer',
  templateUrl: './footer-component.html'
})

export class FooterComponent {
  public autor:any = { nombre: 'ho hi minh', apellido: 'tolosa'};
}
