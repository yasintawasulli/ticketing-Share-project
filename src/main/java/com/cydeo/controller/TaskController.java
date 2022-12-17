package com.cydeo.controller;

import com.cydeo.dto.ResponseWrapper;
import com.cydeo.dto.TaskDTO;
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
            return ResponseEntity.ok(new ResponseWrapper("Tasks are retrieved", tasks, HttpStatus.OK));
        }

}
