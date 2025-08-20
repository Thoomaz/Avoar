package com.project.Avoar.controller;

import com.project.Avoar.dto.UserDTO;
import com.project.Avoar.dto.request.UserRequestDTO;
import com.project.Avoar.dto.response.PaymentResponseDTO;
import com.project.Avoar.dto.response.UserResponseDTO;
import com.project.Avoar.entity.User;
import com.project.Avoar.mapper.UserMapper;
import com.project.Avoar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping(value = "/create")
    public ResponseEntity<UserResponseDTO> create(@RequestBody UserRequestDTO userDTO){
        User user = UserMapper.toEntity(userDTO);
        User userCreated = service.create(user);
        UserResponseDTO userResponseDTO = UserMapper.toResponseDTO(userCreated);

        return ResponseEntity.ok(userResponseDTO);
    }

    @GetMapping(value = "/{userId}")
    public ResponseEntity<UserDTO> pendingValue(@PathVariable Long userId){
        Double pendingValue = service.pendingValueByUser(userId);
        User user = service.findById(userId);
        return ResponseEntity.ok().body(new UserDTO(user.getName(), pendingValue));
    }
}
