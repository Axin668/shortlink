package com.axinstar.shortlink.project.dao.mapper;

import com.axinstar.shortlink.project.dao.entity.ShortLinkGotoDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 短链接跳转持久层
 */
// TODO 无法自动装配
@Mapper
public interface ShortLinkGotoMapper extends BaseMapper<ShortLinkGotoDO> {
}
