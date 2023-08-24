package AllServlet;

import Util.DBAnswerUtil;
import Util.DBmeUtil;
import com.bean.Message;
import com.bean.TAnswer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "AnswerviewServlet", value = "/AnswerviewServlet")
public class AnswerviewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=GBK");
        request.setCharacterEncoding("utf-8");
        String mid = (String) request.getParameter("teid");
        int id1 = Integer.parseInt(mid);
        HttpSession session = request.getSession();
        session.setAttribute("mid",mid);
        String name =(String) session.getAttribute("name");
        ServletContext context = getServletContext();
        context.setAttribute("QA", DBmeUtil.getMessagebyid(id1));
        context.setAttribute("A", DBAnswerUtil.getAnswerbymesid(id1));
        request.getRequestDispatcher("Txiangqing.jsp").forward(request,response);
    }
    ArrayList<TAnswer> Alist = new ArrayList<>();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=GBK");
        request.setCharacterEncoding("utf-8");
        String Atitle = request.getParameter("Atitle");
        String Acontent = request.getParameter("Acontent");
        String now = "";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        now = dateFormat.format (new Date());
        HttpSession session = request.getSession();
        String c= (String) session.getAttribute("mid");
        int Maxid = Integer.parseInt(c);
        String name = (String) session.getAttribute("name");
        String classname = (String)session.getAttribute("classname");
        String tid = DBAnswerUtil.getTeaidByMid(Maxid);
        TAnswer tAnswer = new TAnswer(Maxid,"1",Acontent,now,tid,classname,name);
        tAnswer.setMessageId(Maxid);
        tAnswer.setApicture("1");
        tAnswer.setAcontent(Acontent);
        tAnswer.setAdate(now);
        tAnswer.setTeacherid(tid);
        tAnswer.setAtype(classname);
        tAnswer.setTname(name);
        DBAnswerUtil.insertAnswerInfo(tAnswer);
        Alist.add(tAnswer);
        ServletContext context = getServletContext();
        context.setAttribute("A",DBAnswerUtil.getAnswerbymesid(Maxid));
        //
        // context.setAttribute("list",list);
        request.getRequestDispatcher("Txiangqing.jsp").forward(request,response);
    }
}
