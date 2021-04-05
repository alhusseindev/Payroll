package com.springboottutorial.payroll.Components.CRUDOperations.DAO;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Employee{
    private @Id @GeneratedValue long id;
    private String name;
    private String role;

    //Default Constructor - Constructor Injection
    public Employee(){

    }

    /* Our Actual Constructor */
    public Employee(String name, String role){
        this.name = name;
        this.role = role;
    }

    //Getters
    public long getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }

    public String getRole(){
        return this.role;
    }

    //Setters
    public void setId(long id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }

    public void setRole(String role){
        this.role = role;
    }

    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(!(o instanceof Employee)){
            return false;
        }

        //casting o to type Employee and then assigning it to variable myEmployee, which is of type Employee
        //here we are casting o to type Employee instead of type Object
        Employee myEmployee = (Employee) o;
        return Objects.equals(this.id, myEmployee.id) && Objects.equals(this.name, myEmployee.name) && Objects.equals(this.role, myEmployee.role);
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.id, this.name, this.role);
    }




    //toString() method
    public String toString(){
        return String.format("Employee{\nId: %d \nName: %s\nRole: %s\n}", this.id, this.name, this.role);
    }

}