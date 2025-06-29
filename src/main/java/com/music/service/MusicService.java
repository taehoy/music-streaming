package com.music.service;

import com.music.domain.dto.MusicDto;
import com.music.domain.response.MusicSearchResponse;
import com.music.repository.MusicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MusicService {
    private final MusicRepository musicRepository;

    public List<MusicSearchResponse> search(String keyword) {
        return musicRepository.findByKeyword(keyword)
                .stream()
                .map(music -> MusicSearchResponse.builder()
                        .musicId(music.getId())
                        .title(music.getTitle())
                        .artist(music.getArtist())
                        .album(music.getAlbum())
                        .coverImageUrl(music.getCoverImageUrl())
                        .youtubeUrl(extractYoutubeId(music.getYoutubeUrl()))
                        .build()
                )
                .collect(Collectors.toList());
    }

    private String extractYoutubeId(String url) {
        if (url == null || !url.contains("/embed/")) return null;
        return url.substring(url.indexOf("/embed/") + "/embed/".length());
    }
}
