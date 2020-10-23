package com.spoto.controller;

import com.alibaba.fastjson.JSONObject;
import com.spoto.model.Emp;
import com.spoto.service.EmpService;
import com.spoto.service.LoginService;
import com.spoto.utils.PageData;
import com.spoto.utils.StringUtils;
import com.spoto.utils.TableData;
import com.spoto.utils.WebUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
public class EmpController {

    //接口包括实现类全部交给spring管理,不需要bean了;
    @Resource
    private EmpService as;

    @Resource
    private LoginService ls;

  //展现数据;
  @RequestMapping("/EList.ajax")
  public String EmpList(PageData pd){
      TableData<Emp> list = as.list(pd);
      return WebUtils.getReturnData(list);
  }

  //给用户名;
  @RequestMapping("/MainList.ajax")
  public String MainList(HttpServletRequest request){
      Object username = request.getSession().getAttribute("logined");
      //1.返回数据;
      JSONObject data = new JSONObject();
      data.put("username",username);
      return data.toJSONString();
  }

   //登录
   @RequestMapping("/login.ajax")
   public String LoginServer(String username, String passwd, HttpServletRequest request){
      //定义一个状态码;
      int code=0;
      //2.参数校验;
//        //isAllNotEmpty 全都不为空;加了！表示有一个是空的;
      if (!StringUtils.isAllNotEmpty(username,passwd)){
          //空参数操作;
          code=-1;
      }else {
          //3.调用业务处理;
          boolean logined = ls.newLogin(username, passwd);
          if (logined){
              request.getSession().setAttribute("logined",username);
              code=0;
          }else {
              code=-2;
          }
      }
      //4.处理结果，响应出去;
      JSONObject data = new JSONObject();
      data.put("code",code);
      return data.toJSONString();
   }

    //退出;
    @RequestMapping("/out-login.ajax")
    public String OutLogin(HttpServletRequest request){
        //这里没有null这个属性，所以只能是设置setAttribute;
        request.getSession().setAttribute("logined",null);
        JSONObject data = new JSONObject();
        data.put("type",true);
        return data.toJSONString();
    }

    //新增和修改;
    @RequestMapping("/Save-Emp.ajax")
   public String SaveEmp(Integer id,String role,String username,String uname,String passwd,String status,String others){
        //实例化Emp;
        Emp emp = new Emp();
        emp.setId(id);
        emp.setRole(role);
        emp.setUsername(username);
        emp.setUname(uname);
        emp.setPasswd(passwd);
        emp.setStatus(status);
        emp.setOthers(others);

        as.save(emp);

        //4.以流的形式写出去;
        JSONObject data = new JSONObject();
        data.put("type",true);
        return data.toJSONString();
   }


    //删除;
    @RequestMapping("/Del.ajax")
    public String DelEmp(String ids) {
        //1.定义Object
        JSONObject data = new JSONObject();
        //2.参数校验;
        if (StringUtils.isEmpty(ids)){
            data.put("type",false);
            return data.toJSONString();
        }
        //3.分割数组,遍历;
        String[] idListStr = ids.split(",");
        List<Integer> idList=new ArrayList<>();
        for (String idstr:idListStr){
            int id = Integer.parseInt(idstr);
            idList.add(id);
        }
        //3.1判断是否前端给到参数;
        //System.out.println(idList.toString());
        //4.调用接口;
            as.delete(idList);
        //5.返回数据;
        data.put("type",true);
        return data.toJSONString();
    }









    //转发
    @RequestMapping("/page")
    public ModelAndView page() {
        String name="张三";
        ModelAndView mv = new ModelAndView();
        mv.setViewName("page.jsp");
        mv.addObject("xxx",name);
        return mv;
    }


    @RequestMapping("pa")
    @ResponseBody
    public String PA(String aa,String cc){
        System.out.println(aa+cc);
        System.out.println("----");
         return  "xxx";
   }

    @RequestMapping("pa1")
    @ResponseBody
    public String PA1(Emp ep){

        System.out.println(ep.toString());

        return  "xxx";
    }


 }
