package com.github.jaryarbn.servlet;

import com.github.jaryarbn.dao.DataBase;
import com.github.jaryarbn.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(urlPatterns = "*.user", name = "UserServlet", loadOnStartup = 1)
public class UserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        if ("/login.user".equals(path)) {
            login(req, resp);
        }
        if ("/register.user".equals(path)) {
            register(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        if ("/logout.user".equals(path)) {
            logout(req, resp);
        }
        if ("/check.user".equals(path)) {
            check(req, resp);
        }
    }

    protected void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");

        // 获取用户输入的验证码
        String checkCode = req.getParameter("checkCode");

        // 程序生成的验证码，从Session获取
        HttpSession session = req.getSession();
        String checkCodeGenerate = (String) session.getAttribute("checkCodeGenerate");

        // 比对验证码
        if (!checkCodeGenerate.equalsIgnoreCase(checkCode)) {

            req.setAttribute("msg", "验证码错误！！");
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
            // 不允许注册
            return;
        }

        DataBase db = new DataBase();
        ResultSet rs = db.getData("SELECT * FROM t_user where un='" + username + "'");
        try {
            if (rs.next()) {
                req.setAttribute("msg", "用户名已注册，请重新注册！！！");
                req.getRequestDispatcher("/register.jsp").forward(req, resp);
                rs.close();
                db.close();
                return;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String sql = "insert into t_user(un,pwd,phone,addr) values('" + username + "','" + password + "','" + phone + "','" + address + "')";
        db.setData(sql);
        resp.sendRedirect(req.getContextPath() + "/login.jsp");
        db.close();
    }

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        String remember = req.getParameter("remember");
        HttpSession session = req.getSession();
        DataBase db = new DataBase();
        ResultSet rs = db.getData("SELECT * FROM t_user where un='" + username + "' and pwd='" + password + "'");
        try {
            // 登录成功
            if (rs.next()) {
                // 判断用户是否勾选记住密码
                if ("1".equals(remember)) {
                    // 创建Cookie对象
                    Cookie c_username = new Cookie("username", username);
                    Cookie c_password = new Cookie("password", password);
                    // 设置Cookie的存活时间
                    c_username.setMaxAge(60 * 60 * 24 * 7);
                    c_password.setMaxAge(60 * 60 * 24 * 7);
                    // 发送Cookie到Browser
                    resp.addCookie(c_username);
                    resp.addCookie(c_password);
                }
                User u = new User();
                u.setUsername(rs.getString(1));
                u.setPassword(rs.getString(2));
                u.setPhone(rs.getString(3));
                u.setAddress(rs.getString(4));
                session.setAttribute("user", u);
                resp.sendRedirect(req.getContextPath() + "/show.goods");
                return;
            } else {
                // 登录失败
                req.setAttribute("msg", "用户名或密码错误！！！");
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        db.close();
    }

    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        session.invalidate();
        resp.sendRedirect(req.getContextPath() + "/show.goods");
    }

    protected void check(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        User u = (User) req.getSession().getAttribute("user");
        if (u == null) {
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
            return;
        }
        String tag = req.getParameter("tag");
        if ("AddCart".equals(tag)) {
            String index = req.getParameter("index");
            resp.sendRedirect(req.getContextPath() + "/add.cart?index=" + index);
        } else {
            resp.sendRedirect(req.getContextPath() + "/show.cart");
        }
    }
}
