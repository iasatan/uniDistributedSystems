package hu.me.lev.web.employeeboot.controller;

import hu.me.lev.web.employeeboot.exception.BadEmployeeFormatException;
import hu.me.lev.web.employeeboot.exception.EmployeeNotFoundException;
import hu.me.lev.web.employeeboot.model.Employee;
import hu.me.lev.web.employeeboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class EmployeeController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("asd")
    @ResponseBody
    public String asd() {
        return "asd";
    }

    @RequestMapping(value = "/getEmployee")
    @ResponseBody
    public String getEmployee(@RequestParam("id") int id) throws EmployeeNotFoundException {
        return employeeService.getEmployee(id).toString();
    }


    @RequestMapping(value = "/addEmployee")
    public String addEmployee(@RequestParam("id") int id,
                              @RequestParam("name") String name,
                              @RequestParam("age") int age,
                              @RequestParam("salary") int salary) {
        employeeService.addEmployee(new Employee(id, name, age, salary));
        return "OK";
    }

    @PostMapping(value = "/AddEmployee", consumes = "application/json")
    @ResponseBody
    public String addEmployeeObJ(@Valid @RequestBody Employee employee, BindingResult bindingResult) throws BadEmployeeFormatException {
        System.out.println(employee);
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getAllErrors());
            throw new BadEmployeeFormatException();
        }
        employeeService.addEmployee(employee);
        return "ok";
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    public String EmployeeNotFoundExceptionHandler() {
        return "No employee found with that id";
    }

    @ExceptionHandler(BadEmployeeFormatException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void badEmployeeExceptionHandler() {

    }

}
