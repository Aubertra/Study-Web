package cn.Air_Stack.Servlet;

import cn.Air_Stack.BaseClass.Order;
import cn.Air_Stack.BaseClass.Visitor;
import cn.Air_Stack.DatabaseOperations.OrderManage;
import cn.Air_Stack.DatabaseOperations.VisitorManage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Visitor-Servlet")
public class VisitorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");
        String Visitorname = req.getParameter("visitorname");

        VisitorManage VisitorManage = new VisitorManage();
        OrderManage orderManage = new OrderManage();

        boolean result = false;
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter out = resp.getWriter();

        switch (type){
            case "visit_query":
                Visitor Visitor = VisitorManage.queryVisitor(Visitorname);
                if (Visitor != null) {
                    out.print( "visitorname: " + Visitor.getVisitorname()+  "<br>"  + "viewnumber: " + Visitor.getViewnumber()+  "<br>"  + "viewtype: " + Visitor.getViewtype());
                } else {
                    out.print("无此访客");
                }
                return;
            case "order_query":
                Order[] orders =orderManage.queryOrder(Visitorname);
                if (orders != null){
                    for (int i=0;i<orders.length;i++)  {
                        out.print("id:"+orders[i].getId() + "<br>" + "visitorname: " + orders[i].getVisitorName() + "<br>" + "viewtype: " + orders[i].getViewType() + "<br>" + "viewtime: " + orders[i].getViewtime());
                        out.println("<br>--------------------------------------------------------<br>" );
                    }
                }else{
                    out.println("无此顾客订单");
                }
                return;
            default:
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
