package com.example.sagaribackend.mappers;

import com.example.sagaribackend.dtos.CommentRequestDTO;
import com.example.sagaribackend.dtos.CommentResponseDTO;
import com.example.sagaribackend.models.Comment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface CommentMapper {
    CommentResponseDTO toDto(Comment comment);
    Comment toEntity(CommentRequestDTO dto);
}
