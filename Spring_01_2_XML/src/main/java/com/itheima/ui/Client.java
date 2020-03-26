package com.itheima.ui;

import com.itheima.service.IAccountService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itheima.dao.IAccountDao;

/**
 * 模拟一个表现层，用于调用业务层
 */
public class Client {

    /** 
    * @Description: 获取Spring的IOC核心同期，并提取id对象
    * @Param: [args]
    * @return: void
    * @Author: 唐绍权 
    * @Date: 12:27.2020/3/20
    */
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService accountService = (IAccountService) classPathXmlApplicationContext.getBean("accountService");
        IAccountDao accountDao = classPathXmlApplicationContext.getBean("accountDao", IAccountDao.class);
        System.out.println(accountService);
        System.out.println(accountDao);
    }
}
