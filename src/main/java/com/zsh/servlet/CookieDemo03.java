package com.zsh.servlet;

import com.sun.org.apache.xpath.internal.operations.String;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;

public class CookieDemo03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setHeader("Content-type","text/html;charset=UTF-8");
        Cookie[] cookies=   req.getCookies();//cookies存在多个
        PrintWriter out=resp.getWriter();
        //判断Cookie是否存在
        if (cookies!=null){
//如果存在
            out.write("你上一次访问的时间是：");
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                //获取cookie的名字
                if (cookie.getName().equals("name")) {
                    URLDecoder.decode(cookie.getValue(),"UTF-8");
                    out.write(cookie.getValue());
                }
            }
        }else {
            out.write("这是您第一次访问本站");
        }


        Cookie cookie=new Cookie("name","郑书海");
      resp.addCookie(cookie);
    }

    @Override
    protected long getLastModified(HttpServletRequest req) {
        return super.getLastModified(req);
    }
}
