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
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "nServlet")
public class nServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                    request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        UserService userService = new UserService(); // 创建依赖

        User form = CommonUtils.toBean(request.getParameterMap(),User.class); //获取表单数据并封装到user

        /*
        表单校验，使用map装载所有错误信息
         */
        Map<String,String> errors = new HashMap<String, String>();
        //校验用户名，可以用foreach优化
        String username = form.getUsername();
        if (username == null || username.trim().isEmpty()){
            errors.put("username","用户名不能为空");
        }else if (username.length() < 3 || username.length() > 15){
            errors.put("username","长度必须控制在3-15之间");
        }
        //校验密码
        String password = form.getPassword();
        if (password == null || password.trim().isEmpty()){
            errors.put("password","密码不能为空");
        }else if (password.length() < 3 || password.length() > 15){
            errors.put("password","长度必须控制在3-15之间");
        }
        //校验验证码
        String sessionVcode = (String) request.getSession().getAttribute("session_vcode");
        String verifyCode = form.getVerifyCode();
        if (verifyCode == null || verifyCode.trim().isEmpty()){
            errors.put("password","密码不能为空");
        }else if (verifyCode.length() != 4){
            errors.put("password","长度必须控制在3-15之间");
        }else if (!verifyCode.equals(sessionVcode)){
            errors.put("verifyCode","验证码错误");
        }
        /*
        用户填写的验证码封装到了User对象中，真正的验证码在session中，比较两者，不同则保存错误信息，保存表单数据，转发到regist.jsp
        如果相同则直接向下执行
         */
//        String sessionVcode = (String) request.getSession().getAttribute("session_vcode");
//        if (!sessionVcode.equals(form.getVerifyCode())){
//            request.setAttribute("msg","验证码错误！");
//            request.setAttribute("user",form);
//            request.getRequestDispatcher("/user/n.jsp").forward(request,response);
//            return;
//        }
            /*
            判断map是否为空，为空则继续，不为空说明存在错误
             */
        if (errors != null && errors.size() > 0){
            request.setAttribute("errors",errors);
            request.setAttribute("user",form);
            request.getRequestDispatcher("/user/n.jsp").forward(request,response);
            return;
        }
        try {
            userService.regist(form);
            response.getWriter().print("<h1>恭喜你注册成功！</h1><a href='"+request.getContextPath()+
                    "/user/login.jsp"+"'>点击登录</a>");
        } catch (UserException e) {
            //获取异常信息，保存到request域
            request.setAttribute("msg",e.getMessage());
            //转发
            request.getRequestDispatcher("/user/n.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
