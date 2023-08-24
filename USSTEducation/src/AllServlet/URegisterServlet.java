package AllServlet;

import Util.DBUserUtil;
import Util.DBUtil;
import Util.DBmeUtil;
import com.bean.Message;
import com.bean.Student;
import com.bean.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "URegisterServlet", urlPatterns = "/URegisterServlet")
public class URegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=GBK");
        request.setCharacterEncoding("utf-8");
        String Uid=request.getParameter("Uno");
        String Uname=request.getParameter("Uname");
        String Upd=request.getParameter("Upass");
        String Tnm=request.getParameter("Tname");
        }

    ArrayList<User> listu = new ArrayList<>();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=GBK");
        request.setCharacterEncoding("utf-8");
        String Uid=request.getParameter("Uno");
        String Uname=request.getParameter("Uname");
        String Upd=request.getParameter("Upass");
        String Tnm=request.getParameter("Tname");
        User us = new User(Uid,Uname,Upd,Tnm);
        us.setUserid(Uid);
        us.setUName(Uname);
        us.setUPassword(Upd);
        us.setTruename(Tnm);
        DBUserUtil.insertUserInfo(us);
        listu.add(us);
        request.getRequestDispatcher("Login1.jsp").forward(request,response);
    }
}
