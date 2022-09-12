package servlet;

import manager.UserManager;
import model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private UserManager userManager = new UserManager();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = userManager.getUserEmailAndPassword(email, password);
        if(user == null){
            request.setAttribute("msg", "Email and/or password is incorrect.");
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }else {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect("/myItems");
        }
    }
}
