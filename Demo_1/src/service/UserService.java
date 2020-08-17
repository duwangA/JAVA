package service;

import dao.UserDao;
import domain.User;

/**
 * 业务层
 * 需要校验用户名是否被注册(通过用户名查询)，注册失败抛出自定义异常，把错误信息保存到request域，
 * 转发到regitst.jsp，注册成功在regist.jsp页面提示成功
 * 添加用户
 * void regist() throw UserException
 * 封装表单数据到User对象
 * 使用该对象调用regist()方法
 * 根据注册成功或者失败做处理
 */
public class UserService {
    private UserDao userDao = new UserDao();

    /**
     * 注册功能
     * @param user
     * @throws UserException
     */
    public void regist(User user) throws UserException {
        User dbuser = userDao.findByUsername(user.getUsername());
        if (dbuser != null)
            throw new UserException("用户名"+user.getUsername()+": 已被其他用户注册");
        userDao.addUser(user);
    }

    /**
     * 登录功能
     * @param form
     * @return
     */
    public User login(User form) throws UserException{
        /*
        使用form中的username进行查询，得到User
         */
        User user = userDao.findByUsername(form.getUsername());
        /*
        如果返回null，说明用户名不存在，抛异常
        返回User类的对象，说明用户名存在，校验密码
         */
        if (user == null)
            throw new UserException("用户名不存在！");
        if (!form.getPassword().equals(user.getPassword()))
            throw new UserException("密码错误！");

        //返回的user包含用户的所有信息
        return user;
    }
}
