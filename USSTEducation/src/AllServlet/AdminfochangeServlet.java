package AllServlet;

import Util.DBAdmUtil;
import Util.DBTeacherUtil;
import com.bean.Adm;
import com.bean.Teacher;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AdminfochangeServlet", value = "/AdminfochangeServlet")
public class AdminfochangeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=GBK");
        request.setCharacterEncoding("utf-8");
        String Cmid =request.getParameter("Cid");
        ServletContext context=getServletContext();
        context.setAttribute("newC", DBAdmUtil.getADMbyid(Cmid));
        request.getRequestDispatcher("Cinfochange.jsp").forward(request,response);
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
        Adm adm =DBAdmUtil.getADMOnlybyid(id);
        adm.setCname(newuname1);
        adm.setCpassword(newpass);
        try {
            DBAdmUtil.modifyADMInfo(adm);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        context.setAttribute("Ainfo",DBAdmUtil.getAdmInfoByCname(newuname1));
        request.getRequestDispatcher("Ainfo.jsp").forward(request,response);
    }
}
