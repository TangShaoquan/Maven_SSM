package cn.betterts.Dao;

import cn.betterts.Domain.Account;
import cn.betterts.Domain.AccountUser;
import cn.betterts.Domain.User;

import java.util.List;

public interface AccountDao {
    /**
    * @Description: 查询所有用户并且获得所属的用户
    * @Param: []
    * @return: java.util.List<cn.betterts.Domain.Account>
    * @Author: 唐绍权
    * @Date: 13:31.2020/3/19
    */
    public List<Account> findAll();


    /** 
    * @Description: 查询所有，并且同时包含用户名和地址信息
    * @Param: []
    * @return: java.util.List<cn.betterts.Domain.AccountUser>
    * @Author: 唐绍权 
    * @Date: 13:37.2020/3/19
    */
    public List<AccountUser> findAllAccountUser();
}
