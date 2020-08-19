package com.zzz.weibo.weibo.service.impl;

import com.zzz.weibo.exception.QueryException;
import com.zzz.weibo.weibo.entity.AgeZc;
import com.zzz.weibo.weibo.mapper.AgeZcMapper;
import com.zzz.weibo.weibo.service.IAgeZcService;
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
public class AgeZcServiceImpl extends ServiceImpl<AgeZcMapper, AgeZc> implements IAgeZcService {

    @Override
    public List<AgeZc> getAgezcData() throws QueryException {
        List<AgeZc> ageZcList = null;
        try{
            ageZcList = list();
        }catch (Exception e){
            new QueryException("用户查询错误");
        }
        return  ageZcList;
    }
}
