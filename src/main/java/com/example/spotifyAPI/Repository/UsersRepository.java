package com.example.spotifyAPI.Repository;

import com.example.spotifyAPI.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Long> {

  Optional<Users> findByEmail(String email);
}