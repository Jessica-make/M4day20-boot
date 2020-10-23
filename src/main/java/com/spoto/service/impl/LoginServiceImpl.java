package com.spoto.service.impl;

import com.spoto.dao.EmpMapper;
import com.spoto.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginServiceImpl implements LoginService {
    //1.调用Dao;
    @Resource
    private EmpMapper mapper;

    @Override
    public boolean newLogin(String username, String passwd) {
        Integer anInt = mapper.newLogin(username, passwd);
        if (anInt>0){
            return true;
        }else {
            return false;
        }
    }
}
