package com.zzz.weibo.weibo.service.impl;

import com.zzz.weibo.exception.QueryException;
import com.zzz.weibo.weibo.entity.Ciyu;
import com.zzz.weibo.weibo.mapper.CiyuMapper;
import com.zzz.weibo.weibo.service.ICiyuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-07-12
 */
@Service
public class CiyuServiceImpl extends ServiceImpl<CiyuMapper, Ciyu> implements ICiyuService {

    @Override
    public List<Ciyu> getCiyuData() throws QueryException {
        List<Ciyu> list = null;
        try{
            list = list();
        }catch (Exception e){
            new QueryException("用户查询错误");
        }
        return list;
    }
}
