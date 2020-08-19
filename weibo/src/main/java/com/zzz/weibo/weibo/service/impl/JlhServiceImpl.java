package com.zzz.weibo.weibo.service.impl;

import com.zzz.weibo.exception.QueryException;
import com.zzz.weibo.weibo.entity.Blh;
import com.zzz.weibo.weibo.entity.Jlh;
import com.zzz.weibo.weibo.mapper.JlhMapper;
import com.zzz.weibo.weibo.service.IJlhService;
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
public class JlhServiceImpl extends ServiceImpl<JlhMapper, Jlh> implements IJlhService {

    @Override
    public List<Jlh> getJlhData() throws QueryException {
        List<Jlh> jlhs = null;
        try{
            jlhs = list();
        }catch (Exception e){
            new QueryException("用户查询错误");
        }
        return jlhs;
    }

}
