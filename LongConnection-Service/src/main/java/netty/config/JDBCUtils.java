package netty.config;

import netty.util.PropertyUtil;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * JDBC工具类
 * 用于获取数据库链接和关闭相应资源
 *
 * @author 陈旭东
 */
public class JDBCUtils {

    //mysql 相关信息
    public static final String DRIVER_CLASS_NAME = PropertyUtil.getProperty("DRIVER_CLASS_NAME").trim(); //com.mysql.cj.jdbc.Driver;
    public static final String MYSQL_URL = PropertyUtil.getProperty("MYSQL_URL").trim(); //"jdbc:mysql://172.30.1.246:3306/bben_medical?useUnicode=true&useSSL=false&autoReconnect=true&characterEncoding=UTF-8";   //mysql地址
    public static final String USERNAME = PropertyUtil.getProperty("USERNAME").trim(); //"root";         //mysql用户名
    public static final String PASSWORD = PropertyUtil.getProperty("PASSWORD").trim(); //"123456";       //mysql密码
    
    /**
     * 建立并返回链接
     *
     * @return 数据库链接
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static Connection getConnection() throws ClassNotFoundException,
            SQLException {
        // 加载驱动
        loadDriver();
        // 返回数据库链接
        return DriverManager.getConnection(MYSQL_URL, USERNAME, PASSWORD);
    }

    // 装载驱动
    private static void loadDriver() throws ClassNotFoundException {
        // 利用反射，避免二次加载驱动
        Class.forName(DRIVER_CLASS_NAME);
    }

    /**
     * 释放资源
     *
     * @param rs   需要关闭的ResultSet
     * @param stmt 需要关闭的Statement
     * @param conn 需要关闭的Connection
     */
    public static void release(ResultSet rs, Statement stmt, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            rs = null;
        }

        release(stmt, conn);
    }

    /**
     * 释放资源
     *
     * @param stmt 需要关闭的Statement
     * @param conn 需要关闭的Connection
     */
    public static void release(Statement stmt, Connection conn) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            stmt = null;
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            conn = null;
        }
    }
}
