package com.example.worldlinetraining.worldline_training.Service;

import com.example.worldlinetraining.worldline_training.Entity.TrainingModule;
import com.example.worldlinetraining.worldline_training.Repository.TrainingModuleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class TrainingModuleService implements TrainingServiceInterface{
    @Autowired
    private TrainingModuleRepo trainingModuleRepo;
    private int length(){
        return trainingModuleRepo.findAll().size();
    }

    @Override
    public Optional<TrainingModule> getModule(Long id) {
        return trainingModuleRepo.findById(id);
    }

    @Override
    public List<TrainingModule> getModules() {
        return trainingModuleRepo.findAll();
    }

    @Override
    public TrainingModule postModule(TrainingModule trainingModule) {
        return trainingModuleRepo.save(trainingModule);
    }

    @Override
    public List<TrainingModule> postModules(List<TrainingModule> trainingModules) {
        return trainingModuleRepo.saveAll(trainingModules);
    }

    @Override
    public String deleteModule(Long id) {
        if(length() == 0)
            return "No students are there in the list.";

        try{
            trainingModuleRepo.deleteById(id);
            return "Deleted Successfully";
        }
        catch(Exception e){
            return "Failed to Delete";
        }
    }

    @Override
    public TrainingModule updateModule(Long id, TrainingModule trainingModule) {
        TrainingModule updateModule = trainingModuleRepo.findById(id).get();
        if(trainingModule.getName()!= null) {
            updateModule.setName(trainingModule.getName());
        }
        if(trainingModule.getDescription()!= null) {
            updateModule.setDescription(trainingModule.getDescription());
        }
        if(trainingModule.getTopics()!= null) {
            updateModule.setTopics(trainingModule.getTopics());
        }

        return trainingModuleRepo.save(updateModule);
    }


    @Override
    public String getStudent(String Name) {
        try{
        return "Student Found";
        }
        catch (Exception e) {
            return "Student Not Found";
        }
    }

    @Override
    public List<TrainingModule> searchModule(String Name) {
        return trainingModuleRepo.searchModule(Name);
    }

}
