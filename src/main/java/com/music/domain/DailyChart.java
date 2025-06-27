package com.music.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class DailyChart {
    private Long id;
    private Long musicId;
    private int chartRank;
    private int playCount;
    private LocalDate chartDate;
    private LocalDateTime createdAt;

    public DailyChart(Long musicId, int chartRank, int playCount, LocalDate chartDate) {
        this.musicId = musicId;
        this.chartRank = chartRank;
        this.playCount = playCount;
        this.chartDate = chartDate;
        this.createdAt = LocalDateTime.now();
    }
}
