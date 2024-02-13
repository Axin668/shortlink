package com.axinstar.shortlink.project.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.axinstar.shortlink.project.common.convention.result.Result;
import com.axinstar.shortlink.project.common.convention.result.Results;
import com.axinstar.shortlink.project.dto.req.ShortLinkBatchCreateReqDTO;
import com.axinstar.shortlink.project.dto.req.ShortLinkCreateReqDTO;
import com.axinstar.shortlink.project.dto.req.ShortLinkPageReqDTO;
import com.axinstar.shortlink.project.dto.req.ShortLinkUpdateReqDTO;
import com.axinstar.shortlink.project.dto.resp.ShortLinkBatchCreateRespDTO;
import com.axinstar.shortlink.project.dto.resp.ShortLinkCreateRespDTO;
import com.axinstar.shortlink.project.dto.resp.ShortLinkGroupCountQueryRespDTO;
import com.axinstar.shortlink.project.dto.resp.ShortLinkPageRespDTO;
import com.axinstar.shortlink.project.handler.CustomBlockHandler;
import com.axinstar.shortlink.project.service.ShortLinkService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ShortLinkController {

    private final ShortLinkService shortLinkService;

    /**
     * 短链接跳转原始链接
     */
    @GetMapping("/{short-uri}")
    public void restoreUrl(@PathVariable("short-uri") String shortUri, HttpServletRequest request, HttpServletResponse response) {
        shortLinkService.restoreUrl(shortUri, request, response);
    }

    /**
     * 创建短链接
     */
    @PostMapping("/api/short-link/v1/create")
    @SentinelResource(
            value = "create_short-link",
            blockHandler = "createShortLinkBlockHandlerMethod",
            blockHandlerClass = CustomBlockHandler.class
    )
    public Result<ShortLinkCreateRespDTO> createShortLink(@RequestBody ShortLinkCreateReqDTO requestParam) {
        return Results.success(shortLinkService.createShortLink(requestParam));
    }

    /**
     * 修改短链接
     */
    @PostMapping("/api/short-link/v1/update")
    public Result<Void> updateShortLink(@RequestBody ShortLinkUpdateReqDTO requestParam) {
        shortLinkService.updateShortLink(requestParam);
        return Results.success();
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

    /**
     * 批量创建短链接
     */
    @PostMapping("/api/short-link/v1/create/batch")
    public Result<ShortLinkBatchCreateRespDTO> batchCreateShortLink(@RequestBody ShortLinkBatchCreateReqDTO requestParam) {
        return Results.success(shortLinkService.batchCreateShortLink(requestParam));
    }
}
