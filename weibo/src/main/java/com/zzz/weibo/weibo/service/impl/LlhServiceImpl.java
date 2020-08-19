package com.zzz.weibo.weibo.service.impl;

import com.zzz.weibo.exception.QueryException;
import com.zzz.weibo.weibo.entity.Jlh;
import com.zzz.weibo.weibo.entity.Llh;
import com.zzz.weibo.weibo.mapper.LlhMapper;
import com.zzz.weibo.weibo.service.ILlhService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-07-11
 */
@Service
public class LlhServiceImpl extends ServiceImpl<LlhMapper, Llh> implements ILlhService {

    @Override
    public List<Llh> getLlhData() throws QueryException {
        List<Llh> llhs = null;
        try {
            llhs = list();
        } catch (Exception e) {
            new QueryException("用户查询错误");
        }
        return llhs;
    }
}
