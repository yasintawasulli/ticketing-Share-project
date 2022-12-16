package com.cydeo.service.impl;

import com.cydeo.dto.UserDTO;
import com.cydeo.entity.User;
import com.cydeo.mapper.UserMapper;
import com.cydeo.repository.UserRepository;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public List<UserDTO> listAllUsers() {
        List<User> userList= userRepository.findAll();
        return userList.stream().map(userMapper::convertToDto).collect(Collectors.toList());
    }

    @Override
    public void save(UserDTO userDTO) {

    }

    @Override
    public void delete(String username) {

    }

    @Override
    public UserDTO update(UserDTO userDTO) {
        return null;
    }
}
