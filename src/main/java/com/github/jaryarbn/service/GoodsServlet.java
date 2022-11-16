package com.github.jaryarbn.service;


import com.github.jaryarbn.dao.DataBase;
import com.github.jaryarbn.entity.Goods;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet
public class GoodsServlet extends HttpServlet {
    public static List<Goods> goods = new ArrayList<Goods>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String path = req.getServletPath();
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        if ("/show.goods".equals(path)) {
            show(req, resp);
        }

    }

    protected void show(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        DataBase db = new DataBase();

        try (ResultSet rs = db.getData("SELECT * FROM t_goods")) {
            while (rs.next()) {
                Goods g = new Goods();
                g.setGoodsName(rs.getString(2));
                g.setPrice(rs.getDouble(3));
                goods.add(g);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("goods", goods);
        req.getRequestDispatcher("list.jsp").forward(req, resp);
        goods.clear();
        db.close();
    }
}
