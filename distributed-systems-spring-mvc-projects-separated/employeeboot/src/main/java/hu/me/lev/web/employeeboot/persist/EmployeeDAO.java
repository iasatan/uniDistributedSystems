package hu.me.lev.web.employeeboot.persist;

import hu.me.lev.web.employeeboot.exception.EmployeeNotFoundException;
import hu.me.lev.web.employeeboot.model.Employee;

import java.util.List;

public interface EmployeeDAO {
    Employee selectEmployee(int id) throws EmployeeNotFoundException;

    List selectEveryEmployee();

    void updateEmployee(Employee employee);

    void insertEmployee(Employee employee);

    void deleteEmployee(Employee employee);
}
