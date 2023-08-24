package AllServlet;

import Util.DBTeacherUtil;
import Util.DBUserUtil;
import com.bean.Teacher;
import com.bean.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "TinfochangeServlet", value = "/TinfochangeServlet")
public class TinfochangeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=GBK");
        request.setCharacterEncoding("utf-8");
        String Tmid =request.getParameter("Tid");
        ServletContext context=getServletContext();
        context.setAttribute("newTea", DBTeacherUtil.getTrbyid(Tmid));
        request.getRequestDispatcher("Tinfochange.jsp").forward(request,response);
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
        Teacher teacher = DBTeacherUtil.getTrOnlybyid(id);
        teacher.setTname(newuname1);
        teacher.setTpassword(newpass);
        try {
            DBTeacherUtil.modifyTeacherInfo(teacher);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        context.setAttribute("Tinfo",DBTeacherUtil.getTeacherInfoByTname(newuname1));
        request.getRequestDispatcher("Tinfo.jsp").forward(request,response);
    }
    }

