package com.example.spotifyAPI.DTO;

import com.example.spotifyAPI.Model.EnumROL;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDTO {

  private Long id;
  private String nombre;
  private String email;
  private String password;
  private EnumROL rol;
}