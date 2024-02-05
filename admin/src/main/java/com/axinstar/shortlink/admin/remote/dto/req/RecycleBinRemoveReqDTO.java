package com.axinstar.shortlink.admin.remote.dto.req;

import lombok.Data;

/**
 * 回收站移除短链接请求DTO
 */
@Data
public class RecycleBinRemoveReqDTO {

    /**
     * 分组标识
     */
    private String gid;

    /**
     * 完整短链接
     */
    private String fullShortUrl;
}
