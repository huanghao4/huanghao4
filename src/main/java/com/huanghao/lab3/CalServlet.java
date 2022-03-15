package com.huanghao.lab3;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CalServlet", value = "/cal")
public class CalServlet extends HttpServlet {
    public double add(double firstVal,double secondVal){
        double a;
        a=firstVal+secondVal;
        return a;
    }
    public double subtract(double firstVal,double secondVal){
        double a;
        a=firstVal-secondVal;
        return a;
    }
    public double multiply(double firstVal,double secondVal){
        double a;
        a=firstVal*secondVal;
        return a;
    }
    public double divide(double firstVal,double secondVal){
        double a;
        a=firstVal/secondVal;
        return a;
    }
    public int computeLength(String name){
        int a;
        a=name.length();
        return a;
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //request.getRequestDispatcher("/Lab3/cal.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double firstVal=Double.parseDouble(request.getParameter("FirstVal"));
        double secondVal=Double.parseDouble(request.getParameter("SecondVal"));
        String name=request.getParameter("Name");
        String action=request.getParameter("action");
        Double result=0.0;
        int result1=0;

        if (action.equals("Add")||action.equals("Subtract")||action.equals("Multiply")||action.equals("Divide")){
            if (action.equals("Add")){
                result=add(firstVal,secondVal);
            }else if (action.equals("Subtract")){
                result=subtract(firstVal,secondVal);
            }else if (action.equals("Multiply")){
                result=multiply(firstVal,secondVal);
            }else if (action.equals("Divide")){
                result=divide(firstVal,secondVal);
            }
            Cookie FirstCookie=new Cookie("cFirstVal",String.valueOf(firstVal));
            Cookie SecondCookie=new Cookie("cSecondVal",String.valueOf(secondVal));
            Cookie ResultCookie=new Cookie("cResult",String.valueOf(result));

            FirstCookie.setMaxAge(60);
            SecondCookie.setMaxAge(60);
            ResultCookie.setMaxAge(60);
            response.addCookie(FirstCookie);
            response.addCookie(SecondCookie);
            response.addCookie(ResultCookie);
        }else if (action.equals("Compute")){
            result1=computeLength(name);

            Cookie NameCookie=new Cookie("cName",request.getParameter("Name"));
            Cookie LengthCookie=new Cookie("cLength",String.valueOf(result1));

            NameCookie.setMaxAge(60);
            LengthCookie.setMaxAge(60);
            response.addCookie(NameCookie);
            response.addCookie(LengthCookie);

        }
        response.sendRedirect("Lab3/cal.jsp");
    }
}
