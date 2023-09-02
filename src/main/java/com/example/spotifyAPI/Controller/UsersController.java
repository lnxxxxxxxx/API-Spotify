package com.example.spotifyAPI.Controller;

import com.example.spotifyAPI.DTO.RegisterDTO;
import com.example.spotifyAPI.Service.iUsersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UsersController {

  @Autowired
  private static final Logger logger = LoggerFactory.getLogger(UsersController.class);

  @Autowired
  private iUsersService userService;

  @GetMapping
  public ResponseEntity<List<RegisterDTO>> myUser() {
    logger.info("Obteniendo el mensaje");

    var auth =  SecurityContextHolder.getContext().getAuthentication();
    logger.info("Datos del Usuario: {}", auth.getPrincipal());
    logger.info("Datos de los Roles {}", auth.getAuthorities());
    logger.info("Esta autenticado {}", auth.isAuthenticated());

    List<RegisterDTO> usersDtoList = userService.myUser();
    return new ResponseEntity<>(usersDtoList, HttpStatus.OK);
  }




}