package Util;

import com.bean.Message;
import com.bean.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Connection.*;
public class DBmeUtil {
    public static List<Message> getAllMessageInfo() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Message> mes = new ArrayList<Message>();
        try {
            con = DBcon.getConnection();
            String sql = "SELECT * FROM message";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int Mid = rs.getInt("MessageId");
                String Ddate = rs.getString("date");
                String Nname = rs.getString("name");
                String Ttitle = rs.getString("title");
                String Ccontext = rs.getString("context");
                String Cclasstype = rs.getString("classtype");
                Message message = new Message(Mid,Ttitle,Nname,Ddate,Ccontext,Cclasstype);
                mes.add(message);
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
        return mes;
    }

    public static int getMaxMessageId() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Message> mes = new ArrayList<Message>();
        int Mid = 0;
        try {
            con = DBcon.getConnection();
            String sql = "SELECT MAX(MessageId) FROM message";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                Mid = rs.getInt("MAX(MessageId)");
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
        return Mid + 1;
    }
    public static  List<Message> getMessagelikeClass(String Classtype){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Message> mes = new ArrayList<Message>();
        try {
            con = DBcon.getConnection();
            String sql = "SELECT * FROM message where classtype like ?";
            ps = con.prepareStatement(sql);
            ps.setNString(1,"%"+Classtype+"%");
            rs = ps.executeQuery();
            while (rs.next()){
                int Mid = rs.getInt("MessageId");
                String Ddate = rs.getString("date");
                String Nname = rs.getString("name");
                String Ttitle = rs.getString("title");
                String Ccontext = rs.getString("context");
                String Class = rs.getString("classtype");
                Message message = new Message(Mid,Ttitle,Nname,Ddate,Ccontext,Class);
                mes.add(message);
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
        return mes;
    }
    public static  List<Message> getMessagebyid(int mid){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Message> mes = new ArrayList<Message>();
        try {
            con = DBcon.getConnection();
            String sql = "SELECT * FROM message where MessageId = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1,mid);
            rs = ps.executeQuery();
            while (rs.next()){
                int Mid = rs.getInt("MessageId");
                String Ddate = rs.getString("date");
                String Nname = rs.getString("name");
                String Ttitle = rs.getString("title");
                String Ccontext = rs.getString("context");
                String Class = rs.getString("classtype");
                Message message = new Message(Mid,Ttitle,Nname,Ddate,Ccontext,Class);
                mes.add(message);
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
        return mes;
    }
    public static  List<Message> getMessagelikeTitle(String Title){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Message> mes = new ArrayList<Message>();
        try {
            con = DBcon.getConnection();
            String sql = "SELECT * FROM message where title like ?";
            ps = con.prepareStatement(sql);
            ps.setNString(1,"%"+Title+"%");
            rs = ps.executeQuery();
            while (rs.next()){
                int Mid = rs.getInt("MessageId");
                String Ddate = rs.getString("date");
                String Nname = rs.getString("name");
                String Ttitle = rs.getString("title");
                String Ccontext = rs.getString("context");
                String Class = rs.getString("classtype");
                Message message = new Message(Mid,Ttitle,Nname,Ddate,Ccontext,Class);
                mes.add(message);
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
        return mes;
    }
    public static  List<Message> getMessagelike(String lclass,String lname,String ltitle){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Message> mes = new ArrayList<Message>();
        try {
            con = DBcon.getConnection();
            String sql = "SELECT * FROM message where classtype like ? and name like ? and title like ?";
            ps = con.prepareStatement(sql);
            ps.setNString(1,"%"+lclass+"%");
            ps.setNString(2,"%"+lname+"%");
            ps.setNString(3,"%"+ltitle+"%");
            rs = ps.executeQuery();
            while (rs.next()){
                int Mid = rs.getInt("MessageId");
                String Ddate = rs.getString("date");
                String Nname = rs.getString("name");
                String Ttitle = rs.getString("title");
                String Ccontext = rs.getString("context");
                String Class = rs.getString("classtype");
                Message message = new Message(Mid,Ttitle,Nname,Ddate,Ccontext,Class);
                mes.add(message);
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
        return mes;
    }
    public static  List<Message> getMessageInfoByClass(String Classtype){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Message> mes = new ArrayList<Message>();
        try {
            con = DBcon.getConnection();
            String sql = "SELECT * FROM message where classtype =?";
            ps = con.prepareStatement(sql);
            ps.setNString(1,Classtype);
            rs = ps.executeQuery();
            while (rs.next()){
                int Mid = rs.getInt("MessageId");
                String Ddate = rs.getString("date");
                String Nname = rs.getString("name");
                String Ttitle = rs.getString("title");
                String Ccontext = rs.getString("context");
                String Class = rs.getString("classtype");
                    Message message = new Message(Mid,Ttitle,Nname,Ddate,Ccontext,Class);
                    mes.add(message);
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
        return mes;
    }
    public static  List<Message> getMessageInfoByUname(String Uname){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Message> mes = new ArrayList<Message>();
        try {
            con = DBcon.getConnection();
            String sql = "SELECT * FROM message where name=?";
            ps = con.prepareStatement(sql);
            ps.setNString(1,Uname);
            rs = ps.executeQuery();
            while (rs.next()){
                int Mid = rs.getInt("MessageId");
                String Ddate = rs.getString("date");
                String Nname = rs.getString("name");
                String Ttitle = rs.getString("title");
                String Ccontext = rs.getString("context");
                String Class = rs.getString("classtype");
                Message message = new Message(Mid,Ttitle,Nname,Ddate,Ccontext,Class);
                mes.add(message);
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
        return mes;
    }
    public static  Message getMessageInfonly1id(int id){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Message message=new Message();
        try {
            con = DBcon.getConnection();
            String sql = "SELECT * FROM message where MessageId=?";
            ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while (rs.next()) {
                int Mid = rs.getInt("MessageId");
                String Ddate = rs.getString("date");
                String Nname = rs.getString("name");
                String Ttitle = rs.getString("title");
                String Ccontext = rs.getString("context");
                String Class = rs.getString("classtype");
                message = new Message(Mid, Ttitle, Nname, Ddate, Ccontext, Class);
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
        return message;
    }
    public static String isSuccess(int count) {
        if(count > 0) {
            return "操作成功！";
        }else {
            return "操作失败";
        }
    }
    public static void Insertmesbyclass(Message mes,String CClass){
        Connection con = null;
        PreparedStatement ps = null;
        int Mid=0;
        try {
            con=DBcon.getConnection();
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
            con=DBcon.getConnection();

            String sql = "INSERT INTO message(MessageId,title,name,date,context,classtype) VALUES(?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setInt(1,mes.getMessageId());
            ps.setString(2, mes.getTtitle());
            ps.setString(3,mes.getNname());
            ps.setString(4,mes.getDdate() );
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
            con =DBcon.getConnection();
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
    public static void deleteMesInfobymessid(String id){
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con =DBcon.getConnection();
            String sql = "DELETE FROM message WHERE MessageId = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1,id);
            int deletecount = ps.executeUpdate();
            System.out.println(isSuccess(deletecount));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBcon.IorDclosecon();
        }
        //修改信息
    }
    public static void modifyMesInfo(Message mes)throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBcon.getConnection();
            String sql = "UPDATE message SET title=?,name=?,date=?,context=?,classtype=? WHERE MessageId=?";
            ps = con.prepareStatement(sql);
            ps.setString(1,mes.getTtitle());
            ps.setString(2,mes.getNname());
            ps.setString(3,mes.getDdate());
            ps.setString(4,mes.getCcontext());
            ps.setString(5,mes.getClasstype());
            ps.setInt(6,mes.getMessageId());
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
    /*public static void modifyMesInfoList(List<Message> mes)throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        List<Message> messages= mes;
        try {
            con = DBcon.getConnection();
            String sql = "UPDATE message SET title=?,name=?,date=?,context=?,classtype=? WHERE MessageId=?";
            ps = con.prepareStatement(sql);
            ps.setString(1,mes.getTtitle());
            ps.setString(2,mes.getNname());
            ps.setString(3,mes.getDdate());
            ps.setString(4,mes.getCcontext());
            ps.setString(5,mes.getClasstype());
            ps.setInt(6,mes.getMessageId());
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
