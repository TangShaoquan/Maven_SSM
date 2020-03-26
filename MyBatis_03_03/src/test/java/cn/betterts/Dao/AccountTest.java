package cn.betterts.Dao;

import cn.betterts.Domain.Account;
import cn.betterts.Domain.AccountUser;
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

public class AccountTest {

    private InputStream inputStream;
    private SqlSession sqlSession;
    private AccountDao mapper;



    @Before
    public void init() throws IOException {
        //1.获取配置文件
        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sessionFactory = builder.build(inputStream);
        sqlSession = sessionFactory.openSession();
        mapper = sqlSession.getMapper(AccountDao.class);

    }

    @After
    public void destory() throws IOException {
        inputStream.close();
        sqlSession.close();
    }

    @Test
    public void testFindall(){
        List<Account>  accounts= mapper.findAll();
        for(Account account : accounts){
            System.out.println(account);

            System.out.println(account.getUser());
        }
    }

    /**
    * @Description: 查询所有账单并且包含用户名称和地址
    * @Param: []
    * @return: void
    * @Author: 唐绍权
    * @Date: 13:44.2020/3/19
    */
    @Test
    public void TestfindAllAccountUser(){
        List<AccountUser> allAccountUser = mapper.findAllAccountUser();
        for(Account account : allAccountUser){
            System.out.println(account);
        }
    }

}

