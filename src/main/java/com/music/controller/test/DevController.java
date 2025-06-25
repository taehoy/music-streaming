package com.music.controller.test;

import com.music.service.ListeningService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dev")
@RequiredArgsConstructor
public class DevController {
    private final ListeningService listeningService;

    @GetMapping("/play-test")
    public ResponseEntity<?> playTest(
            @RequestParam("musicId") Long musicId,
            @RequestParam("userId") Long userId
    ) {
        listeningService.playMusic(userId,musicId);
        return ResponseEntity.ok("✅ 재생 완료: musicId=" + musicId + ", userId=" + userId);
    }
}
