package com.project.Avoar.mapper;

import com.project.Avoar.dto.UserDTO;
import com.project.Avoar.dto.request.UserRequestDTO;
import com.project.Avoar.dto.response.UserResponseDTO;
import com.project.Avoar.entity.User;

public class UserMapper {
    public static UserResponseDTO toResponseDTO(User user) {
        if (user == null) return null;

        return new UserResponseDTO(user.getName(), user.getEmail());
    }

    public static User toEntity(UserRequestDTO dto) {
        if (dto == null) return null;

        User user = new User();
        user.setName(dto.username());
        user.setEmail(dto.email());
        user.setPassword(dto.password());
        return user;
    }

    public static UserDTO toDTO(User user, Double pendingValue){
        if (user == null) return null;

        return new UserDTO(user.getName(), pendingValue);
    }
}
