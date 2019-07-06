package com.example.demo.Service;



import com.example.demo.Dao.UserDao;
import com.example.demo.Entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import java.io.IOException;
import java.util.List;

/**
 * @author xinYing
 * @date 2019/7/4 22:15
 */
@RestController
public class UserServlet  extends HttpServlet {
    /**
     * 查询user表的数据
     */
    @RequestMapping("/UserAll")
    public void userAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> userAll =  UserDao.getUserAll();
        request.setAttribute("list",userAll);
        request.getRequestDispatcher("WEB-INF/jsp/userAll.jsp").forward(request,response);
    }
    /**
     * ID单个删除
     */
    @RequestMapping("/deleteUserId")
    public void deleteUserId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String str = request.getParameter("id");
        if(str!=null){
            int id = Integer.parseInt(str);
            int len = UserDao.deleteId(id);
            if(len==1){
                String path = "/UserServlet";
                response.sendRedirect(path);
            }else{
                request.setAttribute("message","删除失败");
                request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request,response);
            }
        }
    }
    /**
     * 新增
     */
    public void UserAdd(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        try {
            @Size(min = 3,max = 15,message = "账号范围为3-15")
            Long account = Long.parseLong(request.getParameter("account"));
            String password = request.getParameter("password");
            String username = request.getParameter("username");
            int len = UserDao.insertUser(new User(null, account, password, username, 0, null, null));
            if(len==1){

            }
        }catch(Exception e){
            e.printStackTrace();

        }

    }
}
