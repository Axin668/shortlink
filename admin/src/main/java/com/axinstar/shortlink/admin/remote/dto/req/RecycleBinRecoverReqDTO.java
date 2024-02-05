package com.axinstar.shortlink.admin.remote.dto.req;

import lombok.Data;

/**
 * 回收站恢复请求DTO
 */
@Data
public class RecycleBinRecoverReqDTO {

    /**
     * 分组标识
     */
    private String gid;

    /**
     * 完整短链接
     */
    private String fullShortUrl;
}
