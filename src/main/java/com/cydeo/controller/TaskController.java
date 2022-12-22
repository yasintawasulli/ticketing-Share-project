package com.cydeo.controller;
import com.cydeo.dto.ResponseWrapper;
import com.cydeo.dto.TaskDTO;
import com.cydeo.exception.TaskNotFoundException;
import com.cydeo.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/task")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }


    @PostMapping
    public ResponseEntity<ResponseWrapper> taskCreate(@RequestBody TaskDTO taskDTO ){
      taskService.save(taskDTO);
        return ResponseEntity.ok(new ResponseWrapper("Task has been created", HttpStatus.OK));

    }

    @GetMapping
    public ResponseEntity<ResponseWrapper>getAllTasks(){
        List<TaskDTO> tasks= taskService.listAllTasks();
         return ResponseEntity.ok(new ResponseWrapper("Tasks are retrieved",tasks, HttpStatus.OK));
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<ResponseWrapper>deleteTask(@PathVariable("taskId")Long id){
        taskService.delete(id);
        return ResponseEntity.ok(new ResponseWrapper("Task has been deleted", HttpStatus.OK));

    }

    @PutMapping
    public ResponseEntity<ResponseWrapper>updateTask(@RequestBody TaskDTO taskDTO) {
        taskService.update(taskDTO);
        return ResponseEntity.ok(new ResponseWrapper("Task has been updated", HttpStatus.OK));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ResponseWrapper> getTaskById(@PathVariable("id")Long id){
        TaskDTO taskDTO= taskService.findTaskById(id);
        return ResponseEntity.ok(new ResponseWrapper("Task has been retrieved", taskDTO,  HttpStatus.OK));
    }








        @GetMapping("/{id}")
        public ResponseEntity<ResponseWrapper> findById(@PathVariable ("id") Long id) throws TaskNotFoundException {
            TaskDTO taskDTO = taskService.findById(id);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper("successfully retrieved", taskDTO,HttpStatus.OK));
        }

}
