package com.example.salary.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "Route", urlPatterns = "/route")
public class Route extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request, response);
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String address = request.getParameter("address");

        if (Objects.equals(address, "upload")) {
            request.setAttribute("mainPage", "upload.jsp");
            request.getRequestDispatcher("main.jsp").forward(request, response);
            return;
        } else if (Objects.equals(address, "search")) {
            request.setAttribute("mainPage", "search.jsp");
            request.getRequestDispatcher("main.jsp").forward(request, response);
            return;
        } else if (Objects.equals(address, "password")) {
            request.setAttribute("mainPage", "password.jsp");
            request.getRequestDispatcher("main.jsp").forward(request, response);
            return;
        }
        request.getRequestDispatcher("main.jsp").forward(request, response);
    }
}
