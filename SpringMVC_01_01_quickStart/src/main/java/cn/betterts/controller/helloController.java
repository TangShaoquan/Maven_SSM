package cn.betterts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

//此注解放在类上就可以让访问目录多一个
@RequestMapping(path = "/user")
public class helloController {
    
    
    /** 
    * @Description: 该方法会返回一个success.jsp页面给适配器，适配器再给前端控制器
    * @Param: []
    * @return: java.lang.String
    * @Author: 唐绍权 
    * @Date: 17:29.2020/3/21
    */
    @RequestMapping(path = "/hello")
    public String sayHello(){
        System.out.println("hello!");
        return "success";
    }
}
