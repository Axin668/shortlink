package com.axinstar.shortlink.project.service;

import com.axinstar.shortlink.project.dao.entity.ShortLinkDO;
import com.axinstar.shortlink.project.dto.req.RecycleBinRecoverReqDTO;
import com.axinstar.shortlink.project.dto.req.RecycleBinSaveReqDTO;
import com.axinstar.shortlink.project.dto.req.ShortLinkRecycleBinPageReqDTO;
import com.axinstar.shortlink.project.dto.resp.ShortLinkPageRespDTO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 回收站管理接口层
 */
public interface RecycleBinService extends IService<ShortLinkDO> {

    /**
     * 保存回收站
     *
     * @param requestParam 请求参数
     */
    void saveRecycleBin(RecycleBinSaveReqDTO requestParam);

    /**
     * 分页查询回收站内短链接
     *
     * @param requestParam 分页查询回收站内短链接请求参数
     * @return 回收站短链接分页返回响应
     */
    IPage<ShortLinkPageRespDTO> pageShortLink(ShortLinkRecycleBinPageReqDTO requestParam);

    /**
     * 恢复短链接
     *
     * @param requestParam 请求参数
     */
    void recoverRecycleBin(RecycleBinRecoverReqDTO requestParam);
}
