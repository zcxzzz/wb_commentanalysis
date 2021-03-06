package com.zzz.weibo.weibo.service;

import com.zzz.weibo.exception.QueryException;
import com.zzz.weibo.weibo.entity.Blh;
import com.zzz.weibo.weibo.entity.Jlh;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2020-07-11
 */
public interface IJlhService extends IService<Jlh> {
    List<Jlh> getJlhData() throws QueryException;
}
