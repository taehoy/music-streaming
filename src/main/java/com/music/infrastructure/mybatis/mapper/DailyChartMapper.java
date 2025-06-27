package com.music.infrastructure.mybatis.mapper;

import com.music.domain.DailyChart;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DailyChartMapper {
    void insertBatch(@Param("charts") List<DailyChart> charts);

}
