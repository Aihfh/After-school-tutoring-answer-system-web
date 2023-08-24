package AllServlet;

import Util.DBclassUtil;
import Util.DBmeUtil;
import com.bean.Ccclass;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdmDeleteclassServlet", value = "/AdmDeleteclassServlet")
public class AdmDeleteclassServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=GBK");
        request.setCharacterEncoding("utf-8");
        String cdename = request.getParameter("C1id");
        DBclassUtil.deleteClassInfobyclassname(cdename);
        List<Ccclass> css = DBclassUtil.getAllclassInfo();
        ServletContext context = getServletContext();
        context.setAttribute("subject", css);
        request.getRequestDispatcher("Aclassview.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
