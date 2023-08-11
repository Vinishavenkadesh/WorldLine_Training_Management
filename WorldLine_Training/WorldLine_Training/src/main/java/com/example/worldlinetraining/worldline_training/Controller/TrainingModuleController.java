package com.example.worldlinetraining.worldline_training.Controller;

import com.example.worldlinetraining.worldline_training.Entity.TrainingModule;
import com.example.worldlinetraining.worldline_training.Service.TrainingModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin

@RequestMapping("module")
@RestController
public class TrainingModuleController {

    @Autowired
    private TrainingModuleService trainingModuleService;


    @GetMapping("/get-module/{id}")
    private Optional<TrainingModule> getModule(@PathVariable("id") Long id){
        return trainingModuleService.getModule(id);

    }
    @GetMapping("/get-modules")
    public List<TrainingModule> getModules(){
        return trainingModuleService.getModules();
    }

    @GetMapping("/get-student")
    private String getStudent(String Name){
        return trainingModuleService.getStudent(Name);
    }

    @PostMapping("/post-module")
    private TrainingModule postModule(@RequestBody TrainingModule trainingModule){
        return trainingModuleService.postModule(trainingModule);
    }
    @PostMapping("/post-modules")
    private List<TrainingModule> postModules(@RequestBody List<TrainingModule> trainingModules){
        return trainingModuleService.postModules(trainingModules);
    }

    @DeleteMapping("/delete-module/{id}")
    private String deleteModule(@PathVariable("id") Long id){
       return trainingModuleService.deleteModule(id);
    }

    @PutMapping("/update-module/{id}")
    private TrainingModule updateModule(@PathVariable("id") Long id, @RequestBody TrainingModule trainingModule){
        return trainingModuleService.updateModule(id, trainingModule);
    }
    @GetMapping("/search-module/{var}")
    private List<TrainingModule> searchModule(@PathVariable("var") String var){
        return trainingModuleService.searchModule(var);
    }



}
