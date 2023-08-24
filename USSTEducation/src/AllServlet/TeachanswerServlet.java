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

@WebServlet(name = "TeachanswerServlet", value = "/TeachanswerServlet")
public class TeachanswerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=GBK");
        request.setCharacterEncoding("utf-8");
        String now = "";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        now = dateFormat.format (new Date());
        String classname =  request.getParameter("classname");
        HttpSession session = request.getSession();
        session.setAttribute("classname",classname);
        ServletContext context = getServletContext();
        context.setAttribute("list", DBmeUtil.getMessageInfoByClass(classname));
        //
        // context.setAttribute("list",list);
        request.getRequestDispatcher("Tanswer.jsp").forward(request,response);
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
        int Maxid = DBmeUtil.getMaxMessageId();
        Message mes = new Message(Maxid,title,name,now,content,classname);
        mes.setMessageId(Maxid);
        mes.setNname(name);
        mes.setTtitle(title);
        mes.setCcontext(content);
        mes.setDdate(now);
        mes.setClasstype(classname);
        DBmeUtil.insertMesInfo(mes);
        list.add(mes);
        ServletContext context = getServletContext();
        context.setAttribute("list",DBmeUtil.getMessageInfoByClass(classname));
        //
        // context.setAttribute("list",list);
        request.getRequestDispatcher("Tanswer.jsp").forward(request,response);
    }
}
