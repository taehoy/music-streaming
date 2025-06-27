package com.music.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class PlaylistController {

    @GetMapping("/playlist/{id}")
    public String playlistDetailPage(@PathVariable Long id, Model model) {
        model.addAttribute("playlistId", id);
        return "playlist/detail";
    }
}
