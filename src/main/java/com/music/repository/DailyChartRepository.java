package com.music.repository;

import com.music.domain.DailyChart;

import java.util.List;

public interface DailyChartRepository {
    void saveAll(List<DailyChart> charts);
}
