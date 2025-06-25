package com.music.controller;

import com.music.service.ListeningService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/play")
public class ListeningController {
    private final ListeningService listeningService;

    @PostMapping("/{musicId}")
    public ResponseEntity<?> play(@RequestParam("userId") Long userId,
                                  @RequestParam("musicId") Long musicId) {
        listeningService.playMusic(userId, musicId);
        return ResponseEntity.ok().build();
    }
}
