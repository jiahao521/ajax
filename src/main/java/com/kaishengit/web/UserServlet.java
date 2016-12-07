package com.kaishengit.web;

import com.kaishengit.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jiahao0 on 2016/12/5.
 */
@WebServlet("/user.xml")
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User(1001,"jack","北京");
        User user1 = new User(1002,"tom","河南");
        User user2 = new User(1003,"lili","jiaozuo");

        List<User> list = Arrays.asList(user,user1,user2);
        //1.设置响应d编码
        resp.setCharacterEncoding("UTF-8");
        //2.设置响应头MIME-type
        resp.setContentType("text/xml;charset=UTF-8");

        PrintWriter out = resp.getWriter();
        out.print("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
        out.print("<user>");
        for(User users :list) {
            out.print("<user id = \"" + users.getId() + "\">");
            out.print("<name>" + users.getUsername() + "</name>");
            out.print("<address>" + users.getAddress() + "</address>");
            out.print("</user>");
        }
        out.print("</user>");

        out.flush();
        out.close();
    }
}
