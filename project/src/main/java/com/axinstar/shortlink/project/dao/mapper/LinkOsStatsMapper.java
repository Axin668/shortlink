package com.axinstar.shortlink.project.dao.mapper;

import com.axinstar.shortlink.project.dao.entity.LinkOsStatsDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 操作系统计访问持久层
 */
@Mapper
public interface LinkOsStatsMapper extends BaseMapper<LinkOsStatsDO> {

    /**
     * 记录地区访问监控数据
     */
    @Insert("INSERT INTO\n" +
            "  t_link_os_stats (\n" +
            "    full_short_url,\n" +
            "    gid,\n" +
            "    date,\n" +
            "    cnt,\n" +
            "    os,\n" +
            "    create_time,\n" +
            "    update_time,\n" +
            "    del_flag\n" +
            "  )\n" +
            "VALUES(\n" +
            "    #{linkOsStats.fullShortUrl},\n" +
            "    #{linkOsStats.gid},\n" +
            "    #{linkOsStats.date},\n" +
            "    #{linkOsStats.cnt},\n" +
            "    #{linkOsStats.os},\n" +
            "    NOW(),\n" +
            "    NOW(),\n" +
            "    0\n" +
            "  ) ON DUPLICATE KEY\n" +
            "UPDATE\n" +
            "  cnt = cnt + #{linkOsStats.cnt};")
    void shortLinkOsStats(@Param("linkOsStats") LinkOsStatsDO linkOsStatsDO);
}
