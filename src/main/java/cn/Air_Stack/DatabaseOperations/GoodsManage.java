package cn.Air_Stack.DatabaseOperations;

import cn.Air_Stack.BaseClass.Goods;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class GoodsManage {
    private final JdbcTemplate template = new JdbcTemplate(JDBC_Tool.getDataSource());

    public Goods queryGoods(String queryGoods_Name) {
        try{
            String sql = "select * from goods where goodsname = ?";
            Goods goods = template.queryForObject(sql,
                    new BeanPropertyRowMapper<Goods>(Goods.class),
                    queryGoods_Name);
            return goods;
        }catch (DataAccessException e){
            return null;
        }
    }

    public boolean deleteGoods(String deleteGoods_Name){
        try {
            String sql = "DELETE FROM goods WHERE goodsname = ?";
            int rows = template.update(sql, deleteGoods_Name);
            return rows > 0;
        } catch (DataAccessException e) {
            return false;
        }
    }

    public boolean addGoods(String addGoods_Name){
        try {
            String sql = "INSERT INTO goods (goodsname, goodsview) VALUES (?, ?)";
            int rows = template.update(sql, addGoods_Name,0);
            return rows > 0;
        } catch (DataAccessException e) {
            return false;
        }
    }
}
