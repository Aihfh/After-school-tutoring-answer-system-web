package Util;

import com.bean.Teacher;
import com.bean.User;
import Connection.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBTeacherUtil {
    public static List<Teacher> getAllTeacherInfo() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Teacher> teachers = new ArrayList<Teacher>();
        try {
            con = DBcon.getConnection();
            String sql = "SELECT * FROM teacher";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String Trid1 = rs.getString("Teacherid");
                String Tname = rs.getString("Tname");
                String TPassword = rs.getString("Tpassword");
                String Tdept = rs.getString("Tdept");
                String Tinfo = rs.getString("Tinfo");
                Teacher teacher = new Teacher(Trid1, Tname, TPassword, Tdept, Tinfo);
                teachers.add(teacher);
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
        return teachers;
    }

    public static int CheckTeacherID(String Tname, String Tpassword) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        // User user = null;
        int flag = 0;
        try {
            con = DBcon.getConnection();
            String sql = "SELECT Tname,Tpassword FROM teacher";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String Tnamecheck = rs.getString("Tname");
                String Tpdcheck = rs.getString("Tpassword");
                if (Tname.equals(Tnamecheck) && Tpassword.equals(Tpdcheck)) {
                    flag = 2;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("核验错误请检查");
        }
        return flag;
    }

    public static String isSuccess(int count) {
        if (count > 0) {
            return "操作成功！";
        } else {
            return "操作失败";
        }
    }

    public static List<Teacher> getTrbyid(String Tid) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Teacher> teachers = new ArrayList<>();
        try {
            con = DBcon.getConnection();
            String sql = "SELECT * FROM teacher where Teacherid = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, Tid);
            rs = ps.executeQuery();
            while (rs.next()) {
                String Tname = rs.getString("Tname");
                String Tpassword = rs.getString("Tpassword");
                String Tdept = rs.getString("Tdept");
                String Tinfo = rs.getString("Tinfo");
                Teacher teacher = new Teacher(Tid, Tname, Tpassword, Tdept, Tinfo);
                teachers.add(teacher);
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
        return teachers;
    }

    public static Teacher getTrOnlybyid(String T1id) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Teacher teacher = new Teacher();
        User user = new User();
        try {
            con = DBcon.getConnection();
            String sql = "SELECT * FROM teacher where Teacherid = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, T1id);
            rs = ps.executeQuery();
            while (rs.next()) {
                String Tname = rs.getString("Tname");
                String TPassword = rs.getString("Tpassword");
                String Tdept = rs.getString("Tdept");
                String Tinfo = rs.getString("Tinfo");
                teacher = new Teacher(T1id, Tname, TPassword, Tdept, Tinfo);

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
        return teacher;
    }

    public static List<Teacher> getTeacherInfoByTname(String Tn1ame) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Teacher> teachers = new ArrayList<Teacher>();
        try {
            con = DBcon.getConnection();
            String sql = "SELECT * FROM teacher where Tname =?";
            ps = con.prepareStatement(sql);
            ps.setNString(1, Tn1ame);
            rs = ps.executeQuery();
            while (rs.next()) {
                String Trid1 = rs.getString("Teacherid");
                String Tname = rs.getString("Tname");
                String TPassword = rs.getString("Tpassword");
                String Tdept = rs.getString("Tdept");
                String Tinfo = rs.getString("Tinfo");
                Teacher teacher = new Teacher(Trid1, Tname, TPassword, Tdept, Tinfo);
                teachers.add(teacher);
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
        return teachers;
    }

    public static void modifyTeacherInfo(Teacher teacher) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBcon.getConnection();
            String sql = "UPDATE teacher SET Tname=?,Tpassword=?,Tdept=?,Tinfo=? WHERE Teacherid=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, teacher.getTname());
            ps.setString(2, teacher.getTpassword());
            ps.setString(3, teacher.getTclass());
            ps.setString(4, teacher.getTinfo());
            ps.setString(5, teacher.getTeacherid());
            int count = ps.executeUpdate();
            System.out.println(isSuccess(count));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        if (con != null) {
            con.close();
        }
    }

    public static void deleteTeacherbyname(String name) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBcon.getConnection();
            String sql = "DELETE FROM teacher WHERE Tname = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            int deletecount = ps.executeUpdate();
            System.out.println(isSuccess(deletecount));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBcon.IorDclosecon();
        }
    }
    public static void insertTeacherInfo(Teacher teacher){
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con= DBcon.getConnection();
            String sql = "INSERT INTO teacher (Teacherid,Tpassword,Tdept,Tname,Tinfo) VALUES(?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1,teacher.getTeacherid());
            ps.setString(2,teacher.getTpassword());
            ps.setString(3,teacher.getTdept());
            ps.setString(4,teacher.getTname());
            ps.setString(5,teacher.getTinfo());
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
    }

