package org.example.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.stream.Stream;


@WebServlet("/files")
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
        String path;
        String param = req.getParameter("path");
        String defParam = System.getProperty("user.home");

        if(param == null || param.isEmpty()) {
            path = defParam;
        }
        else {
            path = param;
        }
        */
        HttpSession session = req.getSession(true);
        Object login = session.getAttribute("login");
        System.out.println(login);

        String l = login.toString();
        System.out.println(l);
        String path = req.getParameter("path");
        File root = new File("C:\\Users\\Olga\\Desktop\\noname");
        if (path == null) {
            path = findDir(root,login);
        }
        if (path == null) {
            Path pathNew = Files.createDirectories(Paths.get("C:\\Users\\Olga\\Desktop\\noname\\"+l+"\\"));
            path = pathNew.toAbsolutePath().toString();
        }

        req.setAttribute("path", path);
        File file = new File(path);
        String parentDirectory = file.getParent();
        req.setAttribute("parents", parentDirectory);
        SimpleDateFormat date = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        req.setAttribute("date", date);
        if(file.isDirectory()){
            File dir = new File(path);
            req.setAttribute("file", file);
            req.setAttribute("files", dir.listFiles());

            req.getRequestDispatcher("MainJSP.jsp").forward(req, resp);
        }
    }
    private String  findDir(File root, Object login){
        String res = null;
        if(root.isDirectory()){
            File[] dirFiles = root.listFiles();
            for(File f : dirFiles){
                if(f.isDirectory()) {
                    if (f.getName().equals(login)){
                        res = f.getPath();
                    }

                    return res;
                }
            }
        }
        return res;
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
