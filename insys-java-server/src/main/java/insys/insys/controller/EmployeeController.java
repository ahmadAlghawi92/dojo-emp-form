package insys.insys.controller;

import insys.insys.model.Employee;
import insys.insys.model.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController // marking controller as a bean
@CrossOrigin(origins = "http://127.0.0.1:5500/")
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;
    @RequestMapping("/createEmployee")
    public Employee createEmployee(@RequestParam Integer empNum,
                                   @RequestParam String empName,
                                   @RequestParam String gender,
                                   @RequestParam String email,
                                   @RequestParam String nationality,
                                   @RequestParam String dateOfBirth) {
        Employee employee = new Employee();
        employee.setEmpNum(empNum);
        employee.setEmpName(empName);
        employee.setGender(gender);
        employee.setEmail(email);
        employee.setNationality(nationality);
        employee.setDateOfBirth(dateOfBirth);
        return employeeRepository.save(employee) ;
    }
    @RequestMapping("/getAllEmployees")
    public List<Employee> createEmployee() {
        List<Employee> employees = new ArrayList<Employee>();
        employeeRepository.findAll().forEach(employees::add);
        return employees;
    }
    @RequestMapping("/employee/{empNum}")
    public Employee getEmployee(@PathVariable("empNum") Integer empNum) {
        Employee employee = employeeRepository.findByEmpNum(empNum);
        return employee;
    }

}
