package com.example.spotifyAPI.Model;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ArtistResponse {

  @JsonProperty("genres")
  private List<String> genres;

  @JsonProperty("name")
  private String name;

  @JsonProperty("popularity")
  private int popularity;

  // Constructor vacío (necesario para la deserialización)
  public ArtistResponse() {
  }

  public List<String> getGenres() {
    return genres;
  }

  public void setGenres(List<String> genres) {
    this.genres = genres;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPopularity() {
    return popularity;
  }

  public void setPopularity(int popularity) {
    this.popularity = popularity;
  }
}
