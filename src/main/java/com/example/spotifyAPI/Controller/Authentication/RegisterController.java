package com.example.spotifyAPI.Controller.Authentication;

import com.example.spotifyAPI.DTO.RegisterDTO;
import com.example.spotifyAPI.Service.iUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegisterController {

  @Autowired
  private iUsersService userService;

  @PostMapping
  public ResponseEntity<RegisterDTO> create(@RequestBody RegisterDTO usersDTO) {
    try {
      RegisterDTO usersCreate = userService.create(usersDTO);
      return ResponseEntity.status(HttpStatus.CREATED).body(usersCreate);
    } catch (RuntimeException ex) {
      return ResponseEntity.badRequest().build();
    }
  }

}