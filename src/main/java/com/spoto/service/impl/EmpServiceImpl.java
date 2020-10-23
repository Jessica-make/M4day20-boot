package com.spoto.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.session.RowBounds;
import com.spoto.dao.EmpMapper;
import com.spoto.model.Emp;
import com.spoto.service.EmpService;
import com.spoto.utils.PageData;
import com.spoto.utils.PageUtils;
import com.spoto.utils.TableData;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Override
    //这里可以开启注解，异常回滚;
    @Transactional(rollbackFor = Exception.class)
    public void save(Emp emp) {
        //新dao,这里做id的参数校验
        if (emp.getId() > 0) {
            //修改;
           mapper.change(emp.getId(),emp.getRole(),emp.getUsername(),emp.getUname(),emp.getPasswd(),emp.getStatus(),emp.getOthers());
            //不需要提交，不需要回滚，自动帮我们做;
        } else {
            //新增
           mapper.add(emp);
        }
    }

    //spring把dao的new解决了，所有的东西放在mapper里面;
    @Resource
    private EmpMapper mapper;

    @Override
    public TableData <Emp> list(PageData pd){
        //1.构造结果数据;
        TableData<Emp> td = new TableData<>(pd);

        //2.获取查询数据;
        String username=null;
        String passwd=null;
        JSONObject sd= pd.getSd();
        if (pd.getSd()!=null){
           username=sd.getString("username");
           passwd=sd.getString("passwd");
        }

        //3.查询数据条数;
        Integer count = mapper.listCount(username, passwd);
        td.setDataCount(count);
        if (count<=0){
            return td;
        }

        //4.调用dao;
        //PageIndex是属于TableData里面封装的属性，而这里还是要根据传下来的值进行分页公式;
        RowBounds rb  = PageUtils.getRowBounds(pd);
        //mapper调用getList的方法,得到的数据，设置到TableData里面，
        //5.那么在上一级controller那里，只要调用或者实例化TableData就可以取出所有的参数;
        List<Emp> list = mapper.getList(rb, username, passwd);
        td.setDataList(list);
        return td;
    }





    //删除数据
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Integer> ids) {
       mapper.del(ids);
    }
}
