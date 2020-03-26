package cn.betterts.Dao.Impl;

import cn.betterts.Dao.UserDao;
import cn.betterts.Domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserDaoImpl implements UserDao {
    private SqlSessionFactory factory;


    /**
     * @Description: 构造函数
     * @Param: [SqlSessionFactory]
     * @return: null
     * @Author: 唐绍权
     * @Date: 2020/3/19
     */
    public UserDaoImpl(SqlSessionFactory factory){
        this.factory =factory;
    }



    /**
     * @Description: 查找全部
     * @Param: [null]
     * @return: java.util.List<cn.betterts.Domain.User>
     * @Author: 唐绍权
     * @Date: 2020/3/19
     */
    @Override
    public List<User> findAll() {
        //根据工厂类获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //调用SqlSession中的方法实现查询列表
        //参数就是能获取到配置信息的key,就是namespace的名称+方法名
        List<User> users = sqlSession.selectList("cn.betterts.Dao.UserDao.findAll");
        sqlSession.close();
        return users;
    }

    /**
     * @Description: 自定义Dao实现方法
     * @Param: [user]
     * @return: void
     * @Author: 唐绍权
     * @Date: 2020/3/19
     */
    @Override
    public void save(User user) {
        SqlSession sqlSession = factory.openSession();
        sqlSession.insert("cn.betterts.Dao.UserDao.save",user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void update(User user) {
        SqlSession sqlSession = factory.openSession();
        sqlSession.update("cn.betterts.Dao.UserDao.update",user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void delete(int id) {
       return;
    }

    @Override
    public User findById(int id) {
        SqlSession sqlSession = factory.openSession();
        User user = sqlSession.selectOne("cn.betterts.Dao.UserDao.findById",id);
        sqlSession.close();
        return user;
    }

    @Override
    public List<User> findByName(String name) {
        SqlSession sqlSession = factory.openSession();
        List<User> users = sqlSession.selectList("cn.betterts.Dao.UserDao.findByName", name);
        sqlSession.close();
        return users;
    }

    @Override
    public int findTotal() {
        SqlSession sqlSession = factory.openSession();
        int num = sqlSession.selectOne("cn.betterts.Dao.UserDao.findTotal");
        sqlSession.close();
        return num;
    }
}
