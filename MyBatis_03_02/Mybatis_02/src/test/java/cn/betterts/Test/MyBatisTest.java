package cn.betterts.Test;

import cn.betterts.Dao.UserDao;
import cn.betterts.Domain.QueryVo;
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
import java.util.ArrayList;
import java.util.Date;
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


    @Test
    public void TestfindById(){
        User byId = mapper.findById(43);
        System.out.println(byId);
    }

    @Test
    public void TestFindByName(){
        List<User> byName = mapper.findByName("%绍");
        for (User user : byName){
            System.out.println(user);
        }
    }


    @Test
    public void TestFindByQv(){
        QueryVo queryVo = new QueryVo();
        User user = new User();
        user.setUsername("%绍%");
        queryVo.setUser(user);
        List<User> byUserByVo = mapper.findByUserByVo(queryVo);
        for (User us:byUserByVo){
            System.out.println(us);
        }
    }
    @Test
    public void TestfindByCondition(){
        User user = new User();
        user.setUsername("唐绍权");
        List<User> byCondition = mapper.findByCondition(user);
        for (User us:byCondition){
            System.out.println(us);
        }

    }

    /**
    * @Description: 查询ids
    * @Param: [void]
    * @return: void
    * @Author: 唐绍权
    * @Date: 12:30.2020/3/19
    */
    @Test
    public void TestfindByIdInIds(){
        QueryVo queryVo = new QueryVo();
        List<Integer> list = new ArrayList<>();
        list.add(43);
        list.add(45);
        list.add(49);
        queryVo.setIds(list);
        System.out.println(queryVo);

        List<User> byUserByVo = mapper.findByIdInIds(queryVo);


        for (User us:byUserByVo){
            System.out.println(us);
        }


    }

}

