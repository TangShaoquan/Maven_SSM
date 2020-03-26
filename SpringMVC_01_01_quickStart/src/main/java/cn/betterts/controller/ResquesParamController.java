package cn.betterts.controller;

import cn.betterts.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServlet;
import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/anno")
//把msg存到session域中
@SessionAttributes({"msg"})
public class ResquesParamController {

    @RequestMapping("/ReqyestParam")
    public String ResquesParamer(@RequestParam(name="name") String username){
        System.out.println("执行了");
        System.out.println(username);
        return "success";
    }

    /** 拿到整个请求体
    * @Description:
    * @Param: [username]
    * @return: java.lang.String
    * @Author: 唐绍权
    * @Date: 11:27.2020/3/22
    */
    @RequestMapping("/RequestBody")
    public String ResquestBodyr(@RequestBody String body){
        System.out.println("执行了");
        System.out.println(body);
        return "success";
    }

    /**
    * @Description: 获取请求头
    * @Param: [header]
    * @return: java.lang.String
    * @Author: 唐绍权
    * @Date: 14:37.2020/3/23
    */
    @RequestMapping("/RequestHeader")
    public String RequestHeader(@RequestHeader(value = "Accept")  String header){
        System.out.println("执行了");
        System.out.println(header);
        return "success";
    }

    @RequestMapping("/CookieValue")
    public String RequestCookieValuer(@CookieValue(value="JSESSIONID") String cookie){
        System.out.println("执行了");
        System.out.println(cookie);
        return "success";
    }

//    /**
//    * @Description: ModelAttribute
//    * @Param: [cookie]
//    * @return: java.lang.String
//    * @Author: 唐绍权
//    * @Date: 14:47.2020/3/23
//    */
//    @RequestMapping("/ModelAttribute")
//    public String testModelAttribute(User user){
//        System.out.println("ModelAttribute执行了");
//        System.out.println(user);
//        return "success";
//    }

//    /**
//    * @Description: 该方法会在访问的方法前先执行,返回值可以提交给访问的方法
//    * @Param: []
//    * @return: void
//    * @Author: 唐绍权
//    * @Date: 14:52.2020/3/23
//    */
//    @ModelAttribute
//    public User showUser(String name){
//        System.out.println("showUsere执行了");
//        User user = new User();
//        user.setName(name);
//        user.setBirthday(new Date());
//        user.setPassd("pass");
//        System.out.println(user);
//        return user;
//    }

    /**
     * @Description: ModelAttribute
     * @Param: [cookie]
     * @return: java.lang.String
     * @Author: 唐绍权
     * @Date: 14:47.2020/3/23
     */
    @RequestMapping("/ModelAttribute")
    public String testModelAttribute(@ModelAttribute("user") User user){
        System.out.println("ModelAttribute执行了");
        System.out.println(user);
        return "success";
    }

    @ModelAttribute
    public User showUser(String name,Map<String,User> map){
        System.out.println("showUsere执行了");
        User user = new User();
        user.setName(name);
        user.setBirthday(new Date());
        user.setPassd("pass");
        map.put("user",user);
        System.out.println(user);
        return user;
    }



    /**
    * @Description: 获取session,在里面存数据
    * @Param: []
    * @return: java.lang.String
    * @Author: 唐绍权
    * @Date: 15:11.2020/3/23
    */
    @RequestMapping("/SessionAttributes")
    public String testSessionAttributes( Model model){
        System.out.println("ModelAttribute执行了");
//        帮你存到request对象中
        model.addAttribute("msg","唐绍权");
        return "success";
    }

    @RequestMapping("/getSessionAttributes")
    public String testgetSessionAttributes( ModelMap model){
        System.out.println("ModelAttribute执行了");
//        帮你存到request对象中
        Object msg = model.get("msg");
        System.out.println(msg);
        return "success";
    }

    @RequestMapping("/delSessionAttributes")
    public String testdelSessionAttributes(SessionStatus sessionStatus){
        System.out.println("ModelAttribute执行了");
//        帮你存到request对象中
        sessionStatus.setComplete();
        return "success";
    }
}
