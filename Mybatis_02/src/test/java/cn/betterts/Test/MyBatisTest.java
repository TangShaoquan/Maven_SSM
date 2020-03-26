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
    public void testSave(){
        User user = new User();
        user.setUsername("dadada");
        user.setSex("男");
        user.setAddress("中南");
        user.setBirthday(new Date());
//        验证获取id
        System.out.println("插入保存之前的id"+user);
        mapper.save(user);

        sqlSession.commit();//提交事务
        System.out.println("插入保存之后的id"+user);

    }
    @Test
    public void testUpdate(){
        User user = new User();
        user.setUsername("权d绍");
        user.setSex("男");
        user.setAddress("中南");
        user.setBirthday(new Date());
        user.setId(42);
        mapper.update(user);
        sqlSession.commit();
    }

    @Test
    public void Testdelete(){
        mapper.delete(50);
        sqlSession.commit();
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
    public void TestindTotal(){
        int total = mapper.findTotal();
        System.out.println(total);
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

}

