package com.spring.interceptores.Interceptores;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class LogInterceptor implements HandlerInterceptor {

    // Metodo a ejecutar antes del controlador
    @Override
    public boolean preHandle (HttpServletRequest request, HttpServletResponse response,
                                Object handler) throws Exception {
        System.out.println("Interceptando peticion ... " + request.getRequestURI());
        return true;
    }

    // Despues del controlador pero antes de la vista
    @Override
    public void postHandle (HttpServletRequest request, HttpServletResponse response,
                               Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("Post handle ejecutado para: " + request.getRequestURI());
    }

    // Despues de renderizar la vista
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ERROR)
        throws Exception {
        System.out.println("Ejecucion completada para : " + request.getRequestURI());
    }
}
