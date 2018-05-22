import { Injectable } from '@angular/core';
import { Comando } from '../models/comando';
import {  ENDPOINTCOMANDO } from '../utilidades/endpoints';
import {map} from 'rxjs/operators';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ComandoService {
  private httpHeaders = new HttpHeaders({'Content-Type':'application/json' });
  constructor(private http: HttpClient) { }

  create(comando:Comando){
    return this.http.post(ENDPOINTCOMANDO, comando, {headers: this.httpHeaders});
  }

  delete(){
    return this.http.delete(ENDPOINTCOMANDO, {headers: this.httpHeaders});
  }

  getPosicion(){
    return this.http.get<any>(ENDPOINTCOMANDO, {headers: this.httpHeaders});
  }

}
