package cn.betterts.Test;

import cn.betterts.Dao.Impl.UserDaoImpl;
import cn.betterts.Dao.UserDao;
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
import java.util.Date;
import java.util.List;

public class MyBatisTest {

    private InputStream inputStream;
    private UserDaoImpl mapper;



    @Before
    public void init() throws IOException {
        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sessionFactory = builder.build(inputStream);

        mapper = new UserDaoImpl(sessionFactory);

    }

    @After
    public void destory() throws IOException {
        inputStream.close();
        //sqlSession.close();
    }

    /**
     * @Description: 自己实现Dao
     * @Param: [null]
     * @return: void
     * @Author: 唐绍权
     * @Date: 2020/3/19
     */
    @Test
    public void testFindall(){
        List<User> users = mapper.findAll();
        for(User user : users){
            System.out.println(user);
        }
    }

    @Test
    public void testSave(){
        User user = new User();
        user.setUsername("唐绍波");
        user.setSex("男");
        user.setAddress("中南");
        user.setBirthday(new Date());
//        验证获取id
        System.out.println("插入保存之前的id"+user);
        mapper.save(user);
        System.out.println("插入保存之后的id"+user);

    }
    @Test
    public void testUpdate(){
        User user = new User();
        user.setUsername("唐绍波");
        user.setSex("男");
        user.setAddress("泸西");
        user.setBirthday(new Date());
        user.setId(51);
        mapper.update(user);

    }

//    @Test
//    public void Testdelete(){
//        mapper.delete(51);
//    }

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
    public void TestindTotal(){
        int total = mapper.findTotal();
        System.out.println(total);
    }
//

}

