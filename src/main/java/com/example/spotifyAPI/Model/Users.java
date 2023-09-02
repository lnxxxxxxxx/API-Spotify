package com.example.spotifyAPI.Model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usuarios")
public class Users {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_usuario")
  private Long id;

  @Column(name = "nombre")
  private String nombre;


  @Column(name = "email")
  private String email;

  @Column(name = "password")
  private String password;

  @Enumerated(EnumType.STRING)
  @Column(columnDefinition = "ENUM('USER', 'ADMIN') DEFAULT 'USER'", nullable = true)
  private EnumROL rol;

  @PrePersist
  public void prePersist() {
    if (rol == null) {
      rol = EnumROL.USER;
    }
  }
}