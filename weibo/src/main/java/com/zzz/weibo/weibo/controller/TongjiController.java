package com.zzz.weibo.weibo.controller;


import com.alibaba.fastjson.JSONObject;
import com.zzz.weibo.exception.QueryException;
import com.zzz.weibo.weibo.entity.Tongji;
import com.zzz.weibo.weibo.service.ITongjiService;
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
 * @author zzz
 * @since 2020-07-10
 */
@CrossOrigin
@RestController
@RequestMapping("/weibo")
public class TongjiController {

    @Autowired
    private ITongjiService iTongjiService;
    @RequestMapping(value = "/tongji" ,method = RequestMethod.GET)
    public JSONObject getSexAgeBiData() {
        JSONObject jsonObject = new JSONObject();
        try{
            List<Tongji> list = iTongjiService.getTongjiData();
            jsonObject.put("errorcode",0);
            jsonObject.put("data",list);
        } catch (QueryException e) {
            jsonObject.put("errorcode",1000);
            jsonObject.put("data",e.getMessage());
        }
        return jsonObject;
    }

}
