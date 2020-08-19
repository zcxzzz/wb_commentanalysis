package com.zzz.weibo.weibo.service.impl;

import com.zzz.weibo.exception.QueryException;
import com.zzz.weibo.weibo.entity.PhoneBi;
import com.zzz.weibo.weibo.mapper.PhoneBiMapper;
import com.zzz.weibo.weibo.service.IPhoneBiService;
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
public class PhoneBiServiceImpl extends ServiceImpl<PhoneBiMapper, PhoneBi> implements IPhoneBiService {

    @Override
    public List<PhoneBi> getPhoneBiData() throws QueryException {
        List<PhoneBi> phoneBiList = null;
        try{
            phoneBiList = list();
        }catch (Exception e){
            new QueryException("用户查询错误");
        }
        return phoneBiList;
    }

}
