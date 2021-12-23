import { Component, OnInit } from '@angular/core';
import { Employee } from 'src/app/common/employee';
import { EmployeeService } from 'src/app/services/employee.service';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {

  constructor(private employeeService: EmployeeService) { }

  employees : Employee[];

  ngOnInit(): void {
    this.getEmployees();
  }


  getEmployees() {
this.employeeService.getEmployeesList().subscribe( data => {
 this.employees = data});
  }

}
