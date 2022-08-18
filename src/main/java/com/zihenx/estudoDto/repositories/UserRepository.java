package com.zihenx.estudoDto.repositories;

import com.zihenx.estudoDto.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
