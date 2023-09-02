package com.example.spotifyAPI.Service.impl;

import com.example.spotifyAPI.Model.ArtistResponse;
import com.example.spotifyAPI.Model.TokenResponse;
import com.example.spotifyAPI.Model.TrackResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class SpotifyService {

  @Value("${spotify.clientId}")
  private String clientId;

  @Value("${spotify.clientSecret}")
  private String clientSecret;

  private static final String TOKEN_ENDPOINT = "https://accounts.spotify.com/api/token";
  private static final String API_ENDPOINT = "https://api.spotify.com/v1";

  public String getAccessToken() {
    RestTemplate restTemplate = new RestTemplate();

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
    headers.setBasicAuth(clientId, clientSecret);

    MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
    body.add("grant_type", "client_credentials");

    ResponseEntity<TokenResponse> response = restTemplate.exchange(
        TOKEN_ENDPOINT,
        HttpMethod.POST,
        new HttpEntity<>(body, headers),
        TokenResponse.class
    );

    if (response.getStatusCode() == HttpStatus.OK) {
      return response.getBody().getAccess_token();
    } else {
      throw new RuntimeException("Failed to get access token from Spotify.");
    }
  }

  public ArtistResponse getArtist(String artistId) {
    String accessToken = getAccessToken();
    RestTemplate restTemplate = new RestTemplate();

    HttpHeaders headers = new HttpHeaders();
    headers.setBearerAuth(accessToken);

    ResponseEntity<ArtistResponse> response = restTemplate.exchange(
        API_ENDPOINT + "/artists/" + artistId,
        HttpMethod.GET,
        new HttpEntity<>(headers),
        ArtistResponse.class
    );

    if (response.getStatusCode() == HttpStatus.OK) {
      return response.getBody();
    } else {
      throw new RuntimeException("Failed to get artist information from Spotify.");
    }
  }



  public TrackResponse getTrack(String trackId) {
    String accessToken = getAccessToken();
    RestTemplate restTemplate = new RestTemplate();

    HttpHeaders headers = new HttpHeaders();
    headers.setBearerAuth(accessToken);

    ResponseEntity<TrackResponse> response = restTemplate.exchange(
        API_ENDPOINT + "/tracks/" + trackId,
        HttpMethod.GET,
        new HttpEntity<>(headers),
        TrackResponse.class
    );

    if (response.getStatusCode() == HttpStatus.OK) {
      return response.getBody();
    } else {
      throw new RuntimeException("Failed to get track information from Spotify.");
    }
  }
}
