package com.zihenx.estudoDto.dto.converter;

import com.zihenx.estudoDto.dto.UserDTO;
import com.zihenx.estudoDto.dto.input_dto.UserInputDTO;
import com.zihenx.estudoDto.entities.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserDtoInputConverter {

    public UserInputDTO toUserDTO(User user) {
        return new UserInputDTO(user);
    }

    public List<UserInputDTO> toUserDTOList(List<User> users) {
        return users.stream()
                .map(this::toUserDTO)
                .collect(Collectors.toList());
    }

    public User toUser(UserInputDTO userInputDTO) {
        return new User(userInputDTO);
    }

}
