package com.music.service;

import com.music.domain.Music;
import com.music.domain.response.RealtimeChartResponse;
import com.music.repository.MusicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChartService {
    private final RankingService rankingService;
    private final MusicRepository musicRepository;

    public List<RealtimeChartResponse> getRealtimeChart(int limit) {
        // redis에서 순위 추출
        List<Long> topIds = rankingService.getTopMusicIds(limit);

        return topIds.stream()
                .map(musicRepository::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public RealtimeChartResponse toResponse(Music music) {
        return RealtimeChartResponse.builder()
                .musicId(music.getId())
                .title(music.getTitle())
                .artist(music.getArtist())
                .album(music.getAlbum())
                .youtubeUrl(RealtimeChartResponse.extractYoutubeId(music.getYoutubeUrl()))
                .coverImageUrl(music.getCoverImageUrl())
                .build();
    }


}
