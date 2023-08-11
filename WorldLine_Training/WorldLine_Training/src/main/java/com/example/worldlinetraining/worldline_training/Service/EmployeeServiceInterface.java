package com.example.worldlinetraining.worldline_training.Service;

import com.example.worldlinetraining.worldline_training.Entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeServiceInterface{
    public Employee postEmployee(Employee employee);
    public List<Employee> postEmployees(List<Employee> employees);
    public Optional<Employee> getEmployee(Long id);
    public Employee assignModule(Long empId, Long moduleId);
    public Employee updateProgress(Long employeeId, Integer progress);
    public String deleteEmployee(Long id);
    public List<Employee> getEmployees();

    public List<Employee> assignModuleToEmployees(Long ModuleId, Long start, Long end);

}
