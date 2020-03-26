package cn.betterts.Dao;

import cn.betterts.Domain.User;

import java.util.List;

public interface UserDao {
    //@Select("select * from user")
    /** 
    * @Description: 查询所有用户，同时获取到下属的账单信息
    * @Param: []
    * @return: java.util.List<cn.betterts.Domain.User>
    * @Author: 唐绍权 
    * @Date: 14:31.2020/3/19
    */
    public List<User> findAll();
    public User findById(int id);

}
