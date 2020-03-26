package cn.betterts.Controller;

import cn.betterts.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/testString")
    public String testString(Model model){
        System.out.println("testString方法执行力……");
        User user = new User();
        user.setUsername("唐绍权");
        user.setAge(20);
        user.setPassword("tangshaoquan");
        model.addAttribute("user",user);
        return "success";
    }
    @RequestMapping("/testVoid")
    public void testString(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("testVoid方法执行力……");
//        如果没有返回值，默认会再访问此方法的路径，此时该方法没有参数
//        或者自己编写请求路径，此时参数是req和rep
//        手动转发不会再使用视图解析器

//        编写转发，转发一次请求
//        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);
//        return;
//        编写重定向，重定向是两次请求
//        response.sendRedirect(request.getContextPath()+"/index.jsp");

//        直接响应
        response.getWriter().write("hello!");
    }


    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
//        先创建一个ModelAndView对象
        ModelAndView mv = new ModelAndView();
        System.out.println(" testModelAndView方法执行了……");
        User user = new User();
        user.setUsername("唐绍权233");
        user.setAge(200);
        user.setPassword("tangshaoquan");
//       把user对象存入mv对象中，也会把user对象存到request对象中
        mv.addObject("user",(user));

//        跳转到哪一个界面
        mv.setViewName("success");
        return mv;
    }

    /**
    * @Description: 关键字的方式进行转发或者重定向,不能用视图解析器
    * @Param: [model]
    * @return: java.lang.String
    * @Author: 唐绍权
    * @Date: 16:22.2020/3/23
    */
    @RequestMapping("/testForwardOrRedirect")
    public String testForwardOrRedirect(){
        System.out.println("testForwardOrRedirect方法执行力……");
//        请求的转发
//        return "forward:/WEB-INF/pages/success.jsp";
//        请求重定向,不用加项目名称
        return "redirect:/index.jsp";
    }

//    @RequestMapping("/testAjax")
//    public String testAjax(@RequestBody String body){
//        System.out.println("testAjax方法执行力……");
//        System.out.println(body);
//
//        return "success";
//    }

    @RequestMapping("/testAjax")
    public @ResponseBody User testAjax(@RequestBody User user){
        System.out.println("testAjax方法执行了……");
        System.out.println(user);
        user.setUsername("唐绍权");
        return user;
    }

}
