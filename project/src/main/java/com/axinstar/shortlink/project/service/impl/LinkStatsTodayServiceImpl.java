package com.axinstar.shortlink.project.service.impl;

import com.axinstar.shortlink.project.dao.entity.LinkStatsTodayDO;
import com.axinstar.shortlink.project.dao.mapper.LinkStatsTodayMapper;
import com.axinstar.shortlink.project.service.LinkStatsTodayService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 短链接今日统计接口实现层
 */
@Service
public class LinkStatsTodayServiceImpl extends ServiceImpl<LinkStatsTodayMapper, LinkStatsTodayDO> implements LinkStatsTodayService {
}
