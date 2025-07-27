package com.example.sagaribackend.mappers;

import com.example.sagaribackend.dtos.UserResponseDTO;
import com.example.sagaribackend.models.AppUser;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserResponseDTO toDto(AppUser user);
}
