package com.axinstar.shortlink.project.service;

import com.axinstar.shortlink.project.dao.entity.LinkStatsTodayDO;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Mapper;

/**
 * 短链接今日统计接口层
 */
@Mapper
public interface LinkStatsTodayService extends IService<LinkStatsTodayDO> {
}
