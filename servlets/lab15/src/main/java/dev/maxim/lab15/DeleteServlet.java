package dev.maxim.lab15;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

import java.io.IOException;

@WebServlet(name = "DeleteServlet", value = "/delete")
public class DeleteServlet extends HttpServlet {
    private PostListStore store;
    public void init() {
        store = PostListStore.getInstance();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        String username = (String) request.getAttribute("username");
        HttpSession session = request.getSession(false);
        String username = (String) session.getAttribute("username");
        System.out.println(username);
        store.getBoard().getAds().removeIf(Post -> Post.getUser().contains(username));

//        HttpSession session = request.getSession(false);
//        if (session != null) session.invalidate();

        request.setAttribute("status", "All posts was deleted");
        request.setAttribute("message", "You are successfully delete all posts!");
        getServletContext().getRequestDispatcher("/info.jsp").forward(request, response);
    }

    public void destroy() {
    }
}