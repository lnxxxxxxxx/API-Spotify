package com.example.spotifyAPI.Model;


import com.fasterxml.jackson.annotation.JsonProperty;

public class TrackResponse {

  @JsonProperty("name")
  private String name;

  @JsonProperty("duration_ms")
  private int durationMs;
 
  // Otros campos de la canción

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
  

  public int getDurationMs() {
    return durationMs;
  }

  public void setDurationMs(int durationMs) {
    this.durationMs = durationMs;
  }
  
}
