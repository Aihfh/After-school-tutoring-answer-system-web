package AllServlet;

import Util.DBAdmUtil;
import Util.DBTeacherUtil;
import Util.DBUserUtil;
import Util.DBmeUtil;
import com.bean.Message;
import com.bean.Teacher;
import com.bean.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "LoginServlet", urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("Login1.jsp");
        rd.forward(request, response);
    }
    ArrayList<Message> list = new ArrayList<>();
    ArrayList<User> ulist = new ArrayList<>();
    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            int c=0;
            int d=0;
            int e=0;
            response.setContentType("text/html;charset=GBK");
            request.setCharacterEncoding("utf-8");
            String name = request.getParameter("name");
            String password = request.getParameter("password");
            c=DBUserUtil.CheckuserID(name,password);
            d=DBTeacherUtil.CheckTeacherID(name,password);
            e=DBAdmUtil.CheckAdmID(name,password);
            if (c==1) {
                HttpSession session = request.getSession(true);
                session.setAttribute("name",name);
                session.setAttribute("SC","Y");
                session.setAttribute("TC","N");
                session.setAttribute("EC","N");
                ServletContext context = getServletContext();
                context.setAttribute("list",DBmeUtil.getAllMessageInfo());
                RequestDispatcher rd = request.getRequestDispatcher("studentmain.jsp");
                rd.forward(request, response);
            }
            else if (d==2){
                HttpSession session = request.getSession(true);
                session.setAttribute("name", name);
                session.setAttribute("SC","N");
                session.setAttribute("EC","N");
                session.setAttribute("TC","Y");
                ServletContext context = getServletContext();
                context.setAttribute("list", DBmeUtil.getAllMessageInfo());
                RequestDispatcher rd = request.getRequestDispatcher("Tmainview.jsp");
             //Teacher teacher=null;
              //String classname;
              //teacher = DBTeacherUtil.getTeacherInfoByName(name);
               //classname = teacher.getTclass();
               //session.setAttribute("classname", classname);
                rd.forward(request, response);
            }
            else if (e==3){
            HttpSession session = request.getSession(true);
            session.setAttribute("name", name);
            session.setAttribute("EC","Y");
            session.setAttribute("TC","N");
            session.setAttribute("SC","N");
            ServletContext context = getServletContext();
            context.setAttribute("list", DBmeUtil.getAllMessageInfo());
            RequestDispatcher rd = request.getRequestDispatcher("Admview.jsp");
            rd.forward(request, response);
            }
            else if(c==0){
                RequestDispatcher rd = request.getRequestDispatcher("Wrongbyid.jsp");
                rd.forward(request, response);
            }
    }
}
