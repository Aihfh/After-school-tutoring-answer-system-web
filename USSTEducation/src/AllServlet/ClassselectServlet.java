package AllServlet;

import Util.DBclassUtil;
import Util.DBmeUtil;
import com.bean.Ccclass;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "ClassselectServlet", urlPatterns = "/ClassselectServlet")
public class ClassselectServlet extends HttpServlet {
    List<Ccclass> cla = new ArrayList<Ccclass>();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=GBK");
        request.setCharacterEncoding("utf-8");
        HttpSession session =request.getSession();
        session.getAttribute("name");
        ServletContext context = getServletContext();
        List<Ccclass> css=DBclassUtil.getAllclassInfo();
        context.setAttribute("subject",css);
        request.getRequestDispatcher("Subjectsit.jsp").forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
