package com.example.spotifyAPI.Controller;

import com.example.spotifyAPI.Model.ArtistResponse;
import com.example.spotifyAPI.Service.impl.SpotifyService;
import com.example.spotifyAPI.Model.TrackResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SpotifyController {

  @Autowired
  private SpotifyService spotifyService;

  @GetMapping("/artist/{artistId}")
  public ArtistResponse getArtist(@PathVariable String artistId) {
    return spotifyService.getArtist(artistId);
  }

  @GetMapping("/track/{trackId}")
  public TrackResponse getTrack(@PathVariable String trackId) {
    return spotifyService.getTrack(trackId);
  }
}
