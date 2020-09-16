package dbForLry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtils {

    // 可以把几个字符串定义成常量：用户名，密码，URL，驱动类
    private static final String USER = "sqtp_456";
    private static final String PWD = "sqtp123456";
    private static final String URL = "jdbc:mysql://rm-bp1tymfixa12tydv42o.mysql.rds.aliyuncs.com:3306/sqtp_one?useUnicode=true&characterEncoding=utf8&autoReconnect=true&failOverReadOnly=false&tcpRcvBuf=1024000";
    private static final String DRIVER = "com.mysql.jdbc.Driver";

    /**
     * 注册驱动(可以省略)
     */
    static {
        try {
            Class.forName(DRIVER); }
        catch (ClassNotFoundException e) { e.printStackTrace(); }
    }

    /**
     * 得到数据库的连接
     */
    public static Connection getConnection() throws SQLException {
        System.out.println("获取连接.");
        try {
            return DriverManager.getConnection(URL, USER, PWD);
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException(e);
        }

    }


    /**
     * 关闭所有打开的资源
     */
    public static void close(Connection conn, Statement stmt){
        if(stmt != null) {
            try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
        if(conn != null) {
            try { conn.close(); }catch (SQLException e) { e.printStackTrace(); }
        }

    }

    /**
     * 关闭所有打开的资源 重载
     */
    public static void close(Connection conn, Statement stmt, ResultSet rs) {
        if(rs != null) {
            try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
        }

        close(conn, stmt);
    }

    public static void main(String[] args) throws Exception {
        Connection con = JDBCUtils.getConnection();
        if (!con.isClosed())
            System.out.println("Succeeded connecting to the Database!");

        Statement statement = con.createStatement();

        String sql = "select * from workers";

        ResultSet rs = statement.executeQuery(sql);
        System.out.println("-------");
        System.out.println("执行结果如下所示：");
        System.out.println("--------");
        System.out.println("姓名" + "\t" + "账号" + "\t" + "密码");
        System.out.println("--------");

        String name = null;
        String id = null;
        String keypass = null;
        while (rs.next()) {
            name = rs.getString("w_name");
            id = rs.getString("w_id");
            keypass = rs.getString("w_password");

            System.out.println(name + "\t" + id + "\t" + keypass);
        }
        rs.close();
        con.close();
        JDBCUtils.close(con, statement, rs);
    }
}
