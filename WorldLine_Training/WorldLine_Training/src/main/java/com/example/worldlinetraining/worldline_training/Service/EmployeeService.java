package com.example.worldlinetraining.worldline_training.Service;

import com.example.worldlinetraining.worldline_training.Entity.Employee;
import com.example.worldlinetraining.worldline_training.Entity.TrainingModule;
import com.example.worldlinetraining.worldline_training.Repository.EmployeeRepo;
import com.example.worldlinetraining.worldline_training.Repository.TrainingModuleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements EmployeeServiceInterface{
    @Autowired
    public EmployeeRepo employeeRepo;
    @Autowired
    public TrainingModuleRepo trainingModuleRepo;
    @Override
    public Employee postEmployee(Employee employee) {
       return employeeRepo.save(employee);
    }

    @Override
    public List<Employee> postEmployees(List<Employee> employees) {
        return employeeRepo.saveAll(employees);
    }

    @Override
    public Optional<Employee> getEmployee(Long id) {
        return employeeRepo.findById(id);
    }

    @Override
    public Employee assignModule(Long empId, Long moduleId) {
        TrainingModule module = trainingModuleRepo.findById(moduleId).get();
        Employee employee = employeeRepo.findById(empId).get();
        employee.setTrainingModule(module);
        return employeeRepo.save(employee);
    }

    @Override
    public List<Employee> assignModuleToEmployees(Long moduleId,Long start,Long end) {
        TrainingModule module = trainingModuleRepo.findById(moduleId).get();
        for(Long i = start;i<=end;i++){
            Employee employee = employeeRepo.findById(i).get();
            if(employee!= null) {
                employee.setTrainingModule(module);
                employeeRepo.save(employee);
            }
        }
        return employeeRepo.findAll();
    }


    @Override
    public Employee updateProgress(Long employeeId, Integer progress) {
        Employee employee = employeeRepo.findById(employeeId).get();
        if(employee.getTrainingModule()!= null){
          if(employee.getProgress()!=null){
               employee.setProgress(progress);
          }
        }
        return employeeRepo.save(employee);
    }

    @Override
    public String deleteEmployee(Long id) {
        try {
            employeeRepo.deleteById(id);
            return "Deleted Suucessfully";
        }
        catch (Exception e){
            return "Failed to delete";
        }
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeRepo.findAll();
    }



}
