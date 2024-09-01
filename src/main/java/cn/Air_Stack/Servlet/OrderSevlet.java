package cn.Air_Stack.Servlet;

import cn.Air_Stack.BaseClass.Order;
import cn.Air_Stack.DatabaseOperations.OrderManage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

@WebServlet("/Order-Servlet")
public class OrderSevlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");

        if(Objects.equals(type, "Summary")){
            OrderManage orderManage = new OrderManage();
            resp.setContentType("text/html; charset=utf-8");
            PrintWriter out = resp.getWriter();
            Order[] orders = orderManage.showAllOrder();
            if (orders != null){
                for (int i=0;i<orders.length;i++)  {
                    out.print("id:"+orders[i].getId() + "<br>" + "visitorname: " + orders[i].getVisitorName() + "<br>" + "viewtype: " + orders[i].getViewType() + "<br>" + "viewtime: " + orders[i].getViewtime());
                    out.println("<br>--------------------------------------------------------<br>" );
                }
            }else{
                out.println("无订单");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
