package com.example.spotifyAPI.Model; // Asegúrate de que el paquete sea correcto

import com.fasterxml.jackson.annotation.JsonProperty;

public class TokenResponse {

  @JsonProperty("access_token")
  private String access_token;

  @JsonProperty("token_type")
  private String token_type;

  @JsonProperty("expires_in")
  private int expires_in;

  // Agrega los métodos getter y setter para cada campo

  public String getAccess_token() {
    return access_token;
  }

  public void setAccess_token(String access_token) {
    this.access_token = access_token;
  }

  public String getToken_type() {
    return token_type;
  }

  public void setToken_type(String token_type) {
    this.token_type = token_type;
  }

  public int getExpires_in() {
    return expires_in;
  }

  public void setExpires_in(int expires_in) {
    this.expires_in = expires_in;
  }
}
