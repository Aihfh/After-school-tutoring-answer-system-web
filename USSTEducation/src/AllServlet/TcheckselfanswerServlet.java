package AllServlet;

import Util.DBAnswerUtil;
import Util.DBmeUtil;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "TcheckselfanswerServlet", value = "/TcheckselfanswerServlet")
public class TcheckselfanswerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=GBK");
        request.setCharacterEncoding("utf-8");
        HttpSession session=request.getSession();
        String sname= (String) session.getAttribute("name");
        ServletContext context = getServletContext();
        context.setAttribute("selfans", DBAnswerUtil.getAnswerInfoByUname(sname));
        request.getRequestDispatcher("Tselfans.jsp").forward(request,response);
        System.out.println("666");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
