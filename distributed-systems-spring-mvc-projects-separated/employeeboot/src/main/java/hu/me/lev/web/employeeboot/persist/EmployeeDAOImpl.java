package hu.me.lev.web.employeeboot.persist;

import hu.me.lev.web.employeeboot.exception.EmployeeNotFoundException;
import hu.me.lev.web.employeeboot.model.Employee;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeDAOImpl implements EmployeeDAO {
    private Map<Integer, Employee> employees;

    public EmployeeDAOImpl(Map<Integer, Employee> employees) {
        this.employees = employees;
    }

    public EmployeeDAOImpl() {
        employees = new HashMap<>();
        employees.put(1, new Employee(1, "Adam", 23, 70000));

    }

    @Override
    public Employee selectEmployee(int id) throws EmployeeNotFoundException {
        if (!employees.keySet().contains(id)) {
            throw new EmployeeNotFoundException();
        }
        return employees.get(id);
    }

    @Override
    public List selectEveryEmployee() {
        return null;
    }

    @Override
    public void updateEmployee(Employee employee) {

    }

    @Override
    public void insertEmployee(Employee employee) {
        employees.put(employee.getId(), employee);
    }

    @Override
    public void deleteEmployee(Employee employee) {

    }
}
