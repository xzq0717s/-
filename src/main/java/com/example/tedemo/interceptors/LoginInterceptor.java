package com.example.tedemo.interceptors;

import com.example.tedemo.pojo.result;
import com.example.tedemo.utils.JwtUtil;
import com.example.tedemo.utils.ThreadLocalUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.List;
import java.util.Map;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");
        try {
            Map<String,Object> claims = JwtUtil.parseToken(token);
            ThreadLocalUtil.set(claims);
            Map<String,Object> map = ThreadLocalUtil.get();
            String power = (String) map.get("power");
            if (request.getRequestURI().equals("/power/powerUserList") & !power.equals("管理员")){
                response.setStatus(402);
                return false;
            }
            if (request.getRequestURI().equals("/power/powerUserList") & !power.equals("管理员")){
                response.setStatus(402);
                return false;
            }
            if (request.getRequestURI().equals("/power/updatePower") & !power.equals("管理员")){
                response.setStatus(402);
                return false;
            }

            if (request.getRequestURI().equals("/power/deletePower") & !power.equals("管理员")){
                response.setStatus(402);
                return false;
            }

            if (request.getRequestURI().equals("/user/register") & !power.equals("管理员")){
                response.setStatus(402);
                return false;
            }

            return true;
        } catch (Exception e) {
            response.setStatus(401);
            return false;
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        ThreadLocalUtil.remove();
    }
}
