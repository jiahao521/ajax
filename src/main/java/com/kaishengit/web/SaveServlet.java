package com.kaishengit.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by jiahao0 on 2016/12/7.
 */
@WebServlet("/save")
public class SaveServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String address = req.getParameter("address");

        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/xml;charset=UTF-8");
        System.out.println("save:" + username + "->" + address);
    }
}
