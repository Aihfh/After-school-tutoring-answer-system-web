package AllServlet;

import Util.DBAnswerUtil;
import Util.DBmeUtil;
import com.bean.Message;
import com.bean.TAnswer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "AnswermodifyServlet", value = "/AnswermodifyServlet")
public class AnswermodifyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=GBK");
        request.setCharacterEncoding("utf-8");
        String mid =request.getParameter("messid");
        int mmID= Integer.parseInt(mid);
        ServletContext context=getServletContext();
        context.setAttribute("nowann", DBAnswerUtil.getAnswerbymesid(mmID));
        request.getRequestDispatcher("AnswerModify.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=GBK");
        request.setCharacterEncoding("utf-8");
        String newcon = request.getParameter("newcont");
        String newpic = request.getParameter("newpic");
        String id = (String) request.getParameter("fu1");
        int id1 = Integer.parseInt(id);
        String now = "";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        now = dateFormat.format (new Date());
        TAnswer tAnswer =DBAnswerUtil.getAnswerInfonly1id(id1);
        tAnswer.setAcontent(newcon);
        tAnswer.setApicture(newpic);
        tAnswer.setAdate(now);
        try {
            DBAnswerUtil.modifyAnsInfo(tAnswer);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/TcheckselfanswerServlet").forward(request,response);
        System.out.println("777");
    }
}
