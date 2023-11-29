package dev.maxim.lab15;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "LogoutServlet", value = "/logout")
public class LogoutServlet extends HttpServlet {
    public void init() {
        System.out.println("logout1");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        HttpSession session = request.getSession(false);
//        if (session != null) session.invalidate();
//
//        request.setAttribute("status", "Logout success!");
//        request.setAttribute("message", "You are successfully logged out!");
//        getServletContext().getRequestDispatcher("/info.jsp").forward(request, response);
        System.out.println("logout2");
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute("user");
            session.invalidate();
        }

        request.setAttribute("status", "Logout success!");
        request.setAttribute("message", "You are successfully logged out!");
        getServletContext().getRequestDispatcher("/info.jsp").forward(request, response);
    }

    public void destroy() {
    }
}