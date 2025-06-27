package com.music.controller.api;

import com.music.domain.response.DailyChartResponse;
import com.music.domain.response.RealtimeChartResponse;
import com.music.service.ChartService;
import com.music.service.DailyChartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/chart")
@RequiredArgsConstructor
public class ChartApiController {
    private final ChartService chartService;
    private final DailyChartService dailyChartService;

    @GetMapping("/realtime")
    public List<RealtimeChartResponse> getRealtimeChart(@RequestParam(defaultValue = "10") int size) {
        return chartService.getRealtimeChart(size);
    }

    @GetMapping("/daily")
    public ResponseEntity<List<DailyChartResponse>> getDailyChart(
            @RequestParam(value = "date", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        if (date == null) {
            date = LocalDate.now().minusDays(1);
        }

        log.info("❗api/chart/daily 호출, date = {}", date);

        return ResponseEntity.ok(dailyChartService.getDailyChartByDate(date));
    }

}
