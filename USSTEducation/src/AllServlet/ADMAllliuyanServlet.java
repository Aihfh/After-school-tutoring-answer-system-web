package AllServlet;

import Util.DBmeUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ADMAllliuyanServlet", value = "/ADMAllliuyanServlet")
public class ADMAllliuyanServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=GBK");
        request.setCharacterEncoding("utf-8");
        ServletContext context = getServletContext();
        context.setAttribute("list", DBmeUtil.getAllMessageInfo());
        //
        // context.setAttribute("list",list);
        request.getRequestDispatcher("Aallliuyanjsp.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
    }
}
