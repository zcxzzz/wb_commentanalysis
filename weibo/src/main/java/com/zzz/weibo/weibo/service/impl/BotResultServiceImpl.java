package com.zzz.weibo.weibo.service.impl;

import com.zzz.weibo.exception.QueryException;
import com.zzz.weibo.weibo.entity.BotResult;
import com.zzz.weibo.weibo.mapper.BotResultMapper;
import com.zzz.weibo.weibo.service.IBotResultService;
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
public class BotResultServiceImpl extends ServiceImpl<BotResultMapper, BotResult> implements IBotResultService {

    @Override
    public List<BotResult> getBotData() throws QueryException {
        List<BotResult> botResults = null;
        try{
            botResults = list();
        }catch (Exception e){
            new QueryException("用户查询错误");
        }
        return botResults;
    }
}
