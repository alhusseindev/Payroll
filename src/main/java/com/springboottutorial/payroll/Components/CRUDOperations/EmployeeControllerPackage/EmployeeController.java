package com.springboottutorial.payroll.Components.CRUDOperations.EmployeeControllerPackage;
import com.springboottutorial.payroll.Components.CRUDOperations.CRUD.EmployeeRepository;
import com.springboottutorial.payroll.Components.CRUDOperations.DAO.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class EmployeeController{
    private final EmployeeRepository myEmployeeRepository;

    //Constructor
    public EmployeeController(EmployeeRepository myEmployeeRepo){
        this.myEmployeeRepository = myEmployeeRepo;
    }

    //Get Operation
    @GetMapping("/employees")
    public List<Employee> listEmployees(){
        return myEmployeeRepository.findAll();
    }

    //get single item
    @GetMapping("/employees/get/{id}")
    public Employee oneEmployee(@PathVariable Long id) throws Exception {
        return myEmployeeRepository.findById(id).orElseThrow(() -> new Exception("Employee Not Found"));
    }

    @PostMapping("/employees/create/")
    public Employee createEmployee(@RequestBody Employee newEmployee){
        return myEmployeeRepository.save(newEmployee);
    }

    @PutMapping("/employees/put/{id}")
    public Employee updateEmployee(@RequestBody Employee newEmployee, @PathVariable long id){
        return myEmployeeRepository.findById(id).map((employee) ->{
            employee.setName(newEmployee.getName());
            employee.setRole(newEmployee.getRole());
            return myEmployeeRepository.save(employee);
        }).orElseGet(() ->{
            newEmployee.setId(id);
            return myEmployeeRepository.save(newEmployee);
        });
    }

    @DeleteMapping("/employees/delete/{id}")
    public void deleteEmployee(@PathVariable long id){
        myEmployeeRepository.deleteById(id);
    }
}