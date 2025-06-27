package com.music.service;


import com.music.domain.DailyChart;
import com.music.domain.Music;
import com.music.domain.response.DailyChartResponse;
import com.music.repository.DailyChartRepository;
import com.music.repository.MusicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DailyChartService {
    private final DailyChartRepository dailyChartRepository;
    private final MusicRepository musicRepository;

    public List<DailyChartResponse> getDailyChartByDate(LocalDate date) {
        List<DailyChart> chartList = dailyChartRepository.findByChartDate(date);

        return chartList.stream()
                .map(chart -> {
                    Optional<Music> music = musicRepository.findById(chart.getMusicId());
                    return DailyChartResponse.builder()
                            .chartRank(chart.getChartRank())
                            .musicId(music.get().getId())
                            .title(music.get().getTitle())
                            .artist(music.get().getArtist())
                            .playCount(chart.getPlayCount())
                            .youtubeUrl(music.get().getYoutubeUrl())
                            .build();
                })
                .collect(Collectors.toList());
    }
}
