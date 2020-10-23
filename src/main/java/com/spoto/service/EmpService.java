package com.spoto.service;

import com.spoto.model.Emp;
import com.spoto.utils.PageData;
import com.spoto.utils.TableData;

import java.util.List;

public interface EmpService {

    //第一个业务 从前端页面保存数据到数据库;
    void save(Emp emp);

    //第二个业务 从数据库查询数据到表格;
    TableData <Emp> list(PageData pd);

    //第三个业务，从前端页面删除员工数据到数据库;
    void delete(List<Integer> ids);

}
