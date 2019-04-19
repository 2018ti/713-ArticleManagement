package com.hubu713.config;

import com.hubu713.interceptor.MyIterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
/**
 *@ClassName MyMvcConfig
 *@Description 注册拦截器
 *@Author 龚佳民
 *@Date 2019/4/11
 **/

    /**
     * @Description 除登陆注册的请求不被拦截，
     * 若未登陆，则被拦截，进入不了控制器，则前端得到的数据为空，
     * 那么由前端负责弹出提示，然后跳转到登陆页面
     * @Date  2019/4/11
     * @Author 龚佳民
     **/
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String[] excludePath={"/index.html","/login.html","/userRegist","/userLogin","/js/**","/bs/**","/font/**","/style/**","/picture/**"};
        registry.addInterceptor(new MyIterceptor()).addPathPatterns("/**").excludePathPatterns(excludePath);
    }
}
