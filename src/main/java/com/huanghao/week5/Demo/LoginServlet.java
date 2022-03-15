package com.huanghao.week5.Demo;



import com.huanghao.dao.UserDao;
import com.huanghao.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.*;
import java.util.List;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    Connection con = null;
    Statement stmt = null;

    @Override
    public void init() throws ServletException {
        super.init();
//        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";//name=value
//        String url = "jdbc:sqlserver://localhost:1433;DatabaseName=register;encrypt=false";
//        String username = "huanghao";
//        String password = "123456";
//        try {
//            Class.forName(driver);
//            System.out.println("成功");
//            con = DriverManager.getConnection(url, username, password);
//            System.out.println("连接成功");
//            System.out.println("连接成功");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
        con= (Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //now move jdbc code in dao -MVC design
        //write mvc code
        //use model and dao
        UserDao userDao=new UserDao();
        try {

            User user=userDao.findByUsernamePassword(con,username,password);
            //List<User> user=  userDao.findByUsername(con,username);
            //foreword -jsp
            if (user!=null){
                //week 8 code
                //create session
                String rememberMe=request.getParameter("rememberMe");
                if (rememberMe!=null&& rememberMe.equals("1") ){
                    Cookie usernameCookie=new Cookie("cUsername",user.getUsername().trim());
                    Cookie passwordCookie=new Cookie("cPassword",user.getPassword().trim());
                    Cookie rememberMeCookie=new Cookie("cRememberMe",rememberMe);

                    System.out.println(user.getUsername().trim());

                    usernameCookie.setMaxAge(5);
                    passwordCookie.setMaxAge(5);
                    rememberMeCookie.setMaxAge(5);

                    System.out.println("u:"+usernameCookie.getValue());
                    System.out.println("r:"+rememberMeCookie.getValue());
                    response.addCookie(usernameCookie);
                    response.addCookie(passwordCookie);
                    response.addCookie(rememberMeCookie);



                }

                HttpSession session=request.getSession();
                System.out.println("session id-->"+session.getId());
                session.setMaxInactiveInterval(10);

                //week 8 code #demo1-use cookie for session
                //step 1 :create an object of cookie class
//                Cookie c=new Cookie("sessionid",""+user.getId());
                //step 2 :set ang of cookie
//                c.setMaxAge(10*60);//in   sec -10min-7days - 7*24*60*60
                //step 3 :add cookie into response
//                response.addCookie(c);

                session.setAttribute("user",user);
                request.getRequestDispatcher("WEB-INF/views/userinfo.jsp").forward(request,response);
            }else {
                request.setAttribute("message","Username or password Error!");
                request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }





//
//        try {
//            stmt = con.createStatement();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        try {
//            ResultSet rs = stmt.executeQuery("select * from usertable where username='" + username + "' and password='" + password + "'");
//            if (rs.next()) {
//                //week 5 code
//                //PrintWriter writer = response.getWriter();
//                //writer.println("Login Success!!!");
//                //writer.println("Welcome"+username);
//                request.setAttribute("id",rs.getInt("id"));
//                request.setAttribute("username",rs.getString("username"));
//                request.setAttribute("password",rs.getString("password"));
//                request.setAttribute("email",rs.getString("email"));
//                request.setAttribute("sex",rs.getString("sex"));
//                request.setAttribute("birth",rs.getString("birth"));
//                request.getRequestDispatcher("userinfo.jsp").forward(request,response);
//            }else{
//                request.setAttribute("message","Username or password Error!");
//                request.getRequestDispatcher("login.jsp").forward(request,response);
//
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }


    }
}
