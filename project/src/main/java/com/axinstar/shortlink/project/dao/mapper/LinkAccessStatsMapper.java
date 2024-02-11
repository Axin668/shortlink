package com.axinstar.shortlink.project.dao.mapper;

import com.axinstar.shortlink.project.dao.entity.LinkAccessStatsDO;
import com.axinstar.shortlink.project.dto.req.ShortLinkGroupStatsReqDTO;
import com.axinstar.shortlink.project.dto.req.ShortLinkStatsReqDTO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 短链接基础访问监控持久层
 */
@Mapper
public interface LinkAccessStatsMapper extends BaseMapper<LinkAccessStatsDO> {

    /**
     * 记录基础访问监控数据
     */
    @Insert("INSERT INTO\n" +
            "  t_link_access_stats (\n" +
            "    full_short_url,\n" +
            "    gid,\n" +
            "    date,\n" +
            "    pv,\n" +
            "    uv,\n" +
            "    uip,\n" +
            "    hour,\n" +
            "    weekday,\n" +
            "    create_time,\n" +
            "    update_time,\n" +
            "    del_flag\n" +
            "  )\n" +
            "VALUES(\n" +
            "    #{linkAccessStats.fullShortUrl},\n" +
            "    #{linkAccessStats.gid},\n" +
            "    #{linkAccessStats.date},\n" +
            "    #{linkAccessStats.pv},\n" +
            "    #{linkAccessStats.uv},\n" +
            "    #{linkAccessStats.uip},\n" +
            "    #{linkAccessStats.hour},\n" +
            "    #{linkAccessStats.weekday},\n" +
            "    NOW(),\n" +
            "    NOW(),\n" +
            "    0\n" +
            "  ) ON DUPLICATE KEY\n" +
            "UPDATE\n" +
            "  pv = pv + #{linkAccessStats.pv},\n" +
            "  uv = uv + #{linkAccessStats.uv},\n" +
            "  uip = uip + #{linkAccessStats.uip};")
    void shortLinkStats(@Param("linkAccessStats")LinkAccessStatsDO linkAccessStatsDO);

    /**
     * 根据短链接获取指定日期内基础监控数据
     */
    @Select("SELECT " +
            "    date, " +
            "    SUM(pv) AS pv, " +
            "    SUM(uv) AS uv, " +
            "    SUM(uip) AS uip " +
            "FROM " +
            "    t_link_access_stats " +
            "WHERE " +
            "    full_short_url = #{param.fullShortUrl} " +
            "    AND gid = #{param.gid} " +
            "    AND date BETWEEN #{param.startDate} and #{param.endDate} " +
            "GROUP BY " +
            "    full_short_url, gid, date;")
    List<LinkAccessStatsDO> listStatsByShortLink(@Param("param") ShortLinkStatsReqDTO requestParam);

    /**
     * 根据短链接获取指定日期内小时基础监控数据
     */
    @Select("SELECT " +
            "    hour, " +
            "    SUM(pv) AS pv " +
            "FROM " +
            "    t_link_access_stats " +
            "WHERE " +
            "    full_short_url = #{param.fullShortUrl} " +
            "    AND gid = #{param.gid} " +
            "    AND date BETWEEN #{param.startDate} and #{param.endDate} " +
            "GROUP BY " +
            "    full_short_url, gid, hour;")
    List<LinkAccessStatsDO> listHourStatsByShortLink(@Param("param") ShortLinkStatsReqDTO requestParam);

    /**
     * 根据短链接获取指定日期内星期基础监控数据
     */
    @Select("SELECT " +
            "    weekday, " +
            "    SUM(pv) AS pv " +
            "FROM " +
            "    t_link_access_stats " +
            "WHERE " +
            "    full_short_url = #{param.fullShortUrl} " +
            "    AND gid = #{param.gid} " +
            "    AND date BETWEEN #{param.startDate} and #{param.endDate} " +
            "GROUP BY " +
            "    full_short_url, gid, weekday;")
    List<LinkAccessStatsDO> listWeekdayStatsByShortLink(@Param("param") ShortLinkStatsReqDTO requestParam);

    /**
     * 根据分组获取指定日期内基础监控数据
     */
    @Select("SELECT " +
            "   date, " +
            "   SUM(pv) AS pv, " +
            "   SUM(uv) AS uv, " +
            "   SUM(uip) AS uip " +
            "FROM " +
            "   t_link_access_stats " +
            "WHERE " +
            "   gid = #{param.gid} " +
            "   AND date BETWEEN #{param.startDate} and #{param.endDate} " +
            "GROUP BY " +
            "   gid, date;")
    List<LinkAccessStatsDO> listStatsByGroup(@Param("param") ShortLinkGroupStatsReqDTO requestParam);

    /**
     * 根据分组获取指定日期内小时基础监控数据
     */
    @Select("SELECT " +
            "   hour, " +
            "   SUM(pv) AS pv " +
            "FROM " +
            "   t_link_access_stats " +
            "WHERE " +
            "   gid = #{param.gid} " +
            "   AND date BETWEEN #{param.startDate} and #{param.endDate} " +
            "GROUP BY " +
            "   gid, hour;")
    List<LinkAccessStatsDO> listHourStatsByGroup(@Param("param") ShortLinkGroupStatsReqDTO requestParam);

    /**
     * 根据分组获取指定日期内星期基础监控数据
     */
    @Select("SELECT " +
            "   weekday, " +
            "   SUM(pv) AS pv " +
            "FROM " +
            "   t_link_access_stats " +
            "WHERE " +
            "   gid = #{param.gid} " +
            "   AND date BETWEEN #{param.startDate} and #{param.endDate} " +
            "GROUP BY " +
            "   gid, weekday;")
    List<LinkAccessStatsDO> listWeekdayStatsByGroup(@Param("param") ShortLinkGroupStatsReqDTO requestParam);
}
