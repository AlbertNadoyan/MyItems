package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet(urlPatterns = "/getImage")
public class GetImageServlet extends HttpServlet {

    private static final String imagePath = "C:\\Users\\Admin\\IdeaProjects\\itemImages\\";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String authorPic = request.getParameter("itemPic");
        String filePath = imagePath + authorPic;
        File imageFile = new File(filePath);
        if(imageFile.exists()){
            try(FileInputStream inputStream = new FileInputStream(imageFile)){
                response.setContentType("image/jpeg");
                response.setContentLength((int) imageFile.length());

                OutputStream outputStream = response.getOutputStream();
                byte[] buffer = new byte[4096];
                int byteRead = -1;

                while ((byteRead = inputStream.read(buffer)) != -1){
                    outputStream.write(buffer, 0, byteRead);
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
