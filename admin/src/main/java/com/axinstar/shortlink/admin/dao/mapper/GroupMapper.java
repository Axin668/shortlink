package com.axinstar.shortlink.admin.dao.mapper;

import com.axinstar.shortlink.admin.dao.entity.GroupDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 短链接分组持久层
 */
@Mapper
public interface GroupMapper extends BaseMapper<GroupDO> {
}
