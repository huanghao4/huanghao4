package com.huanghao.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;
// 2 way of mapping filter to servlet
//way 1 use web.xml
//way 2 use WebFilter

@WebFilter(filterName = "HelloFilter",
urlPatterns = {"/home","/login","/register.jsp"}
)
//test 1:url/hello-filter is only for one Servlet - HelloServlet
//test 2:url/* -this filter of for all servlet
//test 3:3 url - this filter for these 3 url only
public class HelloFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
        System.out.println("i a in HelloFilter-->init()");
    }

    public void destroy() {
        System.out.println("i a in HelloFilter-->destroy()");

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("i a in HelloFilter-->doFilter()-before servlet-(request come here)");

        chain.doFilter(request, response);
        System.out.println("i a in HelloFilter-->doFilter()-after servlet-(request come here)");
    }
}
