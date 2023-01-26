//package com.example.workshopmanagementapp;
//
//import com.example.workshopmanagementapp.model.Task;
//import com.example.workshopmanagementapp.model.TaskRepository;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.annotation.Rollback;
//
//import java.util.Optional;
//
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@Rollback(false)
//public class TaskRepositoryTest {
//    @Autowired
//    private TaskRepository repository;
//
//    @Test
//    public void addNewTaskTest(){
//        Task task = new Task();
//        task.setDescription("change oil");
//        task.setCarMake("audi");
//        task.setCarModel("r8");
//        task.setCost(5000.00);
//        task.setOwnerFirstName("jan");
//        task.setOwnerLastName("naj");
//        task.setOwnerContactNr("987554321");
//
//
//        Task savedTask = repository.save(task);
//        Assertions.assertThat(savedTask).isNotNull();
//        Assertions.assertThat(savedTask.getId()).isGreaterThan(0);
//    }
//
//    @Test
//    public void listAllTasksTest(){
//        Iterable<Task> tasks = repository.findAll();
//        Assertions.assertThat(tasks).hasSizeGreaterThan(0);
//
//        for (Task task : tasks){
//            System.out.println(task);
//        }
//    }
//
////    @Test
////    public void updateTaskTest(){
////        Task task = new Task();
////        task.setDescription("change oil");
////        task.setCarMake("audi");
////        task.setCarModel("r8");
////        task.setCost(5000.00);
////        task.setOwnerFirstName("jan");
////        task.setOwnerLastName("naj");
////        task.setOwnerContactNr("987554321");
////
////
////        Task savedTask = repository.save(task);
////        Optional<Task> optionalTask = repository.findById(savedTask.getId());
////
////        Task task1 = optionalTask.get();
////        task1.setDescription("change engine");
////        repository.save(task);
////
////        Task updatedtask = repository.findById(savedTask.getId()).get();
////        Assertions.assertThat(updatedtask.getDescription()).isEqualTo("change engine");
////
////    }
//
//    @Test
//    public void taskDeleteTest(){
//        Task task = new Task();
//        task.setDescription("change oil");
//        task.setCarMake("audi");
//        task.setCarModel("r8");
//        task.setCost(5000.00);
//        task.setOwnerFirstName("jan");
//        task.setOwnerLastName("naj");
//        task.setOwnerContactNr("987554321");
//
//
//        Task savedTask = repository.save(task);
//        repository.deleteById(savedTask.getId());
//
//        Optional<Task> optionalTask = repository.findById(savedTask.getId());
//        Assertions.assertThat(optionalTask).isNotPresent();
//
//    }
//
//
//
//}
