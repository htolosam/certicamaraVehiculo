import { Component, OnInit } from '@angular/core';
import { Superficie } from '../../models/superficie';
import { Comando } from '../../models/comando';
import { SuperficieService } from '../../servicios/superficie.service';
import { ComandoService } from '../../servicios/comando.service';
import { Router } from '@angular/router';



@Component({
  selector: 'app-tablero',
  templateUrl: './tablero.component.html',
  styleUrls: ['./tablero.component.css']
})
export class TableroComponent implements OnInit {
  //datos superficie
fila:number;
columna:number;
filaRev:number;
columnaRev:number;

filaPos:number;
columnaPos:number;
//datos comando
filaCom:number;
columnaCom:number;



  sup:Superficie = new Superficie();
  com:Comando = new Comando();
  superficie:any;
  comando:any;

  constructor(private superficieService: SuperficieService,
    private comandoService:ComandoService
  ) { }

  ngOnInit() {
    this.superficieService.getSuperficie().subscribe(
      superficie => {
        this.superficie = superficie;
        console.log("superficie en init: "+JSON.stringify(superficie));
        this.fila = this.superficie.fila;
        this.columna = this.superficie.columna;

      }
    );
  }

  public create():void{
    console.log("Llegue al metodo crear superficie");
    this.superficieService.create(this.sup).subscribe(
      superficie => {
        this.superficie = superficie;
        if(this.superficie.success){
          this.fila = this.superficie.fila;
          this.columna = this.superficie.columna;
            console.log("superficie en create: "+JSON.stringify(superficie));
        }else{
          alert(this.superficie.mensaje);
        }

      }
    );
  }

  public revisarConfiguracion():void{
    this.superficieService.getSuperficie().subscribe(
      superficie => {
        this.superficie = superficie;
        this.filaRev = this.superficie.fila;
        this.columnaRev = this.superficie.columna;

      }
    );
  }

  public createComando():void{
    console.log("Llegue al metodo crear comando");
    console.log(this.com);
    this.comandoService.create(this.com).subscribe(
      comando => {
        this.comando = comando;
        if(this.comando.success){
          alert(this.comando.mensaje);
        }
        console.log("comandoen create subscribe: "+JSON.stringify(comando));
      }
    );
  }

  //eliminar comandos
  public deleteComandos():void{
    console.log("vamos a eliminar");
    this.comandoService.delete().subscribe(
      comando => {
        this.comando = comando;
        // if(this.comando.success){
          alert(this.comando.mensaje);
        // }
      }
    );
  }

  //obtener posicion dle vehiculo
  public revisarPosicion():void{
    console.log("revisemos posicion");
    this.comandoService.getPosicion().subscribe(
      comando => {
        this.comando = comando;
        this.filaPos = this.comando.fila;
        this.columnaPos = this.comando.columna;
        if(!this.comando.success){
          alert(this.comando.mensaje);
        }
      }
    );
  }

}
