package com.music.controller;

import com.music.domain.response.DailyChartResponse;
import com.music.service.DailyChartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/chart")
@RequiredArgsConstructor
public class ChartController {

    @GetMapping("/daily")
    public String dailyChart(
            @RequestParam(value = "date", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        log.info("/chart/daily 페이지 열림, 선택적 date 파라미터 = {}" , date);
        return "chart/daily";
    }
}
