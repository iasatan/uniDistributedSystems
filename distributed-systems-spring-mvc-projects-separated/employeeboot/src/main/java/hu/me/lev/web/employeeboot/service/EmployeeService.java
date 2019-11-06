package hu.me.lev.web.employeeboot.service;

import hu.me.lev.web.employeeboot.exception.EmployeeNotFoundException;
import hu.me.lev.web.employeeboot.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee getEmployee(int id) throws EmployeeNotFoundException;

    List getAllEmployee();

    void addEmployee(Employee employee);

    void updateEmployee(Employee employee);

    void removeEmpoyee(Employee employee);
}
