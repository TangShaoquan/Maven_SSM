package cn.betterts.Test;

import cn.betterts.Dao.UserDao;
import cn.betterts.Domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybatisOnAnnoTest {

    @Test
    public void FindAllTest() throws IOException {
//        1. 获取字节输入流
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
//        2. 根据字节输入流构建SqlSessionBuilder
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
//        3. 根据SqlSessionBuilder创建一个SqlSessionFactory
        SqlSessionFactory factory = sqlSessionFactoryBuilder.build(inputStream);
//        4. 根据SqlSessionFactory获取Dao代理对象
        SqlSession sqlSession = factory.openSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
//        5. 使用代理对象执行Dao方法
        List<User> users = mapper.findAll();
        for (User user : users){
            System.out.println(user);
        }
//        6. 释放资源
        sqlSession.clearCache();
        inputStream.close();

    }
//
//    @Test
//    public void SaveUserTest() throws IOException {
////        1. 获取字节输入流
//        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
////        2. 根据字节输入流构建SqlSessionBuilder
//        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
////        3. 根据SqlSessionBuilder创建一个SqlSessionFactory
//        SqlSessionFactory factory = sqlSessionFactoryBuilder.build(inputStream);
////        4. 根据SqlSessionFactory获取Dao代理对象
//        SqlSession sqlSession = factory.openSession();
//        UserDao mapper = sqlSession.getMapper(UserDao.class);
////        5. 使用代理对象执行Dao方法
//        User user = new User();
//        user.setUsername("王二小");
//        user.setBirthday(new Date());
//        user.setSex("男");
//        user.setAddress("中男");
//        mapper.saveuser(user);
//        sqlSession.commit();
//
////        6. 释放资源
//        sqlSession.clearCache();
//        inputStream.close();
//
//    }
//
//    @Test
//    public void UpdateUserTest() throws IOException {
////        1. 获取字节输入流
//        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
////        2. 根据字节输入流构建SqlSessionBuilder
//        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
////        3. 根据SqlSessionBuilder创建一个SqlSessionFactory
//        SqlSessionFactory factory = sqlSessionFactoryBuilder.build(inputStream);
////        4. 根据SqlSessionFactory获取Dao代理对象
//        SqlSession sqlSession = factory.openSession();
//        UserDao mapper = sqlSession.getMapper(UserDao.class);
////        5. 使用代理对象执行Dao方法
//        User user = new User();
//        user.setId(52);
//        user.setUsername("巴拉拉小魔仙");
//        user.setBirthday(new Date());
//        user.setSex("男");
//        user.setAddress("中男");
//        mapper.updateUser(user);
//        sqlSession.commit();
//
////        6. 释放资源
//        sqlSession.clearCache();
//        inputStream.close();
//
//    }
//
//    @Test
//    public void DeleteUserTest() throws IOException {
////        1. 获取字节输入流
//        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
////        2. 根据字节输入流构建SqlSessionBuilder
//        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
////        3. 根据SqlSessionBuilder创建一个SqlSessionFactory
//        SqlSessionFactory factory = sqlSessionFactoryBuilder.build(inputStream);
////        4. 根据SqlSessionFactory获取Dao代理对象
//        SqlSession sqlSession = factory.openSession();
//        UserDao mapper = sqlSession.getMapper(UserDao.class);
////        5. 使用代理对象执行Dao方法
//        mapper.deleteUser(52);
//        sqlSession.commit();
//
////        6. 释放资源
//        sqlSession.clearCache();
//        inputStream.close();
//
//    }
//
//    @Test
//    public void FineOneTest() throws IOException {
////        1. 获取字节输入流
//        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
////        2. 根据字节输入流构建SqlSessionBuilder
//        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
////        3. 根据SqlSessionBuilder创建一个SqlSessionFactory
//        SqlSessionFactory factory = sqlSessionFactoryBuilder.build(inputStream);
////        4. 根据SqlSessionFactory获取Dao代理对象
//        SqlSession sqlSession = factory.openSession();
//        UserDao mapper = sqlSession.getMapper(UserDao.class);
////        5. 使用代理对象执行Dao方法
//        User one = mapper.findOne(50);
//        System.out.println(one);
//
////        6. 释放资源
//        sqlSession.clearCache();
//        inputStream.close();
//
//    }
//
//    @Test
//    public void FineByNameTest() throws IOException {
////        1. 获取字节输入流
//        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
////        2. 根据字节输入流构建SqlSessionBuilder
//        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
////        3. 根据SqlSessionBuilder创建一个SqlSessionFactory
//        SqlSessionFactory factory = sqlSessionFactoryBuilder.build(inputStream);
////        4. 根据SqlSessionFactory获取Dao代理对象
//        SqlSession sqlSession = factory.openSession();
//        UserDao mapper = sqlSession.getMapper(UserDao.class);
////        5. 使用代理对象执行Dao方法
//        List<User> byName = mapper.findByName("%绍%");
//        for (User user : byName){
//            System.out.println(user);
//        }
//
////        6. 释放资源
//        sqlSession.clearCache();
//        inputStream.close();
//
//    }
//    @Test
//    public void FineTotalTest() throws IOException {
////        1. 获取字节输入流
//        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
////        2. 根据字节输入流构建SqlSessionBuilder
//        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
////        3. 根据SqlSessionBuilder创建一个SqlSessionFactory
//        SqlSessionFactory factory = sqlSessionFactoryBuilder.build(inputStream);
////        4. 根据SqlSessionFactory获取Dao代理对象
//        SqlSession sqlSession = factory.openSession();
//        UserDao mapper = sqlSession.getMapper(UserDao.class);
////        5. 使用代理对象执行Dao方法
//        Integer total = mapper.findTotal();
//        System.out.println(total);
//
////        6. 释放资源
//        sqlSession.clearCache();
//        inputStream.close();
//
//    }


}
