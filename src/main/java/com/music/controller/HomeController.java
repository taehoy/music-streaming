package com.music.controller;

import com.music.domain.response.RealtimeChartResponse;
import com.music.service.ChartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final ChartService chartService;

    @GetMapping("/")
    public String home(Model model) {
        List<RealtimeChartResponse> realtimeChart = chartService.getRealtimeChart(10);

        model.addAttribute("chart", realtimeChart);
        return "index";
    }
}
