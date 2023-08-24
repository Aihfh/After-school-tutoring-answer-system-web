package AllServlet;

import Util.DBmeUtil;
import com.bean.Message;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "MessmodifyServlet", value = "/MessmodifyServlet")
public class MessmodifyServlet extends HttpServlet {
    ArrayList<Message> list1 = new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=GBK");
        request.setCharacterEncoding("utf-8");
        String mid =request.getParameter("messid");
        int mmID= Integer.parseInt(mid);
        ServletContext context=getServletContext();
        context.setAttribute("nowmess",DBmeUtil.getMessagebyid(mmID));
        request.getRequestDispatcher("Selfmodify.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=GBK");
        request.setCharacterEncoding("utf-8");
        String newcon = request.getParameter("newcontext");
        String newtit = request.getParameter("newtitle");
        String id = (String) request.getParameter("fu");
        int id1 = Integer.parseInt(id);
        String now = "";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        now = dateFormat.format (new Date());
        Message message=DBmeUtil.getMessageInfonly1id(id1);
        message.setCcontext(newcon);
        message.setTtitle(newtit);
        message.setDdate(now);
        try {
            DBmeUtil.modifyMesInfo(message);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/StucheckselfServlet").forward(request,response);

    }
}
