package com.zzz.weibo.weibo.service;

import com.zzz.weibo.exception.QueryException;
import com.zzz.weibo.weibo.entity.Blh;
import com.zzz.weibo.weibo.entity.Llh;
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
public interface ILlhService extends IService<Llh> {
    List<Llh> getLlhData() throws QueryException;
}
