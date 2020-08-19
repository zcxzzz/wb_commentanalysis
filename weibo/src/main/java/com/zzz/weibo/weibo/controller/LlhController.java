package com.zzz.weibo.weibo.controller;


import com.alibaba.fastjson.JSONObject;
import com.zzz.weibo.exception.QueryException;
import com.zzz.weibo.weibo.entity.BotResult;
import com.zzz.weibo.weibo.entity.Llh;
import com.zzz.weibo.weibo.service.ILlhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2020-07-11
 */
@CrossOrigin
@RestController
@RequestMapping("/weibo")
public class LlhController {

    @Autowired
    private ILlhService iLlhService;
    @RequestMapping(value = "/llh",method = RequestMethod.GET)
    public JSONObject getLlhData(){
        JSONObject jsonObject = new JSONObject();
        try{
            List<Llh> list = iLlhService.getLlhData();
            jsonObject.put("errorcode","0");
            jsonObject.put("data",list);
        } catch (QueryException e) {
            jsonObject.put("errorcode","1000");
            jsonObject.put("data",e.getMessage());
        }
        return jsonObject;
    }



}
