package cn.Air_Stack.DatabaseOperations;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.util.JdbcUtils;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JDBC_Tool {
    private static DataSource ds;

    static {
        try  {
            Properties properties = new Properties();
            try(InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("config.properties")){
                properties.load(inputStream);
            }
            ds = DruidDataSourceFactory.createDataSource(properties);
        }catch (IOException e){
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static DataSource getDataSource(){
        return ds;
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
