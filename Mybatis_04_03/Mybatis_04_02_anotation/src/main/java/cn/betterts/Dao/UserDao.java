package cn.betterts.Dao;

import cn.betterts.Domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserDao {
//    在Mybatis中针对CRUD一共有四个注释
//    @Select()
//    @Insert()
//    @Update()
//    @Delete()



    /** 
    * @Description: 查询所有用户
    * @Param: []
    * @return: java.util.List<cn.betterts.Domain.User>
    * @Author: 唐绍权 
    * @Date: 21:44.2020/3/19
    */
    @Select("select * from user")
    public List<User> findAll();
    
    /** 
    * @Description: 保存用户/新增用户
    * @Param: [user]
    * @return: void
    * @Author: 唐绍权 
    * @Date: 22:20.2020/3/19
    */
    @Insert("insert into user(username,address,sex,birthday) values(#{username},#{address},#{sex},#{birthday})")
    public void saveuser(User user);
    
    /** 
    * @Description: 更新用户
    * @Param: [user]
    * @return: void
    * @Author: 唐绍权 
    * @Date: 22:28.2020/3/19
    */
    @Update("update user set username=#{username},address=#{address},sex=#{sex},birthday=#{birthday} where id=#{id}")
    public void updateUser(User user);
    
    /** 
    * @Description: 删除用户
    * @Param: [id]
    * @return: void
    * @Author: 唐绍权 
    * @Date: 22:30.2020/3/19
    */
    @Delete("delete from user where id=#{id}")
    public void deleteUser(Integer id);


    /** 
    * @Description: 根据id查询一个
    * @Param: [id]
    * @return: cn.betterts.Domain.User
    * @Author: 唐绍权 
    * @Date: 22:34.2020/3/19
    */
    @Select("select * from user where id=#{id}")
    public User findOne(Integer id);

    /** 
    * @Description: 根据名字进行模糊查询
    * @Param: [username]
    * @return: java.util.List<cn.betterts.Domain.User>
    * @Author: 唐绍权 
    * @Date: 22:39.2020/3/19
    */
//    @Select("select * from user where username like #{username}")
//    或者：
    @Select("select * from user where username like '%${value}%'")
    public List<User> findByName(String username);


    /**
    * @Description: 返回总数
    * @Param: []
    * @return: java.lang.Integer
    * @Author: 唐绍权
    * @Date: 22:41.2020/3/19
    */
    @Select("select count(*) from user")
    public Integer findTotal();
}
