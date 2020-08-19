package com.zzz.weibo.weibo.service.impl;

import com.zzz.weibo.exception.QueryException;
import com.zzz.weibo.weibo.entity.Tongji;
import com.zzz.weibo.weibo.mapper.TongjiMapper;
import com.zzz.weibo.weibo.service.ITongjiService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zzz
 * @since 2020-07-10
 */
@Service
public class TongjiServiceImpl extends ServiceImpl<TongjiMapper, Tongji> implements ITongjiService {

    @Override
    public List<Tongji> getTongjiData() throws QueryException {
        List<Tongji> tongjiList = null;
        try{
            tongjiList = list();
        }catch (Exception e){
            new QueryException("用户查询错误");
        }
        return tongjiList;
    }
}
