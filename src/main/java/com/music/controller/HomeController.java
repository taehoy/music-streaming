package com.music.controller;

import com.music.domain.response.RealtimeChartResponse;
import com.music.service.ChartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {

    private final ChartService chartService;

    @GetMapping("/")
    public String home(Model model) {
        List<RealtimeChartResponse> realtimeChart = chartService.getRealtimeChart(10);

        for (RealtimeChartResponse realtimeChartResponse : realtimeChart) {
            log.info("노래이름 : {}, youtubeUrl : {}", realtimeChartResponse.getTitle(), realtimeChartResponse.getYoutubeUrl());
        }


        model.addAttribute("chart", realtimeChart);
        return "index";
    }
}
