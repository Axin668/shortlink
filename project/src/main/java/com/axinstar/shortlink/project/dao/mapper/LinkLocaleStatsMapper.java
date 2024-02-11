package com.axinstar.shortlink.project.dao.mapper;

import com.axinstar.shortlink.project.dao.entity.LinkLocaleStatsDO;
import com.axinstar.shortlink.project.dto.req.ShortLinkGroupStatsReqDTO;
import com.axinstar.shortlink.project.dto.req.ShortLinkStatsReqDTO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 地区统计访问持久层
 */
@Mapper
public interface LinkLocaleStatsMapper extends BaseMapper<LinkLocaleStatsDO> {

    /**
     * 记录地区访问监控数据
     */
    @Insert("INSERT INTO\n" +
            "  t_link_locale_stats (\n" +
            "    full_short_url,\n" +
            "    gid,\n" +
            "    date,\n" +
            "    cnt,\n" +
            "    province,\n" +
            "    city,\n" +
            "    adcode,\n" +
            "    country,\n" +
            "    create_time,\n" +
            "    update_time,\n" +
            "    del_flag\n" +
            "  )\n" +
            "VALUES(\n" +
            "    #{linkLocaleStats.fullShortUrl},\n" +
            "    #{linkLocaleStats.gid},\n" +
            "    #{linkLocaleStats.date},\n" +
            "    #{linkLocaleStats.cnt},\n" +
            "    #{linkLocaleStats.province},\n" +
            "    #{linkLocaleStats.city},\n" +
            "    #{linkLocaleStats.adcode},\n" +
            "    #{linkLocaleStats.country},\n" +
            "    NOW(),\n" +
            "    NOW(),\n" +
            "    0\n" +
            "  ) ON DUPLICATE KEY\n" +
            "UPDATE\n" +
            "  cnt = cnt + #{linkLocaleStats.cnt};")
    void shortLinkLocaleStats(@Param("linkLocaleStats") LinkLocaleStatsDO linkLocaleStatsDO);

    /**
     * 根据短链接获取指定日期内地区监控数据
     */
    @Select("SELECT " +
            "    province, " +
            "    SUM(cnt) AS cnt " +
            "FROM " +
            "    t_link_locale_stats " +
            "WHERE " +
            "    full_short_url = #{param.fullShortUrl} " +
            "    AND gid = #{param.gid} " +
            "    AND date BETWEEN #{param.startDate} and #{param.endDate} " +
            "GROUP BY " +
            "    full_short_url, gid, province;")
    List<LinkLocaleStatsDO> listLocaleByShortLink(@Param("param") ShortLinkStatsReqDTO requestParam);

    @Select("SELECT " +
            "   province, " +
            "   SUM(cnt) AS cnt " +
            "FROM " +
            "   t_link_locale_stats " +
            "WHERE " +
            "   gid = #{param.gid} " +
            "   AND date BETWEEN #{param.startDate} and #{param.endDate} " +
            "GROUP BY " +
            "   gid, province;")
    List<LinkLocaleStatsDO> listLocaleByGroup(@Param("param") ShortLinkGroupStatsReqDTO requestParam);
}
