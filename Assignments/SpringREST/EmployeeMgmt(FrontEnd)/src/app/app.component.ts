import { Component, OnInit } from "@angular/core";
import { ReactiveFormsModule, FormControl } from "@angular/forms";

import { Employee } from "./Employee";
import { EmployeeService } from "./employee.service";

@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styleUrls: ["./app.component.css"]
})
export class AppComponent implements OnInit {
  title = "Employee Management App";
  actionTitle = "Add Employee";

  employees: Employee[];
  empID;
  name;
  dob;
  gender;
  department;
  salary;

  emp: Employee;

  showAddForm = false;
  showEditForm = false;


  constructor(private service: EmployeeService) {}

  ngOnInit() {
    this.getAllEmployees();
  }

  //Toggle visiblity of add form
  showForm() {
    this.showEditForm = false;
    this.showAddForm = !this.showAddForm;
  }

  //Calculate the age based of DOB
  _calculateAge(birthday) {
    // birthday is a date
    var ageDifMs = Date.now() - Date.parse(birthday);
    var ageDate = new Date(ageDifMs); // miliseconds from epoch
    return Math.abs(ageDate.getUTCFullYear() - 1970);
  }

  //Fetch the list of employees
  getAllEmployees() {
    this.service.getAllEmp().subscribe(
      data => {
        this.employees = data;
      },
      error => {
        console.log(error);
      }
    );
  }

  //Add Employee
  submit() {
    if (
      this.name != "" &&
      this.dob != "" &&
      this.gender != "" &&
      this.department != "" &&
      this.salary != ""
    ) {
      //Constructing Employee JSON object
      let empObj = {
        name: this.name,
        age: this._calculateAge(this.dob),
        gender: this.gender,
        department: this.department,
        salary: this.salary
      };

      this.service.addEmp(empObj).subscribe(
        data => {
          alert("Employee added");
          this.showAddForm = false;
          this.name = this.dob = this.gender = this.department = this.salary =
            "";
          this.getAllEmployees();
        },
        error => {
          alert(error);
        }
      );
    }
  }

  //Fetch an employee based on employee ID
  getEmp(empID: number) {
    this.service.find(empID).subscribe(
      data => {
        console.log(data);
      },
      error => {
        console.log(error);
      }
    );
  }

  //Delete an employee based on employee ID
  delete(empID: number) {
    try {
      this.service.deleteEmp(empID).subscribe(
        data => {
          console.log(data);
        },
        error => {
         // console.log(error);
        }
      );
      console.log('try block');
      //Refreshing the employee List
      this.getAllEmployees();

      console.log('after get all');

    } catch (error) {
      console.log(error);
    }
  }

  edit(empID: number){
    this.showAddForm = false;
    this.showEditForm = true;

    try {
      this.service.find(empID).subscribe(
        data =>{
          this.empID = data.empID;
          this.name = data.name;
          this.dob = '';
          this.gender = data.gender;
          this.department = data.department;
          this.salary = data.salary;
        }
      );

    } catch (error) {

    }
  }

  update(){
    if (
      this.name != "" &&
      this.dob != "" &&
      this.gender != "" &&
      this.department != "" &&
      this.salary != ""
    ) {
      //Constructing Employee JSON object
      let empObj = {
        empID : this.empID,
        name: this.name,
        age: this._calculateAge(this.dob),
        gender: this.gender,
        department: this.department,
        salary: this.salary
      };

      this.service.updateEmp(empObj).subscribe(
        data => {
          alert(data);
          this.showEditForm = false;
          this.name = this.dob = this.gender = this.department = this.empID = this.salary =
            "";
          this.getAllEmployees();
        },
        error => {
          console.log(error);
        }
      );
      this.getAllEmployees();
    }
  }


}
