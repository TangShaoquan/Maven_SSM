package cn.betterts.Dao;

import cn.betterts.Domain.Account;

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

}
