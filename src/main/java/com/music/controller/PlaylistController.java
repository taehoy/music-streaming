package com.music.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class PlaylistController {

    @GetMapping("/playlist/{id}")
    public String playlistDetailPage(@PathVariable Long id, Model model) {
        model.addAttribute("playlistId", id);
        return "playlist/detail";
    }

    @GetMapping("/me/playlists")
    public String myPlaylistsPage(@RequestParam(required = false, defaultValue = "1") Long userId, //Todo : 플레이리스트 userId 추후 변경(로그인 구현 시)
                                  Model model) {
        model.addAttribute("userId", userId);
        return "playlist/manage";
    }
}
