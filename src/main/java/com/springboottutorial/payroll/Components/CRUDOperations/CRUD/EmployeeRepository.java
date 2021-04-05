package com.springboottutorial.payroll.Components.CRUDOperations.CRUD;
import com.springboottutorial.payroll.Components.CRUDOperations.DAO.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
