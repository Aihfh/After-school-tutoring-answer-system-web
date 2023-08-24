package AllServlet;

import Util.DBmeUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "TdeleteMESServlet", value = "/TdeleteMESServlet")
public class TdeleteMESServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=GBK");
        request.setCharacterEncoding("utf-8");
        String messid = request.getParameter("messid");
        DBmeUtil.deleteMesInfobymessid(messid);
        HttpSession session=request.getSession();
        String classname=(String) session.getAttribute("classname");
        ServletContext context = getServletContext();
        context.setAttribute("list", DBmeUtil.getMessageInfoByClass(classname));
        request.getRequestDispatcher("Tanswer.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
