package com.music.controller;

import com.music.domain.response.RealtimeChartResponse;
import com.music.service.ChartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/chart")
@RequiredArgsConstructor
public class ChartController {
    private final ChartService chartService;

    @GetMapping("/realtime")
    public List<RealtimeChartResponse> getRealtimeChart(@RequestParam(defaultValue = "10") int size) {
        return chartService.getRealtimeChart(size);
    }
}
