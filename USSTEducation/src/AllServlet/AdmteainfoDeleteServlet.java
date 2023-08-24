package AllServlet;

import Util.DBTeacherUtil;
import Util.DBmeUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AdmteainfoDeleteServlet", value = "/AdmteainfoDeleteServlet")
public class AdmteainfoDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=GBK");
        request.setCharacterEncoding("utf-8");
        String ttname = request.getParameter("tname");
        DBTeacherUtil.deleteTeacherbyname(ttname);
        request.getRequestDispatcher("/AcheckteaServlet").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
