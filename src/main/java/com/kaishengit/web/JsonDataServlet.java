package com.kaishengit.web;

import com.google.gson.Gson;
import com.kaishengit.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jiahao0 on 2016/12/7.
 */
@WebServlet("/data.json")
public class JsonDataServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json;charset=UTF-8");

        User user = new User(1,"lisi","北京");
        User user1 = new User(2,"粒粒" ,"河南");
        User user2 = new User(5,"wangwu","usa");

        List<User> list = Arrays.asList(user,user1,user2);
        /*List<User> list = new ArrayList<>();
        list.add(user);
        list.add(user1);
        list.add(user2);*/

        Gson gson = new Gson();
        String json = gson.toJson(list);

        PrintWriter out = resp.getWriter();
        out.print(json);
        out.flush();
        out.close();

    }
}
