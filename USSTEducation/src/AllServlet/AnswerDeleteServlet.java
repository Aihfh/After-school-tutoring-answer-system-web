package AllServlet;

import Util.DBAnswerUtil;
import Util.DBmeUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AnswerDeleteServlet", value = "/AnswerDeleteServlet")
public class AnswerDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=GBK");
        request.setCharacterEncoding("utf-8");
        String messid = request.getParameter("messid");
        DBAnswerUtil.deleteAnsInfobymessid(messid);
        request.getRequestDispatcher("/TcheckselfanswerServlet").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
