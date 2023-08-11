package com.example.worldlinetraining.worldline_training.Repository;

import com.example.worldlinetraining.worldline_training.Entity.TrainingModule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TrainingModuleRepo extends JpaRepository<TrainingModule,Long> {
    @Query(value = "SELECT t from TrainingModule t where lower(t.name) like lower(concat('%',?1,'%'))" +
            "or lower(?1) like lower(concat('%',elements(t.topics),'%'))")
    public List<TrainingModule> searchModule(String name);
}
