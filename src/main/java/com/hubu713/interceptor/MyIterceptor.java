package com.hubu713.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyIterceptor implements HandlerInterceptor {
/**
 *@ClassName MyIterceptor
 *@Description 定义拦截器
 *@Author 龚佳民
 *@Date 2019/4/11
 **/
//进入控制器之前执行,由注册登陆功能的同学把username存入session中，

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String username = (String) request.getSession().getAttribute("username");
        //System.out.println(request.getRequestURI());
        //System.out.println(username);
        if (username==null){
            response.sendRedirect("/login.html");
            return false;
        }else {
            return true;
        }
    }
//进入控制器之后执行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }
//视图渲染之后执行
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
