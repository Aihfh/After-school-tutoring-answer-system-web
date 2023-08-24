package AllServlet;

import Util.DBclassUtil;
import Util.DBmeUtil;
import com.bean.Ccclass;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AdmchangeclassServlet", value = "/AdmchangeclassServlet")
public class AdmchangeclassServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=GBK");
        request.setCharacterEncoding("utf-8");
        String Tname =request.getParameter("C1name");
        ServletContext context=getServletContext();
        context.setAttribute("nowclass",DBclassUtil.getClassInfoByName(Tname));
        request.getRequestDispatcher("classmodify.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=GBK");
        request.setCharacterEncoding("utf-8");
        String nowid=request.getParameter("mtid");
        String nowname=request.getParameter("mname");
        String nowclass = request.getParameter("mclass");
        Ccclass ccclass = new Ccclass(nowid,nowname,nowclass);
        try {
            DBclassUtil.modifyClass(ccclass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<Ccclass> css= DBclassUtil.getAllclassInfo();
        ServletContext context = getServletContext();
        context.setAttribute("subject",css);
        request.getRequestDispatcher("Aclassview.jsp").forward(request,response);
    }
}
