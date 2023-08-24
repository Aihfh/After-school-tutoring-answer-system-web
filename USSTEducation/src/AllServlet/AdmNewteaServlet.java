package AllServlet;

import Util.DBTeacherUtil;
import Util.DBclassUtil;
import com.bean.Ccclass;
import com.bean.Teacher;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdmNewteaServlet", value = "/AdmNewteaServlet")
public class AdmNewteaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=GBK");
        request.setCharacterEncoding("utf-8");
        HttpSession session =request.getSession();
        ServletContext context = getServletContext();
        List<Teacher> teachers = DBTeacherUtil.getAllTeacherInfo();
        context.setAttribute("alltt",teachers);
        request.getRequestDispatcher("Admnewtea.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=GBK");
        request.setCharacterEncoding("utf-8");
        String newid1 = request.getParameter("newtid");
        String newname1 = request.getParameter("newname");
        String newpass1 = request.getParameter("newpass");
        String newdept1 = request.getParameter("newdept");
        String newinfo1 = request.getParameter("newinfo");
        Teacher teacher = new Teacher(newid1,newname1,newpass1,newdept1,newinfo1);
        DBTeacherUtil.insertTeacherInfo(teacher);
        request.getRequestDispatcher("/AcheckteaServlet").forward(request,response);
    }
}
