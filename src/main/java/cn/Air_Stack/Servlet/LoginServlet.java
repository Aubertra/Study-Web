package cn.Air_Stack.Servlet;

import cn.Air_Stack.BaseClass.User;
import cn.Air_Stack.DatabaseOperations.UserManage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login-servlet")
public class LoginServlet extends HttpServlet {
    private UserManage userManage = new UserManage();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//
//        // 检查请求参数是否为null
//        if (username == null || password == null) {
//            response.getWriter().println("Username or password is missing!");
//            return;
//        }
//
//        User loginUser = new User(username,password);
//
//        User user = userManage.login(loginUser);
//
//        // 检查 userManage 是否为null
//        if (userManage == null) {
//            response.getWriter().println("UserManage instance is null!");
//            return;
//        }
//
//        if (user != null) {
//            response.getWriter().println(user);
//            response.getWriter().println("Login Successful!");
//        } else {
//            response.getWriter().println("Login Failed!");
//        }

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User loginUser = new User(username,password);
        User user = userManage.login(loginUser);

        if(user == null){
            request.getRequestDispatcher("/Fail-Servlet").forward(request,response);
        }else{
            request.setAttribute("user",loginUser);
            request.getRequestDispatcher("/Success-Servlet").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
