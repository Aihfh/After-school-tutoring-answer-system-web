package Connection;

import java.sql.*;

public class DBcon {
    private static Connection con;
    private  static PreparedStatement ps;
    private static ResultSet rs;

    public static Connection getConnection(){
        try {
            Class.forName(Contants.driver);
            System.out.println(Contants.driver + "加载成功");
        }catch (ClassNotFoundException e){
            System.out.println(Contants.driver + "加载失败 -_-");
            e.printStackTrace();
        }
        try {
            con = DriverManager.getConnection(Contants.url,Contants.username,Contants.password);
            System.out.println(Contants.url + "连接成功<*_*>");
        }catch (SQLException e){
            System.out.println(Contants.url +"连接失败-_-!");
            e.printStackTrace();
        }
        return con;
    }

    public static void closeConnection(){
        if (ps !=null
        ){
            try {
                ps.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        if (rs !=null){
            try {
                rs.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        if (con !=null){
            try {
                con.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
    public static void IorDclosecon(){
        if (ps !=null){
            try {
                ps.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        if (con !=null){
            try {
                con.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
