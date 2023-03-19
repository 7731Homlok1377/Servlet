package org.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;


@WebServlet("/files")
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String param = req.getParameter("path");
        String defParam = System.getProperty("user.home");
        String path;
        if(param == null || param.isEmpty()) {
            path = defParam;
        }
        else {
            path = param;
        }

        req.setAttribute("path", path);
        File file = new File(path);
        String parentDirectory = file.getParent();
        req.setAttribute("parents", parentDirectory);
        if(file.isDirectory()){
            File dir = new File(path);
            req.setAttribute("file", file);
            req.setAttribute("fileList", dir.listFiles());
            req.setAttribute("d", "hfhfhf");

            req.getRequestDispatcher("MainJSP.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
