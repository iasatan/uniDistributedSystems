package hu.me.lev.web.employeeboot.service;

import hu.me.lev.web.employeeboot.exception.EmployeeNotFoundException;
import hu.me.lev.web.employeeboot.model.Employee;
import hu.me.lev.web.employeeboot.persist.EmployeeDAO;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDAO employeeDAO;

    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public Employee getEmployee(int id) throws EmployeeNotFoundException {
        if (id < 1) {
            throw new InvalidParameterException("id cannot be less then one");
        }
        return employeeDAO.selectEmployee(id);
    }

    @Override
    public List getAllEmployee() {
        return null;
    }

    @Override
    public void addEmployee(Employee employee) {
        if (employee.getId() < 1) {
            throw new InvalidParameterException("ID cannot be less than one");
        }
        employeeDAO.insertEmployee(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {

    }

    @Override
    public void removeEmpoyee(Employee employee) {

    }
}
