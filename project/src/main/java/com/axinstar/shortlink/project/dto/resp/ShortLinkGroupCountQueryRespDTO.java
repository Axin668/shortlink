package com.axinstar.shortlink.project.dto.resp;

import lombok.Data;

/**
 * 短链接分组数量查询返回响应
 */
@Data
public class ShortLinkGroupCountQueryRespDTO {

    /**
     * 分组标识
     */
    private String gid;

    /**
     * 短链接数量
     */
    private Integer shortLinkCount;
}
