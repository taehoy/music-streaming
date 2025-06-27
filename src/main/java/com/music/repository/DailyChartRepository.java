package com.music.repository;

import com.music.domain.DailyChart;

import java.time.LocalDate;
import java.util.List;

public interface DailyChartRepository {
    void saveAll(List<DailyChart> charts);

    List<DailyChart> findByChartDate(LocalDate date);
}
