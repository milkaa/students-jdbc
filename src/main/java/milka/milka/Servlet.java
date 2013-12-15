package milka.milka;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class Servlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/a.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession s = req.getSession();
        String ss = req.getParameter("key");
        if (ss.isEmpty()) {

        } else {
            DB.connect();
            DB.saveQuestion(ss);
            s.setAttribute("q", "Can u " + ss+"?");

            s.setAttribute("s", DB.getAnswer());
        }
        RequestDispatcher rd = req.getRequestDispatcher("/a.jsp");
        rd.forward(req, resp);
    }

}
