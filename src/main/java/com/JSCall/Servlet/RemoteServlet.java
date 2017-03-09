package com.JSCall.Servlet;
//http://www.jb51.net/article/96107.htm
//http://blog.csdn.net/zndxlxm/article/details/7875787
//http://blog.csdn.net/linjiaxingqqqq/article/details/7335858
//http://www.2cto.com/kf/201103/85143.html
import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RemoteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public RemoteServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        remote(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        remote(request, response);
    }
    protected void remote(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("class");
        String method = request.getParameter("method");
        String args = request.getParameter("args");
        if(name != null && method != null){
            try{
                Class cls = Class.forName(name);
                Object[] parames = !args.equals("") ? args.split(";") : null;
                Object obj = cls.newInstance();
                Method[] methods = cls.getMethods();
               
                for(Method m:methods){
                    System.out.println(m.getName());
                    if(m.getName().equals(method)){
                        Object result = parames != null ? m.invoke(obj,parames) : m.invoke(obj);
                        response.setCharacterEncoding("UTF-8");
                        response.getWriter().println(result.toString());
                        break;
                    }
                }   
            }
            catch(Exception e){
                e.printStackTrace();
            }
           
        }
    }
}
