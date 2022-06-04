package cn.itcast.test;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import org.junit.jupiter.api.Test;

public class UserDaoTest {

    @Test
    public void testLogin(){
        UserDao dao = new UserDao();
        User loginUser = new User();
        loginUser.setUsername("superman");
        loginUser.setPassword("123");
        User user = dao.login(loginUser);

        System.out.println(user);
    }
}
