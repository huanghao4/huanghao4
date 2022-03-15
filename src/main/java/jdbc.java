import java.sql.*;
public class jdbc {
    public static Connection dbConn;
    public void test(){
        String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=userdb";

        String userName="huanghao";
        String userPwd="123456";

        try
        {
            Class.forName(driverName);
            dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
            System.out.println("连接数据库成功");
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.print("连接失败");
        }
    }
    public static void main(String [] args)
    {
        new jdbc().test();
    }
}
