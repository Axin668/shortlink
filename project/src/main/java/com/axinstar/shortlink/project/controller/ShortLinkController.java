package com.axinstar.shortlink.project.controller;

import com.axinstar.shortlink.project.common.convention.result.Result;
import com.axinstar.shortlink.project.common.convention.result.Results;
import com.axinstar.shortlink.project.dto.req.ShortLinkCreateReqDTO;
import com.axinstar.shortlink.project.dto.req.ShortLinkPageReqDTO;
import com.axinstar.shortlink.project.dto.resp.ShortLinkCreateRespDTO;
import com.axinstar.shortlink.project.dto.resp.ShortLinkGroupCountQueryRespDTO;
import com.axinstar.shortlink.project.dto.resp.ShortLinkPageRespDTO;
import com.axinstar.shortlink.project.service.ShortLinkService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ShortLinkController {

    private final ShortLinkService shortLinkService;

    /**
     * 创建短链接
     */
    @PostMapping("/api/short-link/v1/create")
    public Result<ShortLinkCreateRespDTO> createShortLink(@RequestBody ShortLinkCreateReqDTO requestParam) {
        return Results.success(shortLinkService.createShortLink(requestParam));
    }

    /**
     * 分页查询短链接
     */
    @GetMapping("/api/short-link/v1/page")
    public Result<IPage<ShortLinkPageRespDTO>> pageShortLink(ShortLinkPageReqDTO requestParam) {
        return Results.success(shortLinkService.pageShortLink(requestParam));
    }

    /**
     * 查询分组内短链接数量
     */
    @GetMapping("/api/short-link/v1/count")
    public Result<List<ShortLinkGroupCountQueryRespDTO>> listGroupShortLink(@RequestParam("requestParam") List<String> requestParam) {
        return Results.success(shortLinkService.listGroupShortLinkCount(requestParam));
    }
}
