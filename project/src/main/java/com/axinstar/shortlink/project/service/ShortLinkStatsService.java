package com.axinstar.shortlink.project.service;

import com.axinstar.shortlink.project.dto.req.ShortLinkStatsAccessRecordReqDTO;
import com.axinstar.shortlink.project.dto.req.ShortLinkStatsReqDTO;
import com.axinstar.shortlink.project.dto.resp.ShortLinkStatsAccessRecordRespDTO;
import com.axinstar.shortlink.project.dto.resp.ShortLinkStatsRespDTO;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 短链接监控接口层
 */
public interface ShortLinkStatsService {

    /**
     * 获取单个短链接监控数据
     *
     * @param requestParam 获取短链接监控数据入参
     * @return 短链接监控数据
     */
    ShortLinkStatsRespDTO oneShortLinkStats(ShortLinkStatsReqDTO requestParam);

    /**
     * 访问单个短链接指定时间内访问记录监控数据
     *
     * @param requestParam 获取短链接监控访问记录数据入参
     * @return 访问记录监控数据
     */
    IPage<ShortLinkStatsAccessRecordRespDTO> shortLinkStatsAccessRecord(ShortLinkStatsAccessRecordReqDTO requestParam);
}
