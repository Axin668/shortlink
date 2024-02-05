package com.axinstar.shortlink.admin.service;

import com.axinstar.shortlink.admin.common.convention.result.Result;
import com.axinstar.shortlink.admin.remote.dto.req.ShortLinkRecycleBinPageReqDTO;
import com.axinstar.shortlink.admin.remote.dto.resp.ShortLinkPageRespDTO;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 回收站管理接口层
 */
public interface RecycleBinService {

    /**
     * 分页查询回收站内短链接
     *
     * @param requestParam 请求参数
     * @return 响应参数
     */
    Result<IPage<ShortLinkPageRespDTO>> pageRecycleBinShortLink(ShortLinkRecycleBinPageReqDTO requestParam);
}
