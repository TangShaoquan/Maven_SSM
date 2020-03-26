package cn.betterts.Dao;

import cn.betterts.Domain.User;

import java.util.List;

public interface UserDao {
    //@Select("select * from user")
    public List<User> findAll();
    public void save(User user);
    public void update(User user);
    public void delete(int id);
    public User findById(int id);
    public List<User> findByName(String name);
    public int findTotal();

}
