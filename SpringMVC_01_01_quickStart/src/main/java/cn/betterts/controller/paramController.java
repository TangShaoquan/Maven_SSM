package cn.betterts.controller;

import cn.betterts.domain.Account;
import cn.betterts.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(path = "/param")
public class paramController {

//    @RequestMapping(path = "/testparam")
//    public String testParam(String username){
//        System.out.println("执行了……");
////        演示拿到属性
//        System.out.println(username);
//        return "success";
//    }


    @RequestMapping("saveaccount")
    public String saveAccount(Account account){
        System.out.println(account);
        return "success";

    }

    @RequestMapping("/saveuser")
    public String saveuser(User user){
        System.out.println(user);
        return "success";
    }

    @RequestMapping("/servlet")
    public String servlet(HttpServletRequest reques, HttpServletResponse response){
        System.out.println(reques);
        System.out.println(response);
        System.out.println();
        return "success";
    }
}
