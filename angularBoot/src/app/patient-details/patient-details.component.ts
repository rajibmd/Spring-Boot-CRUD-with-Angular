import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Patient } from '../patient';
import { PatientserService } from '../patientser.service';

@Component({
  selector: 'app-patient-details',
  templateUrl: './patient-details.component.html',
  styleUrls: ['./patient-details.component.css']
})
export class PatientDetailsComponent implements OnInit {

  id!: number;
  patient: any = Patient;
  constructor(private route: ActivatedRoute,
    private patientservi : PatientserService
    ) { }

  ngOnInit(): void {

    this.id = this.route.snapshot.params['id'];

    this.patient = new Patient();
    this.patientservi.getPatientById(this.id).subscribe(data => {
      this.patient = data;
    })
  }

}
