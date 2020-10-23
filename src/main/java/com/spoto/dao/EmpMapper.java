package com.spoto.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import com.spoto.model.Emp;

import java.util.List;

//新的dao;
@Mapper
public interface EmpMapper {

    //登录;
    Integer newLogin(@Param("username") String username, @Param("passwd") String passwd);

    //新增;表示绑定到dao实现类的参数类型;
    Integer add(Emp ep);
    //修改;
    //@Param表示绑定到dao实现类的参数类型;
    Integer change(@Param("id") Integer id, @Param("role") String role, @Param("username") String username,
                   @Param("uname") String uname, @Param("passwd") String passwd,
                   @Param("status") String status, @Param("others") String others);
    //删除;
     Integer del(@Param("ids") List<Integer> ids);

    //展现数据+分页;
    List<Emp>getList(RowBounds rb, @Param("username") String username, @Param("passwd") String passwd);

    //统计数据;
    Integer listCount(@Param("username") String username, @Param("passwd") String passwd);



}
