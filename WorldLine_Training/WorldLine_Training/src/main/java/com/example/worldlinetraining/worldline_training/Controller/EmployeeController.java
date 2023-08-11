package com.example.worldlinetraining.worldline_training.Controller;

import com.example.worldlinetraining.worldline_training.Entity.Employee;
import com.example.worldlinetraining.worldline_training.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RequestMapping("employee")
@RestController
public class EmployeeController {
    @Autowired
    public EmployeeService employeeService;

    @GetMapping("/get-employee/{id}")
    public Optional<Employee> getEmployee(@PathVariable("id") Long id){
        return employeeService.getEmployee(id);
    }

    @GetMapping("/get-employees")
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }

    @PostMapping("/post-employee")
    public Employee postEmployee(@RequestBody Employee employee){
        return employeeService.postEmployee(employee);
    }

    @PostMapping("/post-employees")
    private List<Employee> postModules(@RequestBody List<Employee> employees){
        return employeeService.postEmployees(employees);
    }

    @PostMapping("/assign-module")
    public Employee assignModule(@RequestParam("empid") Long employeeId, @RequestParam("moduleid") Long moduleId){
        return employeeService.assignModule(employeeId,moduleId);

    }
    @PostMapping("/assign-module/to-all/{id}")
    public List<Employee> assignModuleToEmployees(@PathVariable("id") Long moduleId, @RequestParam("start") Long start, @RequestParam("end") Long end){
        return employeeService.assignModuleToEmployees(moduleId,start,end);
    }
    @PutMapping("/update-progress/{id}")
    public Employee updateProgress(@PathVariable("id") Long id,@RequestParam("progress") Integer progress){
        return employeeService.updateProgress(id,progress);
    }
    @DeleteMapping("/delete-employee/{id}")
    public void deleteEmployee(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);
    }

}
