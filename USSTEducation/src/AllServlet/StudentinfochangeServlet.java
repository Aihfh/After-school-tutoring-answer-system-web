package AllServlet;

import Util.DBUserUtil;
import Util.DBmeUtil;
import com.bean.Message;
import com.bean.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "StudentinfochangeServlet", value = "/StudentinfochangeServlet")
public class StudentinfochangeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=GBK");
        request.setCharacterEncoding("utf-8");
        String mid =request.getParameter("usid");
        ServletContext context=getServletContext();
        context.setAttribute("newuser", DBUserUtil.getUserbyid(mid));
        request.getRequestDispatcher("userinfochange.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=GBK");
        request.setCharacterEncoding("utf-8");
        String newuname1 = request.getParameter("newuname");
        HttpSession session =request.getSession();
       session.setAttribute("name",newuname1);
        ServletContext context=getServletContext();
        String newpass = request.getParameter("newpass");
        String id = (String) request.getParameter("newid");
        User user = DBUserUtil.getUserOnlybyid(id);
        user.setUName(newuname1);
        user.setUPassword(newpass);
        try {
            DBUserUtil.modifyUserInfo(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        context.setAttribute("uinfo",DBUserUtil.getUserInfoByName(newuname1));
        request.getRequestDispatcher("userinfo.jsp").forward(request,response);
    }
}
