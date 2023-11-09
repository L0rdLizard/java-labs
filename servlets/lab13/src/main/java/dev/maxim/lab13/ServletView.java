package dev.maxim.lab13;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lombok.SneakyThrows;

@WebServlet(name = "ServletView", value = "/contacts")
public class ServletView extends HttpServlet {
    private NoteBookStore store;

    @SneakyThrows
    public void init() {
        store = NoteBookStore.getInstance("store.txt");
        store.load();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("contacts", store.getAddressBook().getContacts());
        getServletContext().getRequestDispatcher("/view.jsp").forward(request, response);
    }

    public void destroy() {
    }
}