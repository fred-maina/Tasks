package com.fred.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class TaskController {

    @Autowired
    TaskRepository taskRepository;
    @GetMapping("tasks")
    public List<Task> getTasks(){
        return taskRepository.findAll();
    }

    @GetMapping("tasks/{id}")
    public ResponseEntity<Task> getTasks(@PathVariable long id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            return ResponseEntity.ok(task);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("tasks/create")
    public ResponseEntity<Task> createTasks(@RequestBody Task newTask){
        taskRepository.save(newTask);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTask);
    }
    @DeleteMapping("tasks/delete/{id}")
    public ResponseEntity<Task> deleteTask(@PathVariable long id){
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            taskRepository.delete(task);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PatchMapping("tasks/update/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable long id ,@RequestBody Task updateTask){
        Optional<Task> optionaltask= taskRepository.findById(id);
        if (optionaltask.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Task task = optionaltask.get();
        if (updateTask.getDescription() != null){
            task.setDescription(updateTask.getDescription());
        }
        if (updateTask.getCompleted()!=null){
            task.setCompleted(updateTask.getCompleted());
        }
        if(updateTask.getName()!=null){
            task.setName(updateTask.getName());
        }
        return ResponseEntity.ok(task);

    }

}
