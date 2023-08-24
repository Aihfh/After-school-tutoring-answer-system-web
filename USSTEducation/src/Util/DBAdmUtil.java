package Util;

import com.bean.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.bean.Teacher;
import com.bean.User;
import Connection.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class DBAdmUtil {

        public static int CheckAdmID(String Cname  ,String Cpassword) {
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            // User user = null;
            int flag = 0;
            try {
                con = DBcon.getConnection();
                String sql = "SELECT Cname,Cpassword FROM adm";
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    String Cnamecheck = rs.getString("Cname");
                    String Cpdcheck = rs.getString("Cpassword");
                    if (Cname.equals(Cnamecheck) && Cpassword.equals(Cpdcheck)) {
                        flag = 3;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("核验错误请检查");
            }
            return flag;
        }
        public static String isSuccess(int count) {
            if(count > 0) {
                return "操作成功！";
            }else {
                return "操作失败";
            }
        }
        public static List<Adm> getADMbyid(String Cid){
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            List<Adm> adms = new ArrayList<>();
            try {
                con = DBcon.getConnection();
                String sql = "SELECT * FROM adm where Cid = ?";
                ps = con.prepareStatement(sql);
                ps.setString(1,Cid);
                rs = ps.executeQuery();
                while (rs.next()){
                    String Cname = rs.getString("Cname");
                    String Cpassword = rs.getString("Cpassword");
                    Adm adm = new Adm(Cid,Cname,Cpassword);
                    adms.add(adm);
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
            return adms;
        }

        public static  Adm getADMOnlybyid(String T1id){
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            Adm adm =new Adm();
            try {
                con = DBcon.getConnection();
                String sql = "SELECT * FROM adm where Cid = ?";
                ps = con.prepareStatement(sql);
                ps.setString(1,T1id);
                rs = ps.executeQuery();
                while (rs.next()){
                    String Cname = rs.getString("Cname");
                    String CPassword = rs.getString("Cpassword");
                    adm = new Adm(T1id,Cname,CPassword);

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
            return adm;
        }

        public static List<Adm> getAdmInfoByCname(String Cname1){
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            List<Adm> adms = new ArrayList<>();
            List<Teacher> teachers = new ArrayList<Teacher>();
            try {
                con = DBcon.getConnection();
                String sql = "SELECT * FROM adm where Cname =?";
                ps = con.prepareStatement(sql);
                ps.setNString(1,Cname1);
                rs = ps.executeQuery();
                while (rs.next()){
                    String Cid = rs.getString("Cid");
                    String Cname2 = rs.getString("Cname");
                    String CPassword = rs.getString("Cpassword");
                    Adm adm = new Adm(Cid,Cname2,CPassword);
                    adms.add(adm);
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
            return adms;
        }
        public static void modifyADMInfo(Adm adm)throws SQLException{
            Connection con = null;
            PreparedStatement ps = null;
            try {
                con = DBcon.getConnection();
                String sql = "UPDATE adm SET Cname=?,Cpassword=? WHERE Cid=?";
                ps = con.prepareStatement(sql);
                ps.setString(1,adm.getCname());
                ps.setString(2, adm.getCpassword());
                ps.setString(3, adm.getCid());
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
    }*/


}
