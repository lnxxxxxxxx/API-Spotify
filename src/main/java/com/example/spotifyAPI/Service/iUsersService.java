package com.example.spotifyAPI.Service;

import com.example.spotifyAPI.DTO.RegisterDTO;

import java.util.List;

public interface iUsersService {

  RegisterDTO create(RegisterDTO usersDTO);

  List<RegisterDTO> myUser();



}