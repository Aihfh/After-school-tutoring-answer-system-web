package AllServlet;

import Util.DBAnswerUtil;
import Util.DBmeUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "StucheckselfServlet", urlPatterns = "/StucheckselfServlet")
public class StucheckselfServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=GBK");
        request.setCharacterEncoding("utf-8");
        HttpSession session=request.getSession();
        String sname= (String) session.getAttribute("name");
        ServletContext context = getServletContext();
        context.setAttribute("selfmes", DBmeUtil.getMessageInfoByUname(sname));
        request.getRequestDispatcher("Selfmes.jsp").forward(request,response);
        System.out.println("666");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request,response);
    }
}
