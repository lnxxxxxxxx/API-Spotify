package com.example.spotifyAPI.Service.impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.example.spotifyAPI.Model.Users;
import com.example.spotifyAPI.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceUserDetails implements UserDetailsService {


  @Autowired
  private UsersRepository usersRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


    Users users = usersRepository.findByEmail(username)
        .orElseThrow(() -> new UsernameNotFoundException("The email " + username + " is incorrect."));

    Set<GrantedAuthority> authorities = new HashSet<>();
    authorities.add(new SimpleGrantedAuthority("ROLE_" + users.getRol().name()));


    return new User(users.getEmail(),
        users.getPassword(),
        true,
        true,
        true,
        true,
        authorities);


    /**
     * Users users = usersRepository.findByEmail(username)
     *         .orElseThrow(() -> new UsernameNotFoundException("El email " + username + " es incorrecto."));
     *     *     String rol = users.getRol();
     *
     *     Collection<?  extends GrantedAuthority> authorities;
     *
     *     if (rol.equals("USER")) {
     *         authorities = Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
     *     } else if (rol.equals("ADMIN")) {
     *         authorities = Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
     *     } else {
     *         throw new UsernameNotFoundException("El rol " + rol + " no existe.");
     *     }
     *
     *     return new User(users.getEmail(),
     *         users.getPassword(),
     *         true,
     *         true,
     *         true,
     *         true,
     *        authorities);
     *
     *        AQUI SE VERIFICA CON EQUALS QUE DEVUELVE DE LA BASE DE DATOS
     *        Y SE LE OTORGA EL ROLE MANEJANDO EXCEPCIONES
     */
  }
}