package com.ybb.interceptor;

import com.ybb.constant.JwtClaimsConstant;
import com.ybb.context.BaseContext;
import com.ybb.properties.JwtProperties;
import com.ybb.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@Slf4j
public class JwtApiTokenInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtProperties jwtProperties;

    @Override
    public boolean preHandle(@NonNull HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //判断当前拦截到的是Controller的方法还是其他资源
        if (!(handler instanceof HandlerMethod)) {
            //当前拦截到的不是动态方法，直接放行
            return true;
        }

        //从请求头中获取令牌
        String jwtToken = request.getHeader(jwtProperties.getJwtTokenName());
        //校验token
        log.info("jwt校验: {}", jwtToken);
        Claims claims = JwtUtil.parseJWT(jwtProperties.getJwtSecretKey(), jwtToken);
        if (claims != null && claims.size() > 0) {
            String currentUserId = String.valueOf(claims.get(JwtClaimsConstant.USER_ID));
            log.info("jwt校验通过,当前用户Id是: {}", currentUserId);
            //保存到当前线程
            BaseContext.setCurrentUserId(currentUserId);
            return true;
        }else{
            log.info("jwt校验不通过,当前用户Id是 null");
            return false;
        }
    }
}
