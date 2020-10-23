package com.spoto.controller;

import com.spoto.asyncs.DemoAsync;
import com.spoto.utils.RedisUtils;
import com.spoto.utils.WebUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class RedisController {

    @Resource
    private RedisUtils redisUtils;

    @Resource
    private DemoAsync demoAsync;

    @RequestMapping("/redis")
    public String redis() {
//        redisUtils.save("aa","bb");
//        redisUtils.save("aa1","bb1",300L);

//        Object aa = redisUtils.get("aa");
//        System.out.println(aa);

//
//        redisUtils.del("aa");


        demoAsync.demoAsync("aa");
        return "suc";
    }
}
