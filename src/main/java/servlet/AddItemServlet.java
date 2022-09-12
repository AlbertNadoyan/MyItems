package servlet;

import manager.CategoryManager;
import manager.ItemManager;
import manager.UserManager;
import model.Category;
import model.Item;
import model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@MultipartConfig(
        fileSizeThreshold = 1024 * 1024,
        maxFileSize =  1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 100
)
@WebServlet(urlPatterns = "/items/add")
public class AddItemServlet extends HttpServlet {
    private CategoryManager categoryManager = new CategoryManager();
    private UserManager userManager = new UserManager();
    private ItemManager itemManager = new ItemManager();
    private static final String imagePath = "C:\\Users\\Admin\\IdeaProjects\\ItemImages\\";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        List<Item> allItem = itemManager.getAllItem();
        request.setAttribute("item", allItem);
        List<Category> allCategory = categoryManager.getAllCategory();
        request.setAttribute("category", allCategory);
        List<User> allUser = userManager.getAllUser();
        request.setAttribute("user", allUser);
        if(user == null){
            response.sendRedirect("/");
        }else {
            request.getRequestDispatcher("/WEB-INF/addItem.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        double price = Double.parseDouble(request.getParameter("price"));
        int categoryId = Integer.parseInt(request.getParameter("category"));
        Part itemPic = request.getPart("itemPic");
        String filename = null;
        if(itemPic != null){
            long nanoTime = System.nanoTime();

            filename = nanoTime + "-" + itemPic.getSubmittedFileName();
            itemPic.write(imagePath + filename);
        }
        int userId = Integer.parseInt(request.getParameter("user"));

        Item item = Item.builder()
                .title(title)
                .price(price)
                .catId(categoryManager.getById(categoryId))
                .picUrl(filename)
                .userId(userManager.getById(userId))
                .build();

        itemManager.addItem(item);
        response.sendRedirect("/myItems");

    }

}
