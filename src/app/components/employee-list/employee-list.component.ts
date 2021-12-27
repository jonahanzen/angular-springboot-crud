import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Employee } from 'src/app/common/employee';
import { EmployeeService } from 'src/app/services/employee.service';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {

  constructor(private employeeService: EmployeeService, private router: Router) { }

  employees : Employee[];

  ngOnInit(): void {
    this.getEmployees();
  }


  getEmployees() {
this.employeeService.getEmployeesList().subscribe( data => {
 this.employees = data});
  }

  updateEmployee(id : number) {
this.router.navigate(['update-employee', id])
  }

  deleteEmployee(id: number) {
this.employeeService.deleteEmployee(id).subscribe( data => {
  this.getEmployees()
})
  }

  employeeDetails(id: number) {
    this.router.navigate(['employee-details', id])
  }

}
