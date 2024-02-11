package com.axinstar.shortlink.project.dao.mapper;

import com.axinstar.shortlink.project.dao.entity.LinkStatsTodayDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 短链接今日统计持久层
 */
@Mapper
public interface LinkStatsTodayMapper extends BaseMapper<LinkStatsTodayDO> {

    /**
     * 记录今日访问统计监控数据
     */
    @Insert("INSERT INTO\n" +
            "  t_link_stats_today (\n" +
            "    full_short_url,\n" +
            "    gid,\n" +
            "    date,\n" +
            "    today_pv,\n" +
            "    today_uv,\n" +
            "    today_uip,\n" +
            "    create_time,\n" +
            "    update_time,\n" +
            "    del_flag\n" +
            "  )\n" +
            "VALUES(\n" +
            "    #{linkTodayStats.fullShortUrl},\n" +
            "    #{linkTodayStats.gid},\n" +
            "    #{linkTodayStats.date},\n" +
            "    #{linkTodayStats.todayPv},\n" +
            "    #{linkTodayStats.todayUv},\n" +
            "    #{linkTodayStats.todayUip},\n" +
            "    NOW(),\n" +
            "    NOW(),\n" +
            "    0\n" +
            "  ) ON DUPLICATE KEY\n" +
            "UPDATE\n" +
            "  today_pv = today_pv + #{linkTodayStats.todayPv}, " +
            "  today_uv = today_uv + #{linkTodayStats.todayUv}, " +
            "  today_uip = today_uip + #{linkTodayStats.todayUip}; ")
    void shortLinkTodayStats(@Param("linkTodayStats") LinkStatsTodayDO linkStatsTodayDO);
}
