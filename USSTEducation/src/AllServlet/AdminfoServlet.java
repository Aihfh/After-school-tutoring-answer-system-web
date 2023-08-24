package AllServlet;

import Util.DBAdmUtil;
import Util.DBTeacherUtil;
import Util.DBUserUtil;
import com.bean.Teacher;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AdminfoServlet", value = "/AdminfoServlet")
public class AdminfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Teacher tt=null;
        response.setContentType("text/html;charset=GBK");
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        String name = (String) session.getAttribute("name");
        ServletContext context = getServletContext();
        context.setAttribute("Ainfo", DBAdmUtil.getAdmInfoByCname(name));
        request.getRequestDispatcher("Ainfo.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
