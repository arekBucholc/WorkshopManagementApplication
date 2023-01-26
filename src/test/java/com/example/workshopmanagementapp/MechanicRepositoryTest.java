package com.example.workshopmanagementapp;

import com.example.workshopmanagementapp.model.Mechanic;
import com.example.workshopmanagementapp.model.MechanicRepository;
import com.example.workshopmanagementapp.model.TaskRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class MechanicRepositoryTest {

    @Autowired
    private MechanicRepository mechanicRepository;
    private TaskRepository taskRepository;

    @Test
    public void addNewMechanicTest(){
        Mechanic mechanic1 = new Mechanic();
        mechanic1.setFirstName("Adam");
        mechanic1.setLastName("Kowalski");



        Mechanic savedMechanic = mechanicRepository.save(mechanic1);
        Assertions.assertThat(savedMechanic).isNotNull();
        Assertions.assertThat(savedMechanic.getId()).isGreaterThan(0);

    }
}
