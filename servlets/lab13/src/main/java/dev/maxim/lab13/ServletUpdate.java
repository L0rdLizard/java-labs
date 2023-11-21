package dev.maxim.lab13;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

import java.io.IOException;

@WebServlet(name = "ServletUpdate", value = "/contacts/update")
public class ServletUpdate extends HttpServlet {
    private NoteBookStore store;

    @SneakyThrows
    public void init() {
        store = NoteBookStore.getInstance("store.txt");
        store.load();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        getServletContext().getRequestDispatcher("/form.jsp").forward(request, response);
//        getServletContext().getRequestDispatcher("/formSearch.jsp").forward(request, response);
    }

    // Method to handle POST request from the form
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        store.update(name, phone);


        getServletContext().getRequestDispatcher("/info.jsp").forward(request, response);
        store.save();
    }

    public void destroy() {
    }
}