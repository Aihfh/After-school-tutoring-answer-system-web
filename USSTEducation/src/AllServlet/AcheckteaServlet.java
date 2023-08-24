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

@WebServlet(name = "AcheckteaServlet", value = "/AcheckteaServlet")
public class AcheckteaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=GBK");
        request.setCharacterEncoding("utf-8");
        HttpSession session =request.getSession();
        ServletContext context = getServletContext();
        List<Teacher> tea = DBTeacherUtil.getAllTeacherInfo();
        context.setAttribute("alltea",tea);
        request.getRequestDispatcher("Allteacher.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
