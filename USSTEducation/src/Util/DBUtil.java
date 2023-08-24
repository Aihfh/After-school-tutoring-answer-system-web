package Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Connection.DBcon;
import com.bean.Student;

public class DBUtil {
    public static List<Student> getAllStudentInfo() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Student> stu = new ArrayList<Student>();
        try {
            con = DBcon.getConnection();
            String sql = "SELECT * FROM student";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String Sno1 = rs.getString("Sno");
                String Sname = rs.getString("Sname");
                String Sex = rs.getString("Sex");
                int Age = rs.getInt("Age");
                String Dept = rs.getString("Dept");
                String nat = rs.getString("native");
                Student st = new Student(Sno1, Sname, Sex, Age, Dept, nat);
                stu.add(st);
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
        return stu;
    }
    public static Student getStudentInfoBySno(String Sno){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Student stu = null;
        try {
            con = DBcon.getConnection();
            String sql = "SELECT * FROM student where Sno=?";
            ps = con.prepareStatement(sql);
            ps.setNString(1,Sno);
            rs = ps.executeQuery();
            while (rs.next()){
                String Sno1 = rs.getString("Sno");
                String Sname = rs.getString("Sname");
                String Sex = rs.getString("Sex");
                int Age = rs.getInt("Age");
                String Dept = rs.getString("Dept");
                String nat = rs.getString("native");
                stu = new Student(Sno1,Sname,Sex,Age,Dept,nat);
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
        return stu;
    }
    public static String isSuccess(int count) {
        if(count > 0) {
            return "操作成功！";
        }else {
            return "操作失败";
        }
    }
    public static void insertStuInfo(Student stu){
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con=DBcon.getConnection();

            String sql = "INSERT INTO student(Sno,Sname,Sex,Age,Dept,native) VALUES(?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, stu.getSno());
            ps.setString(2,stu.getSname());
            ps.setString(3, stu.getSex());
            ps.setInt(4,stu.getAge());
            ps.setString(5, stu.getDept());
            ps.setString(6,stu.getNat());
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
    //删除
    public static void deleteStuInfo(String Sno){
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con =DBcon.getConnection();
            String sql = "DELETE FROM student WHERE Sno = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1,Sno);
            int deletecount = ps.executeUpdate();
            System.out.println(isSuccess(deletecount));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBcon.IorDclosecon();
        }
        //修改学生信息
    }

    public static void modifyStuInfo(Student stu)throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBcon.getConnection();
            String sql = "UPDATE student SET Sname=?,Sex=?,Age=?,Dept=?,native=? WHERE Sno=?";
            ps = con.prepareStatement(sql);
            ps.setString(1,stu.getSname());
            ps.setString(2,stu.getSex());
            ps.setInt(3,stu.getAge());
            ps.setString(4,stu.getDept());
            ps.setString(5,stu.getNat());
            ps.setString(6,stu.getSno());
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
}