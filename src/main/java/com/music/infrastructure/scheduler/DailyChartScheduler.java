package com.music.infrastructure.scheduler;

import com.music.domain.DailyChart;
import com.music.repository.DailyChartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class DailyChartScheduler {
    private final RedisTemplate<String, String> redisTemplate;
    private final DailyChartRepository dailyChartRepository;

    @Scheduled(cron = "0 0 0 * * *", zone = "Asia/Seoul")
    public void saveDailyChart() {
        ZSetOperations<String, String> zSetOps = redisTemplate.opsForZSet();
        Set<ZSetOperations.TypedTuple<String>> topSongs = zSetOps.reverseRangeWithScores("chart:realtime", 0, 99);

        if(topSongs == null || topSongs.isEmpty()) return;

        int chartRank = 1;
        LocalDate chartDate = LocalDate.now().minusDays(1);
        List<DailyChart> dailyChart = new ArrayList<>();

        for (ZSetOperations.TypedTuple<String> entry : topSongs) {
            Long musicId = Long.valueOf(entry.getValue());
            int playCount = entry.getScore().intValue();
            dailyChart.add(new DailyChart(musicId, chartRank++, playCount, chartDate));
        }

        dailyChartRepository.saveAll(dailyChart);

    }
}
