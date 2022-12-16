package com.cydeo.service;

import com.cydeo.dto.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO>listAllUsers();

    void save(UserDTO userDTO);

    void delete(String username);

    UserDTO update(UserDTO userDTO);




}
