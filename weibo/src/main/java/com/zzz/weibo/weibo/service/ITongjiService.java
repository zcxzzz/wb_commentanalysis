package com.zzz.weibo.weibo.service;

import com.zzz.weibo.exception.QueryException;
import com.zzz.weibo.weibo.entity.Tongji;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zzz
 * @since 2020-07-10
 */
public interface ITongjiService extends IService<Tongji> {

    List<Tongji> getTongjiData() throws QueryException;

}
