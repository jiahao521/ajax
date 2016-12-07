package com.kaishengit.web;

import com.kaishengit.utils.HttpUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by jiahao0 on 2016/12/6.
 */
@WebServlet("/res.xml")
public class ResServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = "http://www.pingwest.com/feed/";
        String result = HttpUtils.sendHttpGetRequest(url);

        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/xml;charset=UTF-8");

        PrintWriter out = resp.getWriter();
        out.print(result);
        out.flush();
        out.close();
    }
}
