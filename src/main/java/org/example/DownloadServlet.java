package org.example;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/files/download")
public class DownloadServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String param = req.getParameter("path");
        String fileName = Paths.get(param).getFileName().toString();

        resp.setContentType("text/plain");
        resp.setHeader("Content-disposition","attachment; filename=" + fileName);

        File file = new File(param);
        try (FileInputStream inputStream = new FileInputStream(file);
             OutputStream out = resp.getOutputStream()) {
            byte[] bytes = new byte[4096];
            int length;
            while ((length = inputStream.read(bytes)) > 0)
                out.write(bytes, 0, length);
        }

    }


}