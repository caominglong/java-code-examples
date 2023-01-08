package com.banmao.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/12/29 下午3:26
 * @description
 */
public class RequestAPIServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求的资源路径
        System.out.println("URI：" + req.getRequestURI()); // /javaweb01/requestAPIServlet
        // 获取请求的统一资源定位符（绝对路径）
        System.out.println("URL：" + req.getRequestURL());// http://localhost:8093/javaweb01/requestAPIServlet
        // 获取客户端的ip地址(真实的客户端的ip地址)
        System.out.println("客户端ip地址 => " + req.getRemoteHost());
        // 获取请求头
        System.out.println("请求头User-Agent信息：" + req.getHeader("User-Agent"));
        // 获取请求的方式Get或Post
        System.out.println("请求的方式：" + req.getMethod());
    }
}