package com.project.Avoar.controller;

import com.project.Avoar.dto.request.UserRequestDTO;
import com.project.Avoar.dto.response.UserResponseDTO;
import com.project.Avoar.entity.User;
import com.project.Avoar.mapper.UserMapper;
import com.project.Avoar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping(value = "/create")
    public ResponseEntity<UserResponseDTO> create(UserRequestDTO userDTO){
        User user = UserMapper.toEntity(userDTO);
        User userCreated = service.create(user);
        UserResponseDTO userResponseDTO = UserMapper.toDTO(userCreated);

        return ResponseEntity.ok(userResponseDTO);
    }
}
