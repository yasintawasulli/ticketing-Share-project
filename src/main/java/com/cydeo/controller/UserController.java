package com.cydeo.controller;

import com.cydeo.dto.ResponseWrapper;
import com.cydeo.dto.UserDTO;
import com.cydeo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/v1/user")
public class UserController {

 private final UserService userService;

 public UserController(UserService userService) {
  this.userService = userService;
 }

 @PostMapping
 public ResponseEntity<ResponseWrapper> createUser(@RequestBody UserDTO userDTO){

  userService.save(userDTO);

  return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseWrapper("User Created",HttpStatus.CREATED));

 }
 @GetMapping
 public ResponseEntity<ResponseWrapper> getAllUser(){
  List<UserDTO> userDTOS = userService.listAllUsers();
  return ResponseEntity.ok(new ResponseWrapper("User retrieved",HttpStatus.OK, userDTOS));
 }

}
