package org.example.servlet;


import org.example.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/files/authorization")
public class AuthorizServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("../authorization.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String path = "";
        UserService userService = new UserService();
        if (userService.validUser(login, password)) {
            HttpSession session = req.getSession(true);
            session.setMaxInactiveInterval(1800);
            session.setAttribute("login", login);
            session.setAttribute("password", password);
            path = req.getContextPath() + "/files";
            //resp.sendRedirect(req.getContextPath() + "/files");
        }
        else{ path = "./authorization";}
        resp.sendRedirect(path);
    }
}

