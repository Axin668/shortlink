package com.axinstar.shortlink.admin.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.axinstar.shortlink.admin.common.biz.user.UserContext;
import com.axinstar.shortlink.admin.common.convention.exception.ServiceException;
import com.axinstar.shortlink.admin.common.convention.result.Result;
import com.axinstar.shortlink.admin.dao.entity.GroupDO;
import com.axinstar.shortlink.admin.dao.mapper.GroupMapper;
import com.axinstar.shortlink.admin.remote.ShortLinkRemoteService;
import com.axinstar.shortlink.admin.remote.dto.req.ShortLinkRecycleBinPageReqDTO;
import com.axinstar.shortlink.admin.remote.dto.resp.ShortLinkPageRespDTO;
import com.axinstar.shortlink.admin.service.RecycleBinService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 回收站管理接口实现层
 */
@Service
@RequiredArgsConstructor
public class RecycleBinServiceImpl implements RecycleBinService {

    private final GroupMapper groupMapper;

    /**
     * 后续重构为 SpringCloud Feign 调用
     */
    ShortLinkRemoteService shortLinkRemoteService = new ShortLinkRemoteService(){
    };

    @Override
    public Result<IPage<ShortLinkPageRespDTO>> pageRecycleBinShortLink(ShortLinkRecycleBinPageReqDTO requestParam) {
        LambdaQueryWrapper<GroupDO> queryWrapper = Wrappers.lambdaQuery(GroupDO.class)
                .eq(GroupDO::getUsername, UserContext.getUsername())
                .eq(GroupDO::getDelFlag, 0);
        List<GroupDO> groupDOList = groupMapper.selectList(queryWrapper);
        if (CollUtil.isEmpty(groupDOList)) {
            throw new ServiceException("用户无分组信息");
        }
        requestParam.setGidList(groupDOList.stream().map(GroupDO::getGid).toList());
        return shortLinkRemoteService.pageRecycleBinShortLink(requestParam);
    }
}
