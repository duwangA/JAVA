package web.servlet;

import cn.itcast.commons.CommonUtils;
import domain.User;
import service.UserException;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserService();
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        /*
        封装表单数据到form中
        调用service的login方法，得到返回的user对象，可包含积分之类的东西
        有异常：获取异常信息，保存到request域，在保存form，转发到login.jsp
        无异常：保存返回值到session中，重定向到index.jsp
         */
        User form = CommonUtils.toBean(request.getParameterMap(),User.class);

        try {
            User user =  userService.login(form);
            request.getSession().setAttribute("sessionUser",user);
            response.sendRedirect(request.getContextPath()+"/user/index.jsp");//重定向到新的页面
        } catch (UserException e) {
            request.setAttribute("msg",e.getMessage());
            request.setAttribute("user",form);
            request.getRequestDispatcher("/user/login.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
