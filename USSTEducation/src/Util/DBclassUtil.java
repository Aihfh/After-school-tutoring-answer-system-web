package Util;

import com.bean.Ccclass;
import com.bean.Message;
import Connection.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBclassUtil {
    public static List<Ccclass> getAllclassInfo() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Ccclass> Cclass = new ArrayList<Ccclass>();
        try {
            con = DBcon.getConnection();
            String sql = "SELECT * FROM tc";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String Tid = rs.getString("Teacherid");
                String Tname = rs.getString("Tname");
                String Tclass = rs.getString("Tclass");
                Ccclass ccs = new Ccclass(Tid,Tname,Tclass);
                Cclass.add(ccs);
            }
        }catch (Exception e) {
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
        return Cclass;
    }

    public static List<Ccclass> getClassInfoByName(String tname){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Ccclass> ccs = new ArrayList<Ccclass>();
        try {
            con = DBcon.getConnection();
            String sql = "SELECT * FROM tc where Tname =?";
            ps = con.prepareStatement(sql);
            ps.setNString(1,tname);
            rs = ps.executeQuery();
            while (rs.next()){
                String tid = rs.getString("Teacherid");
                String subject = rs.getString("Tclass");

                Ccclass c1 = new Ccclass(tid,tname,subject);
                ccs.add(c1);
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
        return ccs;
    }
    public static String isSuccess(int count) {
        if(count > 0) {
            return "操作成功！";
        }else {
            return "操作失败";
        }
    }
    public static void insertClassInfo(Ccclass ccclass){
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con= DBcon.getConnection();

            String sql = "INSERT INTO tc(Teacherid,Tname,Tclass) VALUES(?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, ccclass.getTid());
            ps.setString(2,ccclass.getTname());
            ps.setString(3,ccclass.getCClass());
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
    public static void modifyClass(Ccclass ccclass)throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBcon.getConnection();
            String sql = "UPDATE tc SET Tname=?,Tclass=? WHERE Teacherid=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, ccclass.getTname());
            ps.setString(2, ccclass.getCClass());
            ps.setString(3, ccclass.getTid());
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
    public static void deleteClassInfobyclassname(String name){
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con =DBcon.getConnection();
            String sql = "DELETE FROM tc WHERE Tclass = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1,name);
            int deletecount = ps.executeUpdate();
            System.out.println(isSuccess(deletecount));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBcon.IorDclosecon();
        }
        //修改信息
    }
    /*
    public static void Insertmesbyclass(Message mes,String CClass){
        Connection con = null;
        PreparedStatement ps = null;
        int Mid=0;
        try {
            con= DBcon.getConnection();
            String sql = "INSERT INTO message(Mid,date,name,title,context,class) VALUES(?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            Mid=getMaxMessageId();
            ps.setInt(1,Mid);
            ps.setString(2, mes.getDdate());
            ps.setString(3,mes.getNname());
            ps.setString(4, mes.getTtitle());
            ps.setString(5, mes.getCcontext());
            ps.setString(6, CClass);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("按课程插入信息错误");
        }finally {if (ps !=null){
            try {
                ps.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
            if (con !=null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    public static void insertMesInfo(Message mes){
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con= DBcon.getConnection();

            String sql = "INSERT INTO message(Mid,date,name,title,context,class) VALUES(?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setInt(1,mes.getMessageId());
            ps.setString(2, mes.getDdate());
            ps.setString(3,mes.getNname());
            ps.setString(4, mes.getTtitle());
            ps.setString(5, mes.getCcontext());
            ps.setString(6, mes.getClasstype());
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
    public static void deleteMesInfo(String Ttitle){
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBcon.getConnection();
            String sql = "DELETE FROM message WHERE title = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1,Ttitle);
            int deletecount = ps.executeUpdate();
            System.out.println(isSuccess(deletecount));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBcon.IorDclosecon();
        }
        //修改信息
    }

    public static void modifyMesInfo(Message mes)throws SQLException {
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
