package com.zihenx.estudoDto.dto.input_dto;

import com.zihenx.estudoDto.entities.User;

import javax.validation.constraints.NotEmpty;

public class UserInputDTO {

    @NotEmpty
    private String name;
    @NotEmpty
    private String password;

    public UserInputDTO() {
    }

    public UserInputDTO(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public UserInputDTO(User user) {
        name = user.getName();
        password = user.getPassword();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
