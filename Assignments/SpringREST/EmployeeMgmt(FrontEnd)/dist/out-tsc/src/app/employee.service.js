import * as tslib_1 from "tslib";
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';
var EmployeeService = /** @class */ (function () {
    function EmployeeService(http) {
        this.http = http;
        this.BASE_URL = "http://localhost:8080/SpringRestHelloWorld/";
        this.Resource = "employee";
    }
    EmployeeService.prototype.getAllEmp = function () {
        return this.http.get("" + this.BASE_URL + this.Resource)
            .pipe(map(function (response) { return response; }));
    };
    EmployeeService.prototype.addEmp = function (emp) {
        return this.http.post("" + this.BASE_URL + this.Resource, emp);
    };
    EmployeeService.prototype.find = function (empID) {
        return this.http.get("" + this.BASE_URL + this.Resource + "/" + empID);
    };
    EmployeeService.prototype.deleteEmp = function (empID) {
        return this.http.delete("" + this.BASE_URL + this.Resource + "/" + empID);
    };
    EmployeeService = tslib_1.__decorate([
        Injectable({ providedIn: 'root' }),
        tslib_1.__metadata("design:paramtypes", [HttpClient])
    ], EmployeeService);
    return EmployeeService;
}());
export { EmployeeService };
//# sourceMappingURL=employee.service.js.map