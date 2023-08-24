package AllServlet;

import Util.DBclassUtil;
import com.bean.Ccclass;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AclassServlet", value = "/AclassServlet")
public class AclassServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=GBK");
        request.setCharacterEncoding("utf-8");
        HttpSession session =request.getSession();
        String TName = (String) session.getAttribute("name");
        ServletContext context = getServletContext();
        List<Ccclass> css= DBclassUtil.getAllclassInfo();
        context.setAttribute("subject",css);
        request.getRequestDispatcher("Aclassview.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
