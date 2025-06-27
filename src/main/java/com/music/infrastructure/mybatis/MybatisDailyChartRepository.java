package com.music.infrastructure.mybatis;

import com.music.domain.DailyChart;
import com.music.infrastructure.mybatis.mapper.DailyChartMapper;
import com.music.repository.DailyChartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MybatisDailyChartRepository implements DailyChartRepository {
    private final DailyChartMapper dailyChartMapper;


    /**
     * 일간 차트 저장
     * @param charts
     */
    @Override
    public void saveAll(List<DailyChart> charts) {
        if(charts == null || charts.isEmpty()) return;

        dailyChartMapper.insertBatch(charts);
    }
}
