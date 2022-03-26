import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Patient } from '../patient';
import { PatientserService } from '../patientser.service';

@Component({
  selector: 'app-patient-list',
  templateUrl: './patient-list.component.html',
  styleUrls: ['./patient-list.component.css']
})
export class PatientListComponent implements OnInit {

patients : Patient[] = [];

  constructor(private patientserv : PatientserService,
    private router: Router
    ) { }

  ngOnInit(): void {

 this.getPatients();
    }

    private getPatients(){
      this.patientserv.getPatientList().subscribe(data =>{
        this.patients = data;
      })
    }

    // view single data
    updatePatient(id:number){
 this.router.navigate(['update-patient', id]);
    }


    //delete patient
deletePatient(id:number){
 this.patientserv.deletePatient(id).subscribe(data =>{
  console.log(data);
  this.getPatients();
 })


}
//view all patient
patientDetails(id: number){
  this.router.navigate(['patient-details', id]);
}

}
