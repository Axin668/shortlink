package com.axinstar.shortlink.project.controller;

import com.axinstar.shortlink.project.common.convention.result.Result;
import com.axinstar.shortlink.project.common.convention.result.Results;
import com.axinstar.shortlink.project.dto.req.ShortLinkStatsReqDTO;
import com.axinstar.shortlink.project.dto.resp.ShortLinkStatsRespDTO;
import com.axinstar.shortlink.project.service.ShortLinkStatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 短链接监控控制层
 */
@RestController
@RequiredArgsConstructor
public class ShortLinkStatsController {

    private final ShortLinkStatsService shortLinkStatsService;

    /**
     * 访问单个短链接指定时间内监控数据
     */
    public Result<ShortLinkStatsRespDTO> shortLinkStats(@RequestBody ShortLinkStatsReqDTO requestParam) {
        return Results.success(shortLinkStatsService.oneShortLinkStats(requestParam));
    }
}
