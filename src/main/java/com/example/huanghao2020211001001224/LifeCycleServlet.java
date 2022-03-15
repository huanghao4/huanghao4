package com.example.huanghao2020211001001224;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet("/life")
public class LifeCycleServlet extends HttpServlet {

    Connection con=null;
        public LifeCycleServlet(){
            System.out.println("i am in constructor()");
        }

        @Override
        public void init() throws ServletException{
            //use  in manyservlet
            //ddemo #3- use Serletcontext
            ServletContext context=getServletContext();
            String driver=context.getInitParameter("driver");
            String url=context.getInitParameter("url");
            String username=context.getInitParameter("username");
            String password=context.getInitParameter("password");

            try {
                Class.forName(driver);
                con= DriverManager.getConnection(url,username,password);
                System.out.println("Connection --> in JDBCDemoServlet"+con);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println("i am in init()->LifeCycleServlet-->"+con);
        }

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            System.out.println("i am in doGet()");
        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("i am in doPost()");
        }

        @Override
        public void destroy() {
            System.out.println("i am in destroy()");
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


