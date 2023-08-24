package AllServlet;

import Util.DBAnswerUtil;
import Util.DBmeUtil;
import com.bean.Message;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "SearchServlet", value = "/SearchServlet")
public class SearchServlet extends HttpServlet {
    ArrayList<Message> list1 = new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=GBK");
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        String tc = (String) session.getAttribute("TC");
        String ec = (String) session.getAttribute("EC");
        String id = (String) request.getParameter("teid");
        int id1 = Integer.parseInt(id);
        ServletContext context = getServletContext();
        context.setAttribute("QA",DBmeUtil.getMessagebyid(id1));
        context.setAttribute("A", DBAnswerUtil.getAnswerbymesid(id1));
       if (tc.equals("Y")){
            request.getRequestDispatcher("TseeMes.jsp").forward(request,response);
        }
       else if (ec.equals("Y")){
           request.getRequestDispatcher("ADseeMes.jsp").forward(request,response);
       }
        else {
            request.getRequestDispatcher("xiangqing.jsp").forward(request,response);
        }
    }
    ArrayList<Message> list = new ArrayList<>();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=GBK");
        request.setCharacterEncoding("utf-8");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String now = "";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        now = dateFormat.format (new Date());
        HttpSession session = request.getSession();
        String name = (String) session.getAttribute("name");
        String classname = (String)session.getAttribute("classname");
        String liketitle = request.getParameter("ltitle");
        String likeclass = request.getParameter("class");
        String likename = request.getParameter("uname");
        ServletContext context = getServletContext();
        context.setAttribute("list",DBmeUtil.getMessagelike(likeclass,likename,liketitle));
        //if (likename.equals("")) {
        //context.setAttribute("list",DBmeUtil.getMessagelikeClass(likeclass));
       // }
        //else if (likeclass.equals("")) {
            //context.setAttribute("list",DBmeUtil.getMessagelikeName(likename));
       // }
        // context.setAttribute("list",list);
        request.getRequestDispatcher("newliuyan.jsp").forward(request,response);
    }
}
