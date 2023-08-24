package AllServlet;

import Util.DBAnswerUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AdmanswerServlet", value = "/AdmanswerServlet")
public class AdmanswerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=GBK");
        request.setCharacterEncoding("utf-8");
        HttpSession session=request.getSession();
        ServletContext context = getServletContext();
        context.setAttribute("selfans", DBAnswerUtil.getAllAnswerInfo());
        request.getRequestDispatcher("Admans.jsp").forward(request,response);
        System.out.println("666");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
    }
}
