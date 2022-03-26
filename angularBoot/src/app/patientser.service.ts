import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { observable, Observable, throwError } from 'rxjs';
import { Patient } from './patient';


@Injectable({
  providedIn: 'root'
})
export class PatientserService {

  private baseUrl = "http://localhost:8080/api/patients";

  constructor(private httpclient : HttpClient) { }


  //get all patient
  getPatientList(): Observable<Patient[]>{
    return this.httpclient.get<Patient[]>(`${this.baseUrl}`);
  }

  // save Patient
  savePatient(patient:Patient):Observable<Object>{
    return this.httpclient.post(`${this.baseUrl}`, patient);

  }

  //getting id for update patient
  getPatientById(id:number):Observable<Patient>{
    return this.httpclient.get<Patient>(`${this.baseUrl}/${id}`);

}
// Patient is updated here
  updatePatient(patient:Patient):Observable<Object>{
      return this.httpclient.put(`${this.baseUrl}`, patient);

  }

//delete paitent
deletePatient(id:number):Observable<Object>{

  return this.httpclient.delete(`${this.baseUrl}/${id}`);
}

}
