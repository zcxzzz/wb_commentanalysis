package com.zzz.weibo.weibo.service.impl;

import com.zzz.weibo.exception.QueryException;
import com.zzz.weibo.weibo.entity.Blh;
import com.zzz.weibo.weibo.mapper.BlhMapper;
import com.zzz.weibo.weibo.service.IBlhService;
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
public class BlhServiceImpl extends ServiceImpl<BlhMapper, Blh> implements IBlhService {


    @Override
    public List<Blh> getBlhData() throws QueryException {
        List<Blh> blhs = null;
        try{
            blhs = list();
        }catch (Exception e){
            new QueryException("用户查询错误");
        }
        return blhs;
    }
}
