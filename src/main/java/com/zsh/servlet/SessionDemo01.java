package com.zsh.servlet;

import com.zsh.pojo.Person;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class SessionDemo01  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("UTF-8");
        //得到session
        HttpSession session=req.getSession();
        //给session中存东西
        session.setAttribute("name",new Person("郑书海",21));
        //获取session的ID
        String sessionId=session.getId();
        //判断是不是新的session
        if (session.isNew()){
          resp.getWriter().write("session创建成功,ID:"+sessionId);
        }else {
            resp.getWriter().write("session已经在服务器中存在了,ID:"+sessionId);
        }
//
//Cookie cookie=new Cookie("JSESSIONID", sessionId);
//     resp.addCookie(cookie);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
