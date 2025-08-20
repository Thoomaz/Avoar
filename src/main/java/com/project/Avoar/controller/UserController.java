package com.project.Avoar.controller;

import com.project.Avoar.dto.UserDTO;
import com.project.Avoar.dto.request.UserRequestDTO;
import com.project.Avoar.dto.response.PaymentResponseDTO;
import com.project.Avoar.dto.response.UserResponseDTO;
import com.project.Avoar.entity.User;
import com.project.Avoar.mapper.UserMapper;
import com.project.Avoar.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
@Tag(name = "User")
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping(value = "/create")
    @Operation(
            summary = "Create a new user",
            tags = {"User"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200", content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = UserResponseDTO.class)
                    )),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<UserResponseDTO> create(@RequestBody UserRequestDTO userDTO){
        User user = UserMapper.toEntity(userDTO);
        User userCreated = service.create(user);
        UserResponseDTO userResponseDTO = UserMapper.toResponseDTO(userCreated);

        return ResponseEntity.ok(userResponseDTO);
    }

    @GetMapping(value = "/{userId}")
    @Operation(
            summary = "Get the total pending payment value for a user",
            tags = {"User"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200", content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = UserDTO.class)
                    )),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<UserDTO> pendingValue(@PathVariable Long userId){
        Double pendingValue = service.pendingValueByUser(userId);
        User user = service.findById(userId);
        return ResponseEntity.ok().body(new UserDTO(user.getName(), pendingValue));
    }
}