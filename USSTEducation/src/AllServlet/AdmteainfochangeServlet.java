package AllServlet;

import Util.DBTeacherUtil;
import com.bean.Teacher;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AdmteainfochangeServlet", value = "/AdmteainfochangeServlet")
public class AdmteainfochangeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=GBK");
        request.setCharacterEncoding("utf-8");
        String Tmid =request.getParameter("tid");
        ServletContext context=getServletContext();
        context.setAttribute("newTea", DBTeacherUtil.getTrbyid(Tmid));
        request.getRequestDispatcher("Admteainfochange.jsp").forward(request,response);
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
        String newdept = request.getParameter("newdept");
        String newinfo = request.getParameter("newinfo");
        String id = (String) request.getParameter("newid");
        Teacher teacher = DBTeacherUtil.getTrOnlybyid(id);
        teacher.setTname(newuname1);
        teacher.setTpassword(newpass);
        teacher.setTclass(newdept);
        teacher.setTinfo(newinfo);
        try {
            DBTeacherUtil.modifyTeacherInfo(teacher);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/AcheckteaServlet").forward(request,response);
    }
}
