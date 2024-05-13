package com.example.filter.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.util.stream.Collectors;

@Slf4j
@Component // 해당 클래스를 spring bin 으로 등록함을 선언함
public class LoggerFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
     // 진입 전
        log.info(">>>>> 진입 전: ");
        /*var req = new HttpServletRequestWrapper((HttpServletRequest) request);
        var res = new HttpServletResponseWrapper((HttpServletResponse) response);*/

        var req = new ContentCachingRequestWrapper((HttpServletRequest) request);
        var res = new ContentCachingResponseWrapper((HttpServletResponse) response);
/*
        var br = req.getReader();
        var list = br.lines().collect(Collectors.toList());

        list.forEach(it -> {
            log.info("{}", it);
                }
         );
*/
        chain.doFilter(req, res);

        var reqJson = new String(req.getContentAsByteArray());
        log.info("req : {}", reqJson);

        var resJson = new String(res.getContentAsByteArray());
        log.info("res : {}", resJson);


    // 진입 후
        log.info("<<<<< 진입 후: ");

        res.copyBodyToResponse();
    }
}

/*
2024-05-12 22:44:50.400  INFO 78396 --- [nio-8080-exec-1] com.example.filter.filter.LoggerFilter   : >>>>> 진입 전:
2024-05-12 22:44:50.524  INFO 78396 --- [nio-8080-exec-1] c.e.filter.controller.UserApiController  : UserRequest(name=홍길동, phoneNumber=null, email=hong@email.com, age=44)
2024-05-12 22:44:50.565  INFO 78396 --- [nio-8080-exec-1] com.example.filter.filter.LoggerFilter   : <<<<< 진입 후:


2024-05-12 22:47:48.469  INFO 12680 --- [nio-8080-exec-1] com.example.filter.filter.LoggerFilter   : >>>>> 진입 전:
2024-05-12 22:47:48.599  INFO 12680 --- [nio-8080-exec-1] c.e.filter.controller.UserApiController  : UserRequest(name=홍길동, phoneNumber=null, email=hong@email.com, age=44)
2024-05-12 22:47:48.636  INFO 12680 --- [nio-8080-exec-1] com.example.filter.filter.LoggerFilter   : <<<<< 진입 후:

*/


