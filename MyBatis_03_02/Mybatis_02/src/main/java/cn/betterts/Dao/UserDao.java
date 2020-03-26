package cn.betterts.Dao;

import cn.betterts.Domain.QueryVo;
import cn.betterts.Domain.User;
import org.apache.ibatis.annotations.Select;

import javax.management.Query;
import java.util.List;

public interface UserDao {
    //@Select("select * from user")
    public List<User> findAll();
    public User findById(int id);
    public List<User> findByName(String name);
    //根据vo中的条件查询用户数目
    public List<User> findByUserByVo(QueryVo vo);


    /** 
    * @Description: 根据条件查询
    * @Param: [user] 查询条件，有可能是用户名，id或者其他，也可以没有
    * @return: java.util.List<cn.betterts.Domain.User>
    * @Author: 唐绍权 
    * @Date: 11:35.2020/3/19
    */
    public List<User> findByCondition(User user);

    /** 
    * @Description: 根据QuerryVo中的id集合查询
    * @Param: [vo]
    * @return: java.util.List<cn.betterts.Domain.User>
    * @Author: 唐绍权
    * @Date: 12:24.2020/3/19
    */
    public List<User> findByIdInIds(QueryVo vo);

}
