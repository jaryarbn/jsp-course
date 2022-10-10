package com.example.demo;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;


@WebServlet("/test")
public class TestServlet implements Servlet {

    public TestServlet() {
        System.out.println("我是构造器！");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("我是init！");
    }

    @Override
    public ServletConfig getServletConfig() {
        System.out.println("我是getServletConfig！");
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("我是service！");
    }

    @Override
    public String getServletInfo() {
        System.out.println("我是getServletInfo！");
        return null;
    }

    public void destroy() {
        System.out.println("我是destroy！");
    }
}