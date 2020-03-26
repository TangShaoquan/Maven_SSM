package cn.betterts.dao;

import cn.betterts.domain.User;

import java.util.List;

/*
用户的持久层接口
 */
public interface UserDao {
//    查询所有操作
    public List<User> findAll();
}
