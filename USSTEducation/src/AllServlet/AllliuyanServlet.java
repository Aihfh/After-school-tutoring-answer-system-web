package AllServlet;

import Util.DBmeUtil;
import com.bean.Message;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "AllliuyanServlet", value = "/AllliuyanServlet")
public class AllliuyanServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=GBK");
        request.setCharacterEncoding("utf-8");
        ServletContext context = getServletContext();
        context.setAttribute("list",DBmeUtil.getAllMessageInfo());
        //
        // context.setAttribute("list",list);
        request.getRequestDispatcher("ALLliuyan.jsp").forward(request,response);
    }
    ArrayList<Message> list = new ArrayList<>();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
