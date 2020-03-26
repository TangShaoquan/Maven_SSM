package cn.betterts.Dao;

import cn.betterts.Domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {

    private InputStream inputStream;
    private SqlSession sqlSession;
    private UserDao mapper;



    @Before
    public void init() throws IOException {
        //1.获取配置文件
        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sessionFactory = builder.build(inputStream);
        sqlSession = sessionFactory.openSession();
        mapper = sqlSession.getMapper(UserDao.class);

    }

    @After
    public void destory() throws IOException {
        inputStream.close();
        sqlSession.close();
    }

    @Test
    public void testFindall(){
        List<User> users = mapper.findAll();
        for(User user : users){
            System.out.println(user);
        }
    }



}

