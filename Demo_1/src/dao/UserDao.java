package dao;

import domain.User;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;

/**
 * 数据类
 * @author duwanga
 * 通过业务分析，需要提供两个方法
 * 1 按用户名查询用户对象
 *      User findByUsername(String username)
 * 2 插入用户到数据库
 *      void addUser(User user)
 *
 */
public class UserDao {
    private String path = "D:/users.xml"; //依赖数据文件

    /**
     * 按用户名查询
     * @param username
     * @return
     */
    public User findByUsername(String username){
        /*
        得到document
        xpath查询
        校验查询结果
         */
        //创建解析器
        SAXReader reader = new SAXReader();
        try {
            Document doc = reader.read(path);
            //xpath查询得到element
            Element element = (Element) doc.selectSingleNode("//user[@username='"+username+"']");
            //校验
            if (element == null)
                return null;
            //把ele封装到user对象
            User user = new User();
            String attrUsername = element.attributeValue("username");//获取该元素名为username的属性值
            String attrPassword = element.attributeValue("password");

            user.setUsername(attrUsername);
            user.setPassword(attrPassword);

            return user;
        } catch (DocumentException e) {
            throw new RuntimeException();
        }
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    public void addUser(User user){
        /*
        得到docment
        通过document得到root元素
        使用参数user，转换成Element对象
        把element添加到root元素
        保存
        */
        SAXReader reader = new SAXReader();

        try {
            Document doc = reader.read(path);
            //得到根元素
            Element root = doc.getRootElement();
            //通过根元素创建新元素
            Element userEle = root.addElement("user");
            //为userEle设置属性
            userEle.addAttribute("username",user.getUsername());
            userEle.addAttribute("password",user.getPassword());

            //创建输出格式
            OutputFormat format = new OutputFormat("\t",true);//缩进使用\t，是否换行，选择是
            format.setTrimText(true);//清空原有换行缩进

            //创建xmlWriter
            XMLWriter writer;
            try {
                writer = new XMLWriter(
                    new OutputStreamWriter(
                        new FileOutputStream(path),"UTF-8"),format);
                writer.write(doc);
                writer.close();
            } catch (Exception e) {
                throw new RuntimeException();
            }



        } catch (DocumentException e) {
            throw new RuntimeException();
        }
    }
}
