package cn.betterts.test;

import cn.betterts.dao.UserDao;
import cn.betterts.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
//    入门案例

    public static void main(String[] args) throws IOException {
        //1. 读取配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");

        //2. 创建SqlSessionFactiory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(inputStream);

        //3. 使用工程生产SqlSession对象
        SqlSession sqlSession = factory.openSession();


        //4. 使用SqlSessionFactiory创建Dao接口的代理的机械
        UserDao userDao = sqlSession.getMapper(UserDao.class);

        //5. 使用代理对象执行方法
        List<User> users = userDao.findAll();
        for (User user: users
             ) {
            System.out.println(user);
        }
        //6. 释放资源
        sqlSession.close();
        inputStream.close();
    }


}
