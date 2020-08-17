package testDao;

import dao.UserDao;
import domain.User;
import org.junit.Test;

/**
 * @author duwanga
 */
public class UserDaoTest {
    @Test
    public void testFindByUsername(){
        UserDao userDao = new UserDao();

        User user = userDao.findByUsername("赵六");
        System.out.println(user);
    }

    @Test
    public void testAddUser(){
        UserDao userDao = new UserDao();
        User user = new User();
        user.setUsername("张三");
        user.setPassword("123");
        userDao.addUser(user);
    }
}
