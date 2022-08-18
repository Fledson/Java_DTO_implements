package com.zihenx.estudoDto.dto.converter;

import com.zihenx.estudoDto.dto.UserDTO;
import com.zihenx.estudoDto.entities.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserDtoConverter {

    public UserDTO toUserDTO(User user) {
        return new UserDTO(user);
    }

    public List<UserDTO> toUserDTOList(List<User> users) {
        return users.stream()
                .map(this::toUserDTO)
                .collect(Collectors.toList());
    }

}
