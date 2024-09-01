package cn.Air_Stack.DatabaseOperations;

import cn.Air_Stack.BaseClass.Visitor;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class VisitorManage {
    private final JdbcTemplate template = new JdbcTemplate(JDBC_Tool.getDataSource());

    public Visitor queryVisitor(String queryVisitor_Name) {
        try{
            String sql = "select * from Visitor where Visitorname = ?";
            Visitor visitor = template.queryForObject(sql,
                    new BeanPropertyRowMapper<Visitor>(Visitor.class),
                    queryVisitor_Name);
            return visitor;
        }catch (DataAccessException e){
            return null;
        }
    }

    public boolean deleteVisitor(String deleteVisitor_Name){
        try {
            String sql = "DELETE FROM Visitor WHERE Visitorname = ?";
            int rows = template.update(sql, deleteVisitor_Name);
            return rows > 0;
        } catch (DataAccessException e) {
            return false;
        }
    }

    public boolean addVisitor(String addVisitor_Name){
        try {
            String sql = "INSERT INTO Visitor (Visitorname, viewnumber, viewtype) VALUES (?, 0, ?)";
            int rows = template.update(sql, addVisitor_Name,"NULL");
            return rows > 0;
        } catch (DataAccessException e) {
            return false;
        }
    }
}
