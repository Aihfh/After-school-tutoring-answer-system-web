package Util;
import com.bean.Message;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.bean.Message;
import com.bean.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Connection.*;
import com.bean.TAnswer;

public class DBAnswerUtil {
        public static List<TAnswer> getAllAnswerInfo() {
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            List<TAnswer> tAnswers = new ArrayList<TAnswer>();
            try {
                con = DBcon.getConnection();
                String sql = "SELECT * FROM answerq";
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    int Mid = rs.getInt("MessageId");
                    String Ddate = rs.getString("Adate");
                    String picture = rs.getString("Apicture");
                    String Acontent = rs.getString("Acontent");
                    String Teacherid = rs.getString("Teacherid");
                    String Atype = rs.getString("Atype");
                    String Tname = rs.getString("Tname");
                    TAnswer tAnswer=new TAnswer(Mid,picture,Acontent,Ddate,Teacherid,Atype,Tname);
                    tAnswers.add(tAnswer);
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
            return tAnswers;
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
        public static  List<TAnswer> getAnswerbymesid(int mid){
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            List<TAnswer> tAnswers = new ArrayList<TAnswer>();
            try {
                con = DBcon.getConnection();
                String sql = "SELECT * FROM answerq where MessageId = ?";
                ps = con.prepareStatement(sql);
                ps.setInt(1,mid);
                rs = ps.executeQuery();
                while (rs.next()){
                    int Mid = rs.getInt("MessageId");
                    String Ddate = rs.getString("Adate");
                    String picture = rs.getString("Apicture");
                    String Acontent = rs.getString("Acontent");
                    String Teacherid = rs.getString("Teacherid");
                    String Atype = rs.getString("Atype");
                    String Tname = rs.getString("Tname");
                    TAnswer tAnswer=new TAnswer(Mid,picture,Acontent,Ddate,Teacherid,Atype,Tname);
                    tAnswers.add(tAnswer);
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
            return tAnswers;
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
                    Message message = new Message(Mid,Ddate,Nname,Ttitle,Ccontext,Class);
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
    public static  String getTeaidByMid(int Mid){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String tid=null;
        try {
            con = DBcon.getConnection();
            String sql = "SELECT Teacherid FROM answerq where MessageId =?";
            ps = con.prepareStatement(sql);
            ps.setInt(1,Mid);
            rs = ps.executeQuery();
            while (rs.next()){
                tid = rs.getString("Teacherid");
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
        return tid;
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
        public static  List<TAnswer> getAnswerInfoByUname(String Uname){
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            List<TAnswer> tAnswers = new ArrayList<TAnswer>();
            try {
                con = DBcon.getConnection();
                String sql = "SELECT * FROM answerq where Tname=?";
                ps = con.prepareStatement(sql);
                ps.setNString(1,Uname);
                rs = ps.executeQuery();
                while (rs.next()){
                    int Mid = rs.getInt("MessageId");
                    String Ddate = rs.getString("Adate");
                    String picture = rs.getString("Apicture");
                    String Acontent = rs.getString("Acontent");
                    String Teacherid = rs.getString("Teacherid");
                    String Atype = rs.getString("Atype");
                    String Tname = rs.getString("Tname");
                    TAnswer tAnswer=new TAnswer(Mid,picture,Acontent,Ddate,Teacherid,Atype,Tname);
                    tAnswers.add(tAnswer);
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
            return tAnswers;
        }
        public static  TAnswer getAnswerInfonly1id(int id){
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            TAnswer tAnswer = new TAnswer();
            try {
                con = DBcon.getConnection();
                String sql = "SELECT * FROM answerq where MessageId=?";
                ps = con.prepareStatement(sql);
                ps.setInt(1,id);
                rs = ps.executeQuery();
                while (rs.next()) {
                    int Mid = rs.getInt("MessageId");
                    String Ddate = rs.getString("Adate");
                    String picture = rs.getString("Apicture");
                    String Acontent = rs.getString("Acontent");
                    String Teacherid = rs.getString("Teacherid");
                    String Atype = rs.getString("Atype");
                    String Tname = rs.getString("Tname");
                    tAnswer=new TAnswer(Mid,picture,Acontent,Ddate,Teacherid,Atype,Tname);
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
            return tAnswer;
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
        public static void insertAnswerInfo(TAnswer tAnswer){
            Connection con = null;
            PreparedStatement ps = null;
            try {
                con= DBcon.getConnection();

                String sql = "INSERT INTO answerq(MessageId,Apicture,Acontent,Adate,Teacherid,Atype,Tname) VALUES(?,?,?,?,?,?,?)";
                ps = con.prepareStatement(sql);
                ps.setInt(1,tAnswer.getMessageId());
                ps.setString(2,tAnswer.getApicture());
                ps.setString(3,tAnswer.getAcontent());
                ps.setString(4,tAnswer.getAdate());
                ps.setString(5,tAnswer.getTeacherid());
                ps.setString(6,tAnswer.getAtype());
                ps.setString(7,tAnswer.getTname());
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
        public static void deleteAnsInfobymessid(String id){
            Connection con = null;
            PreparedStatement ps = null;
            try {
                con = DBcon.getConnection();
                String sql = "DELETE FROM answerq WHERE MessageId = ?";
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
        public static void modifyAnsInfo(TAnswer tAnswer)throws SQLException{
            Connection con = null;
            PreparedStatement ps = null;
            try {
                con = DBcon.getConnection();
                String sql = "UPDATE answerq SET Apicture=?,Acontent=?,Adate=?,Teacherid=?,Tname=?,Atype=? WHERE MessageId=?";
                ps = con.prepareStatement(sql);
                ps.setString(1,tAnswer.getApicture());
                ps.setString(2,tAnswer.getAcontent());
                ps.setString(3,tAnswer.getAdate());
                ps.setString(4,tAnswer.getTeacherid());
                ps.setString(5,tAnswer.getTname());
                ps.setString(6,tAnswer.getAtype());
                ps.setInt(7,tAnswer.getMessageId());
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
