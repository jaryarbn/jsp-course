package com.github.jaryarbn.servlet;

import com.github.jaryarbn.mysql.DataBase;
import com.github.jaryarbn.entity.Cart;
import com.github.jaryarbn.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "*.cart", name = "CartServlet",loadOnStartup = 1)
public class CartServlet extends HttpServlet {
    public static List<Cart> cart = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        if ("/add.cart".equals(path)) {
            add(req, resp);
        }
        if ("/show.cart".equals(path)) {
            show(req, resp);
        }
        if ("/delete.cart".equals(path)) {
            delete(req, resp);
        }
    }

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String index = req.getParameter("index");
        User u = (User) req.getSession().getAttribute("user");
        String username = u.getUsername();
        DataBase db = new DataBase();
        ResultSet rs = db.getData("SELECT * FROM t_goods where goods_id=" + index);
        String goodsname = "";
        BigDecimal price = BigDecimal.valueOf(0.0);
        try {
            if (rs.next()) {
                goodsname = rs.getString(2);
                price = BigDecimal.valueOf(rs.getDouble(3));
            } else {
                System.out.println("获取出错！！！");
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        rs = db.getData("SELECT * FROM t_cart  where goods_name='" + goodsname + "' and un='" + username + "'");
        try {
            if (rs.next()) {
                String sql = "UPDATE t_cart SET number=" + (rs.getInt("number") + 1) + ",price=" + (price.multiply(BigDecimal.valueOf(rs.getInt("number") + 1))) + " where goods_name='" + goodsname + "' and un='" + username + "'";
                db.setData(sql);
                req.setAttribute("msg", "商品" + goodsname + "加入购物车成功！");
                req.getRequestDispatcher("/show.goods").forward(req, resp);
            } else {
                String sql = "insert into t_cart(goods_name,number,price,un) values('" + goodsname + "',1,'" + price + "','" + username + "')";
                System.out.print(sql);
                db.setData(sql);
                req.setAttribute("msg", "商品" + goodsname + "加入购物车成功！");
                req.getRequestDispatcher("/show.goods").forward(req, resp);
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

    protected void show(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User u = (User) req.getSession().getAttribute("user");
        String username = u.getUsername();
        DataBase db = new DataBase();
        ResultSet rs = db.getData("SELECT * FROM t_cart where un='" + username + "'");

        try {
            while (rs.next()) {
                Cart c = new Cart();
                c.setGoodsName(rs.getString(1));
                c.setNumber(rs.getInt(2));
                c.setPrice(rs.getBigDecimal(3));
                c.setUsername(username);
                cart.add(c);

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
        req.setAttribute("cart", cart);
        req.getRequestDispatcher("cart.jsp").forward(req, resp);
        cart.clear();
        db.close();
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataBase db = new DataBase();
        String type = req.getParameter("type");
        //清空
        if ("All".equals(type)) {
            String sql = "DELETE FROM t_cart";
            db.setData(sql);
            resp.sendRedirect(req.getContextPath() + "/show.cart");
        }
        //删除某个
        else {
            String goodsName = req.getParameter("goods_name");
//			byte[] b=goods_name.getBytes("ISO8859-1");
//			goods_name=new String(b,"utf-8");
//			这里取得的编码是utf-8不做处理，tomcat版本不同返回的值编码可能不一样，如果中文乱码，则对编码进行处理
            String sql = "DELETE FROM t_cart WHERE goods_name = '" + goodsName + "' ";
            db.setData(sql);
            resp.sendRedirect(req.getContextPath() + "/show.cart");
        }
        db.close();
    }

}
