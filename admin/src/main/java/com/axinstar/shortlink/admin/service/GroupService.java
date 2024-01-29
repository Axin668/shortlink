package com.axinstar.shortlink.admin.service;

import com.axinstar.shortlink.admin.dao.entity.GroupDO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 短链接分组接口层
 */
public interface GroupService extends IService<GroupDO> {

    void saveGroup(String groupName);
}
