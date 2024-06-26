package org.delivery.api.interceptor;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Interceptor;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RequiredArgsConstructor
@Component
public class AuthorizationInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
            log.info("Authorization Interceptor url : {}", request.getRequestURI());

            // WEB ; chrome 의 경우 GET, POST 외 OPTION 메서드도 필요하다 => 사용가능한 Method 를 확인하기 위함
        if(HttpMethod.OPTIONS.matches(request.getMethod())){
            return true;
        }

        // js, html, png resource 일 경우 pass
        if(handler instanceof ResourceHttpRequestHandler){
            return true;
        }

        // TODO header 검증

        return true;
    }
}
