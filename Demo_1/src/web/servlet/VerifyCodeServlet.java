package web.servlet;

import cn.itcast.utils.VerifyCode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

@WebServlet(name = "VerifyCodeServlet")
public class VerifyCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //创建验证码类
        VerifyCode verifyCode = new VerifyCode();
        //得到验证图片
        BufferedImage image = verifyCode.getImage();
        //把图片上文本保存在session中
        request.getSession().setAttribute("session_vcode",verifyCode.getText());
        //把图片响应给客户端
        VerifyCode.output(image,response.getOutputStream());
    }
}
