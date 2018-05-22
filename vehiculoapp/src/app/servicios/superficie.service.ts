import { Injectable } from '@angular/core';
import { Superficie } from '../models/superficie';

import { Observable } from 'rxjs';
// import { of } from 'rxjs';
import {map} from 'rxjs/operators';
import { ENDPOINTSUPERFICIE } from '../utilidades/endpoints';

import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class SuperficieService {

  private httpHeaders = new HttpHeaders({'Content-Type':'application/json' });

  constructor(private http: HttpClient) { }

  //servicio para obtener la superficie
  getSuperficie():Observable<any>{
    let url = `${ENDPOINTSUPERFICIE}/1`;
    let respuesta = this.http.get<any>(url, {headers: this.httpHeaders});
    return respuesta;
  }

  //servicio para crear superfice
  create(superficie:Superficie){
    return this.http.post(ENDPOINTSUPERFICIE, superficie, {headers: this.httpHeaders});
  }



}
