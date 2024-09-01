package cn.Air_Stack.DatabaseOperations;

import cn.Air_Stack.BaseClass.Order;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class OrderManage {
    private final JdbcTemplate template = new JdbcTemplate(JDBC_Tool.getDataSource());

    public Order[] queryOrder(String queryVisitor_Name) {
        try{
            String sql = "select * from `order` where visitorname = ?";
            List<Order> orderList = template.query(sql, new BeanPropertyRowMapper<>(Order.class),
                    queryVisitor_Name);
            Order[] orders = orderList.toArray(new Order[0]);
            return orders;
        }catch (DataAccessException e){
            return null;
        }
    }

    public boolean deleteOrder(String deleteVisitor_Name){
        try {
            String sql = "DELETE FROM `order` WHERE Visitorname = ?";
            int rows = template.update(sql, deleteVisitor_Name);
            return rows > 0;
        } catch (DataAccessException e) {
            return false;
        }
    }

    public boolean addOrder(Order addOrder){
        try {
            String sql = "INSERT INTO `order` (visitorname, viewtype, viewtime) VALUES ( ?, ?, ?)";
            int rows = template.update(sql, addOrder.getVisitorName(),addOrder.getViewType(),addOrder.getViewtime());
            return rows > 0;
        } catch (DataAccessException e) {
            return false;
        }
    }

    public Order[] showAllOrder(){
        try {
            String sql = "select * from `order`";
            List<Order> orderList = template.query(sql, new BeanPropertyRowMapper<>(Order.class));
            return orderList.toArray(new Order[orderList.size()]);
        }catch (DataAccessException e){
            return null;
        }
    }
}
