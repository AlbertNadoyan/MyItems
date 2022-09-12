package servlet;

import manager.ItemManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/item/remove")
public class RemoveItemServlet extends HttpServlet {
    private ItemManager itemManager = new ItemManager();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int itemId = Integer.parseInt(request.getParameter("itemId"));
        itemManager.deleteItem(itemId);
        response.sendRedirect("/myItems/announcement");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
