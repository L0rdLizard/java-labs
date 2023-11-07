package dev.maxim.lab13;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

import java.io.IOException;

@WebServlet(name = "ServletSearch", value = "/contacts/search")
public class ServletSearch extends HttpServlet {
    private NoteBookStore store;

    @SneakyThrows
    public void init() {
        store = NoteBookStore.getInstance("store.txt");
        store.load();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        getServletContext().getRequestDispatcher("/formSearch.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        request.setAttribute("name", name);
        request.setAttribute("contacts", store.getAddressBook().getContacts());
        getServletContext().getRequestDispatcher("/searchList.jsp").forward(request, response);
//        store.save();
    }

    public void destroy() {
    }
}
