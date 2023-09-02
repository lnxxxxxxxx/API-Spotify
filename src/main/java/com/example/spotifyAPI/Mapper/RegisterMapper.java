package com.example.spotifyAPI.Mapper;

import com.example.spotifyAPI.DTO.RegisterDTO;
import com.example.spotifyAPI.Model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class RegisterMapper {

  private PasswordEncoder passwordEncoder;

  public RegisterMapper(PasswordEncoder passwordEncoder) {
    this.passwordEncoder = passwordEncoder;
  }

  public RegisterDTO toDto(Users users) {
    RegisterDTO usersDTO = new RegisterDTO();
    usersDTO.setId(users.getId());
    usersDTO.setNombre(users.getNombre());
    usersDTO.setEmail(users.getEmail());
    usersDTO.setPassword(passwordEncoder.encode(users.getPassword()));
    usersDTO.setRol(users.getRol());
    return usersDTO;
  }

  public Users toModel(RegisterDTO usersDTO) {
    Users users = new Users();
    users.setId(usersDTO.getId());
    users.setNombre(usersDTO.getNombre());
    users.setEmail(usersDTO.getEmail());
    users.setPassword(passwordEncoder.encode(usersDTO.getPassword()));
    users.setRol(usersDTO.getRol());
    return users;
  }


}