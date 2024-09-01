package cn.Air_Stack.Servlet;

import cn.Air_Stack.BaseClass.Goods;
import cn.Air_Stack.DatabaseOperations.GoodsManage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Goods-Servlet")
public class GoodsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");
        String goodsname = req.getParameter("goodsname");

        GoodsManage goodsManage = new GoodsManage();
        boolean result = false;
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter out = resp.getWriter();

        switch (type){
            case "query":
                Goods goods = goodsManage.queryGoods(goodsname);
                if (goods != null) {
                    out.print( "goodsname: " + goods.getGoodsName()+  "<br>"  + "goodsview: " + goods.getGoodsview());
                } else {
                    out.print("无此商品");
                }
                return;
            case "add":
                result = goodsManage.addGoods(goodsname);
                if(result){out.print("操作成功");}
                else{out.print("操作失败");}
                return;
            case "delete":
                result = goodsManage.deleteGoods(goodsname);
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
