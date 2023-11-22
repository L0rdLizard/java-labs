package dev.maxim.lab15;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.SneakyThrows;

import java.io.IOException;

@WebServlet(name = "ViewAddressBook", value = "/")
public class ViewServlet extends HttpServlet {
    private PostListStore store;

    @SneakyThrows
    public void init() {
        store = PostListStore.getInstance();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("posts", store.getAds());
        HttpSession session = request.getSession(false);  // false = do not create new session
        boolean loggedIn = session != null && session.getAttribute("username") != null;
        request.setAttribute("login", loggedIn);
        getServletContext().getRequestDispatcher("/view.jsp").forward(request, response);
    }

    public void destroy() {

    }
}