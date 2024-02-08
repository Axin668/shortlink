package com.axinstar.shortlink.project.dao.mapper;

import com.axinstar.shortlink.project.dao.entity.LinkStatsTodayDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 短链接今日统计持久层
 */
@Mapper
public interface LinkStatsTodayMapper extends BaseMapper<LinkStatsTodayDO> {
}
