package com.music.controller.api;

import com.music.domain.dto.MusicDto;
import com.music.domain.response.MusicSearchResponse;
import com.music.service.MusicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/music")
@RequiredArgsConstructor
public class MusicApiController {

    private final MusicService musicService;

    @GetMapping("/search")
    public List<MusicSearchResponse> search(@RequestParam String keyword) {
        return musicService.search(keyword);
    }
}
