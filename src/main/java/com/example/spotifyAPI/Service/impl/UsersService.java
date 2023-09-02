package com.example.spotifyAPI.Service.impl;


import com.example.spotifyAPI.DTO.RegisterDTO;
import com.example.spotifyAPI.Mapper.RegisterMapper;
import com.example.spotifyAPI.Model.Users;
import com.example.spotifyAPI.Repository.UsersRepository;
import com.example.spotifyAPI.Service.iUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsersService implements iUsersService {

  @Autowired
  private UsersRepository usersRepository;

  @Autowired
  private RegisterMapper registerMapper;



  @Autowired
  public UsersService(RegisterMapper registerMapper) {
    this.registerMapper = registerMapper;
  }



  public RegisterDTO create(RegisterDTO usersDTO) {
    Optional<Users> existing_user = usersRepository.findByEmail(usersDTO.getEmail());
    if (existing_user.isPresent()) {
      throw new RuntimeException("Ya existe un usuario con el mismo email");
    }

    Users users = registerMapper.toModel(usersDTO);
    users = usersRepository.save(users);
    return registerMapper.toDto(users);
  }



  public List<RegisterDTO> myUser() {
    // Obtener el email del usuario autenticado
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    String userEmail = authentication.getName();

    // Buscar al usuario por email en el repositorio
    Optional<Users> optionalUser = usersRepository.findByEmail(userEmail);
    if (!optionalUser.isPresent()) {
      throw new RuntimeException("No se encontró al usuario autenticado");
    }

    // Convertir el usuario encontrado a DTO y devolverlo en una lista
    Users user = optionalUser.get();
    RegisterDTO userDTO = registerMapper.toDto(user);
    List<RegisterDTO> usersDtoList = new ArrayList<>();
    usersDtoList.add(userDTO);

    return usersDtoList;
  }

}