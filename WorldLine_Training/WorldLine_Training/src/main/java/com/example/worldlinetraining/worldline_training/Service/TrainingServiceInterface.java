package com.example.worldlinetraining.worldline_training.Service;

import com.example.worldlinetraining.worldline_training.Entity.TrainingModule;

import java.util.List;
import java.util.Optional;

public interface TrainingServiceInterface {

    public Optional<TrainingModule> getModule(Long id);
    public List<TrainingModule> getModules();
    public  TrainingModule postModule(TrainingModule trainingModule);
    public List<TrainingModule> postModules(List<TrainingModule> trainingModules);
    public String deleteModule(Long id);
    public TrainingModule updateModule(Long id,TrainingModule trainingModule);
    public String getStudent(String Name);
    public List<TrainingModule> searchModule(String Name);


}
