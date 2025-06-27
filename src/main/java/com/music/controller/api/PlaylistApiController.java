package com.music.controller.api;

import com.music.domain.response.PlaylistDetailResponse;
import com.music.domain.response.PlaylistResponse;
import com.music.service.PlaylistService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/playlists")
@RequiredArgsConstructor
public class PlaylistApiController {
    private final PlaylistService playlistService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestParam Long userId,
                                       @RequestParam String name) {
        playlistService.createPlaylist(userId, name);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<PlaylistResponse>> findByUser(@RequestParam Long userId) {
        List<PlaylistResponse> result = playlistService.getPlaylistsByUser(userId);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/{playlistId}/music")
    public ResponseEntity<Void> addMusic(@PathVariable Long playlistId,
                                         @RequestBody Map<String, Long> request) {
        Long musicId = request.get("musicId");
        playlistService.addMusic(playlistId, musicId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{playlistId}")
    public ResponseEntity<PlaylistDetailResponse> getDetail(@PathVariable Long playlistId) {
        PlaylistDetailResponse detail = playlistService.getPlaylistDetail(playlistId);
        return ResponseEntity.ok(detail);
    }

}
