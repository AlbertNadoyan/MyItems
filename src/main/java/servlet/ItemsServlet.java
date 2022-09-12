package servlet;

import manager.ItemManager;
import manager.UserManager;
import model.Item;
import model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/myItems")
public class ItemsServlet extends HttpServlet {
    private ItemManager itemManager = new ItemManager();
    private UserManager userManager = new UserManager();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if(user == null){
            response.sendRedirect("/");
        }else {
            List<Item> allItem = itemManager.getItemsByUserId(user.getId());
            request.setAttribute("item", allItem);
            request.getRequestDispatcher("/WEB-INF/items.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
