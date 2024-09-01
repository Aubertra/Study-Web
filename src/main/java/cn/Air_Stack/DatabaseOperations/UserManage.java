package cn.Air_Stack.DatabaseOperations;

import cn.Air_Stack.BaseClass.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserManage {

    private final JdbcTemplate template = new JdbcTemplate(JDBC_Tool.getDataSource());
    public User login(User loginUser) {
        try{
            String sql = "select * from user where username = ? and password = ?";
            User user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUserName(),loginUser.getPassWord());
            return user;
        }catch (DataAccessException e){
            return null;
        }
    }

    public User queryUser(String queryUser_Name) {
        try{
            String sql = "select * from user where username = ?";
            User user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    queryUser_Name);
            return user;
        }catch (DataAccessException e){
            return null;
        }
    }

    public boolean deleteUser(String deleteUser_Name){
        try {
            String sql = "DELETE FROM user WHERE username = ?";
            int rows = template.update(sql, deleteUser_Name);
            return rows > 0;
        } catch (DataAccessException e) {
            return false;
        }
    }

    public boolean addUser(String addUser_Name){
        try {
            String sql = "INSERT INTO user (username, password) VALUES (?, ?)";
            int rows = template.update(sql, addUser_Name, "password");
            return rows > 0;
        } catch (DataAccessException e) {
            return false;
        }
    }
}
