package ru.semestr1.lab13;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Servlet extends HttpServlet {

    private List<Notebook> entries;

    @Override
    public void init() throws ServletException {
        super.init();
        entries = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader("path/to/file.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(",");
                String name = parts[0];
                List<String> phones = Arrays.asList(parts).subList(1, parts.length);
                Notebook entry = new Notebook(name, phones);
                entries.add(entry);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet</h1>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet</h1>");
        out.println("</body>");
        out.println("</html>");
    }
}
