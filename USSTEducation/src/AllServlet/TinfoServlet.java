package AllServlet;

import Util.DBTeacherUtil;
import com.bean.Teacher;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "TinfoServlet", urlPatterns = "/TinfoServlet")
public class TinfoServlet extends HttpServlet {
    ArrayList<Teacher> list1 = new ArrayList<Teacher>();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Teacher tt=null;
        response.setContentType("text/html;charset=GBK");
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        String name = (String) session.getAttribute("name");
        ServletContext context = getServletContext();
        context.setAttribute("Tinfo",DBTeacherUtil.getTeacherInfoByTname(name));
        request.getRequestDispatcher("Tinfo.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
