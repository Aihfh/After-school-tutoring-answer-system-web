package AllServlet;

import Util.DBclassUtil;
import com.bean.Ccclass;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdmnewclassServlet", value = "/AdmnewclassServlet")
public class AdmnewclassServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=GBK");
        request.setCharacterEncoding("utf-8");
        HttpSession session =request.getSession();
        ServletContext context = getServletContext();
        List<Ccclass> css= DBclassUtil.getAllclassInfo();
        context.setAttribute("subject",css);
        request.getRequestDispatcher("Aclassnewview.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=GBK");
        request.setCharacterEncoding("utf-8");
        String newid = request.getParameter("newteacherid");
        String newclass = request.getParameter("newclass");
        String newteacher = request.getParameter("newteacher");
        Ccclass ccclass = new Ccclass(newid,newteacher,newclass);
        DBclassUtil.insertClassInfo(ccclass);
        List<Ccclass> css= DBclassUtil.getAllclassInfo();
        ServletContext context = getServletContext();
        context.setAttribute("subject",css);
        request.getRequestDispatcher("Aclassview.jsp").forward(request,response);
    }
}
