package com.example.spotifyAPI.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AlbumResponse {

  @JsonProperty("name")
  private String name;

  // Otros campos del álbum

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  // Métodos getter y setter para otros campos del álbum
}