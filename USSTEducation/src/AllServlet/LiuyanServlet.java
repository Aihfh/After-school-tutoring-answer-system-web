package AllServlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import Util.DBTeacherUtil;
import Util.DBmeUtil;
import com.bean.Message;
@WebServlet(name = "LiuyanServlet", urlPatterns = "/LiuyanServlet")
public class LiuyanServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=GBK");
        request.setCharacterEncoding("utf-8");
        String now = "";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        now = dateFormat.format (new Date());
        HttpSession session=request.getSession();
        String classname = (String) session.getAttribute("classname");
        ServletContext context = getServletContext();
        context.setAttribute("list",DBmeUtil.getMessageInfoByClass(classname));
        //
        // context.setAttribute("list",list);
        request.getRequestDispatcher("liuyanban.jsp").forward(request,response);
    }
    ArrayList<Message> list = new ArrayList<>();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=GBK");
        request.setCharacterEncoding("utf-8");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String now = "";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        now = dateFormat.format (new Date());
        HttpSession session = request.getSession();
        String name = (String) session.getAttribute("name");
        String classtype = (String) session.getAttribute("classname");
        int Mid = DBmeUtil.getMaxMessageId();
        Message mes = new Message(Mid,now,name,title,content,classtype);
        mes.setMessageId(Mid);
        mes.setNname(name);
        mes.setTtitle(title);
        mes.setCcontext(content);
        mes.setDdate(now);
        mes.setClasstype(classtype);
        DBmeUtil.insertMesInfo(mes);
        list.add(mes);
        ServletContext context = getServletContext();
        context.setAttribute("list",DBmeUtil.getAllMessageInfo());
       //
        // context.setAttribute("list",list);
        request.getRequestDispatcher("newliuyan.jsp").forward(request,response);
    }

}
