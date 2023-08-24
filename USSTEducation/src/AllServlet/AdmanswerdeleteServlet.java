package AllServlet;

import Util.DBAnswerUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AdmanswerdeleteServlet", value = "/AdmanswerdeleteServlet")
public class AdmanswerdeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=GBK");
        request.setCharacterEncoding("utf-8");
        String messid = request.getParameter("messid");
        DBAnswerUtil.deleteAnsInfobymessid(messid);
        request.getRequestDispatcher("/AdmanswerServlet").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
