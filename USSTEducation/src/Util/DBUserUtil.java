package Util;

import com.bean.Message;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.bean.User;
import Connection.*;
public class DBUserUtil {
    public static List<User> getAllUserInfo() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<User> user = new ArrayList<User>();
        try {
            con = DBcon.getConnection();
            String sql = "SELECT * FROM user";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String Userid = rs.getString("Userid");
                String Uname = rs.getString("Uname");
                String Upassword = rs.getString("Upassword");
                String Tname = rs.getString("Truename");
                User user1 = new User(Userid,Uname,Upassword,Tname);
                user.add(user1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return user;
    }
    public static int CheckuserID(String Uname,String Upassword) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
       // User user = null;
        int flag = 0;
        try {
            con = DBcon.getConnection();
            String sql = "SELECT Uname,Upassword FROM user";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String Unamecheck = rs.getString("Uname");
                String Updcheck = rs.getString("Upassword");
                if (Uname.equals(Unamecheck) && Upassword.equals(Updcheck)) {
                    flag = 1;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("核验错误请检查");
        }
        return flag;
    }
    public static User get2UserInfoByName(String Userid){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;
        try {
            con = DBcon.getConnection();
            String sql = "SELECT * FROM user where Userid =?";
            ps = con.prepareStatement(sql);
            ps.setNString(1,Userid);
            rs = ps.executeQuery();
            while (rs.next()){
                String Userid1 = rs.getString("Userid");
                String Uname = rs.getString("Uname");
                String Upassword = rs.getString("Upassword");
                String Tname = rs.getString("Truename");
                user = new User(Userid1,Uname,Upassword,Tname);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (rs !=null){
                try {
                    rs.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
            if (ps !=null){
                try {
                    ps.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
            if (con != null){
                try {
                    con.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
        return user;
    }
    public static List<User> getUserInfoByName(String uname){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<User> user1 = new ArrayList<User>();
        try {
            con = DBcon.getConnection();
            String sql = "SELECT * FROM user where Uname =?";
            ps = con.prepareStatement(sql);
            ps.setNString(1,uname);
            rs = ps.executeQuery();
            while (rs.next()){
                String Userid1 = rs.getString("Userid");
                String Uname = rs.getString("Uname");
                String Password = rs.getString("Upassword");
                String Tname = rs.getString("Truename");
                User user = new User(Userid1,Uname,Password,Tname);
                user1.add(user);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (rs !=null){
                try {
                    rs.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
            if (ps !=null){
                try {
                    ps.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
            if (con != null){
                try {
                    con.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
        return user1;
    }
    public static String isSuccess(int count) {
        if(count > 0) {
            return "操作成功！";
        }else {
            return "操作失败";
        }
    }
    public static void insertUserInfo(User user){
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con= DBcon.getConnection();

            String sql = "INSERT INTO user (Userid,Uname,Upassword,Truename) VALUES(?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1,user.getUserid());
            ps.setString(2,user.getUName());
            ps.setString(3,user.getUPassword());
            ps.setString(4,user.getTruename());
            int inserCount = ps.executeUpdate();
            System.out.println(isSuccess(inserCount));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
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
    public static  List<User> getUserbyid(String user1id){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<User> users = new ArrayList<>();
        try {
            con = DBcon.getConnection();
            String sql = "SELECT * FROM user where Userid = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1,user1id);
            rs = ps.executeQuery();
            while (rs.next()){
                String Uname = rs.getString("Uname");
                String Upassword = rs.getString("Upassword");
                String Turename = rs.getString("Truename");
                User user = new User(user1id,Uname,Upassword,Turename);
                users.add(user);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (rs !=null){
                try {
                    rs.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
            if (ps !=null){
                try {
                    ps.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
            if (con != null){
                try {
                    con.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
        return users;
    }
    public static  User getUserOnlybyid(String user1id){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user =new User();
        try {
            con = DBcon.getConnection();
            String sql = "SELECT * FROM user where Userid = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1,user1id);
            rs = ps.executeQuery();
            while (rs.next()){
                String Uname = rs.getString("Uname");
                String Upassword = rs.getString("Upassword");
                String Turename = rs.getString("Truename");
                user = new User(user1id,Uname,Upassword,Turename);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (rs !=null){
                try {
                    rs.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
            if (ps !=null){
                try {
                    ps.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
            if (con != null){
                try {
                    con.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
        return user;
    }
    public static void modifyUserInfo(User user)throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBcon.getConnection();
            String sql = "UPDATE user SET Uname=?,Upassword=?,Truename=? WHERE Userid=?";
            ps = con.prepareStatement(sql);
            ps.setString(1,user.getUName());
            ps.setString(2,user.getUPassword());
            ps.setString(3,user.getTruename());
            ps.setString(4,user.getUserid());
            int count = ps.executeUpdate();
            System.out.println(isSuccess(count));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (ps !=null){
                try {
                    ps.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
        if (con !=null){
            con.close();
        }
    }
 /*
    public static void modifyMesInfo(Message mes)throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBcon.getConnection();
            String sql = "UPDATE message SET date=?,name=?,context=? WHERE title=?";
            ps = con.prepareStatement(sql);
            ps.setString(1,mes.getDdate());
            ps.setString(2,mes.getNname());
            ps.setString(3,mes.getCcontext());
            ps.setString(4,mes.getTtitle());
            int count = ps.executeUpdate();
            System.out.println(isSuccess(count));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (ps !=null){
                try {
                    ps.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
        if (con !=null){
            con.close();
        }
    }*/
}
