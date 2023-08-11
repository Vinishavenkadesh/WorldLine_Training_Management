package com.example.worldlinetraining.worldline_training.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "training_module")
public class TrainingModule {
    @Id
    @SequenceGenerator(
            name = "module_sequence",
            sequenceName = "module_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "module_sequence"
    )
    private Long id;
    private String name;
    private  String description;

    @ElementCollection
    private List<String> topics = new ArrayList<>();
    @OneToMany(mappedBy = "trainingModule")
    private List<Employee> employees = new ArrayList<>();
    public TrainingModule() {
    }



    public TrainingModule(Long id, String name, String description, List<String> topics, List<Employee> employee) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.topics = topics;
    }

    public List<String> getTopics() {
        return topics;
    }

    public void setTopics(List<String> topics) {
        this.topics = topics;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
