package com.zihenx.estudoDto.services;

import com.zihenx.estudoDto.dto.UserDTO;
import com.zihenx.estudoDto.dto.converter.UserDtoConverter;
import com.zihenx.estudoDto.dto.converter.UserDtoInputConverter;
import com.zihenx.estudoDto.dto.input_dto.UserInputDTO;
import com.zihenx.estudoDto.exception.RegistrationValidationException;
import com.zihenx.estudoDto.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserDtoConverter userDtoConverter;
    @Autowired
    private UserDtoInputConverter userDtoInputConverter;

    @Transactional(readOnly = true)
    public UserDTO findUser(Long userId) {
        return findUserExist(userId);
    }

    @Transactional(readOnly = true)
    public List<UserDTO> findAllUsers() {

        var users = userRepository.findAll();

        return userDtoConverter.toUserDTOList(users);
    }

    @Transactional
    public UserDTO newUser(UserInputDTO user) {
        var userModel = userDtoInputConverter.toUser(user);

        var newUser = userRepository.save(userModel);

        return userDtoConverter.toUserDTO(newUser);
    }

    private UserDTO findUserExist(Long userId) {
        var user = userRepository.findById(userId).orElseThrow(() -> new RegistrationValidationException("Cliente não encontrado"));
        return userDtoConverter.toUserDTO(user);
    }
}
