package cn.Air_Stack.Servlet;

import cn.Air_Stack.BaseClass.User;
import cn.Air_Stack.DatabaseOperations.UserManage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Member-Servlet")
public class MemberServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");
        String username = req.getParameter("username");

        UserManage userManage = new UserManage();
        boolean result = false;
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter out = resp.getWriter();

        switch (type){
            case "query":
                User user =userManage.queryUser(username);
                if (user != null) {
                    out.print( "username: " + user.getUserName() +  "<br>"  + "password: " + user.getPassWord());
                } else {
                    out.print("无此用户");
                }
                return;
            case "add":
                result = userManage.addUser(username);
                if(result){out.print("操作成功");}
                else{out.print("操作失败");}
                return;
            case "delete":
                result = userManage.deleteUser(username);
                if(result){out.print("操作成功");}
                else{out.print("操作失败");}
                return;
            default:
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
