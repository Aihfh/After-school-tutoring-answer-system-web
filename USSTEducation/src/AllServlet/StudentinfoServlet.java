package AllServlet;

import Util.DBUserUtil;
import com.bean.Message;
import com.bean.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StudentinfoServlet", urlPatterns = "/StudentinfoServlet")
public class StudentinfoServlet extends HttpServlet {
    ArrayList<Message> Uinfo = new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=GBK");
        request.setCharacterEncoding("utf-8");
        HttpSession session =request.getSession();
        String uname1 = (String) session.getAttribute("name");
        ServletContext context=getServletContext();
        context.setAttribute("uinfo",DBUserUtil.getUserInfoByName(uname1));
        request.getRequestDispatcher("userinfo.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
