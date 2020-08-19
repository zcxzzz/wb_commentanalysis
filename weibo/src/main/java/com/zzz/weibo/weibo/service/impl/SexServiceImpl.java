package com.zzz.weibo.weibo.service.impl;

import com.zzz.weibo.exception.QueryException;
import com.zzz.weibo.weibo.entity.Sex;
import com.zzz.weibo.weibo.mapper.SexMapper;
import com.zzz.weibo.weibo.service.ISexService;
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
public class SexServiceImpl extends ServiceImpl<SexMapper, Sex> implements ISexService {
    @Override
    public List<Sex> getSexData() throws QueryException {
        List<Sex> sexList = null;
        try{
            sexList = list();
        }catch (Exception e){
            new QueryException("用户查询错误");
        }
        return sexList;
    }

}
