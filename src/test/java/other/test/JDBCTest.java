package other.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by yanan on 16/11/28.
 */
public class JDBCTest {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/yanld?characterEncoding=utf8&useSSL=false", "root", "8371593");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM yanld_user");
        while (rs.next()) {
            String name = rs.getString("name");
            String pwd = rs.getString("password");
        }
//        conn.close();
//        ResultSet rs1 = stmt.executeQuery("SELECT * FROM yanld_user");
//        int a = 1;
    }
}
