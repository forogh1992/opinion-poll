package com.forogh.opinionPoll.mapper;

import com.forogh.opinionPoll.dto.UserDTO;
import com.forogh.opinionPoll.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")

public interface UserMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "userName", target = "userName")
    @Mapping(source = "phoneNumber", target = "phoneNumber")
    @Mapping(source = "gender", target = "gender")
    @Mapping(source = "totalAnswerSheet", target = "totalAnswerSheet")
    UserDTO toUserDTO(User user);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "userName", target = "userName")
    @Mapping(source = "phoneNumber", target = "phoneNumber")
    @Mapping(source = "gender", target = "gender")
    @Mapping(source = "totalAnswerSheet", target = "totalAnswerSheet")
    User toUserEntity(UserDTO userDTO);

    List<UserDTO> toUserDTO(Page<User> userList);

    List<UserDTO> toUserDTO(List<User> userList);
}

