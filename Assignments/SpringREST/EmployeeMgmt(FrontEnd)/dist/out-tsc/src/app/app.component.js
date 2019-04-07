import * as tslib_1 from "tslib";
import { Component } from '@angular/core';
import { FormControl } from "@angular/forms";
import { EmployeeService } from './employee.service';
var AppComponent = /** @class */ (function () {
    function AppComponent(service) {
        this.service = service;
        this.title = 'Employee Management App';
        //empObj:Employee;
        this.name = new FormControl('');
        this.dob = new FormControl('');
        this.gender = new FormControl('');
        this.department = new FormControl('');
        this.salary = new FormControl('');
    }
    AppComponent.prototype.ngOnInit = function () {
        this.getAllEmployees();
    };
    AppComponent.prototype._calculateAge = function (birthday) {
        var ageDifMs = Date.now() - Date.parse(birthday);
        var ageDate = new Date(ageDifMs); // miliseconds from epoch
        return Math.abs(ageDate.getUTCFullYear() - 1970);
    };
    AppComponent.prototype.getAllEmployees = function () {
        var _this = this;
        this.service.getAllEmp()
            .subscribe(function (data) {
            _this.employees = data;
        }, function (error) {
            console.log(error);
            //alert(error);
        });
    };
    AppComponent.prototype.add = function () {
        // console.log(this.name.value);
        // console.log(this._calculateAge(this.dob.value));
        var _this = this;
        if (this.name.value != '' && this.dob.value != '' && this.gender.value != '' && this.department.value != '' && this.salary.value != '') {
            console.log('if hit');
            var empObj = {
                name: this.name.value,
                age: this._calculateAge(this.dob.value),
                gender: this.gender.value,
                department: this.department.value,
                salary: this.salary.value
            };
            // this.empObj.
            // this.empObj.age = parseInt(this._calculateAge(this.dob.value));
            // this.empObj.gender = this.gender.value;
            // this.empObj.department = this.department.value;
            // this.empObj.salary = parseInt(this.salary.value);
            this.service.addEmp(empObj)
                .subscribe(function (data) {
                alert('Employee added');
                _this.getAllEmployees();
            }, function (error) {
                alert(error);
            });
        }
    };
    AppComponent.prototype.getEmp = function (empID) {
        this.service.find(empID)
            .subscribe(function (data) {
            console.log(data);
        }, function (error) {
            console.log(error);
        });
    };
    AppComponent.prototype.delete = function (empID) {
        var _this = this;
        this.service.deleteEmp(empID)
            .subscribe(function (data) {
            console.log(data);
            _this.getAllEmployees();
        }, function (error) {
            console.log(error);
        });
    };
    AppComponent = tslib_1.__decorate([
        Component({
            selector: 'app-root',
            templateUrl: './app.component.html',
            styleUrls: ['./app.component.css'],
        }),
        tslib_1.__metadata("design:paramtypes", [EmployeeService])
    ], AppComponent);
    return AppComponent;
}());
export { AppComponent };
//# sourceMappingURL=app.component.js.map