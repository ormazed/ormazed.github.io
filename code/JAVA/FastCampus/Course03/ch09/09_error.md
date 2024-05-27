# Error 정리

__[Error01]__
```
2024-05-13 21:58:15.626  INFO 64280 --- [nio-8080-exec-1] com.example.filter.filter.LoggerFilter   : >>>>> 진입 전: 
2024-05-13 21:58:15.630  INFO 64280 --- [nio-8080-exec-1] com.example.filter.filter.LoggerFilter   : {
2024-05-13 21:58:15.631  INFO 64280 --- [nio-8080-exec-1] com.example.filter.filter.LoggerFilter   : "name" :"홍길동",
2024-05-13 21:58:15.631  INFO 64280 --- [nio-8080-exec-1] com.example.filter.filter.LoggerFilter   : "phoneNumber" :"010-1111-2222",
2024-05-13 21:58:15.631  INFO 64280 --- [nio-8080-exec-1] com.example.filter.filter.LoggerFilter   : "email" : "hong@email.com",
2024-05-13 21:58:15.631  INFO 64280 --- [nio-8080-exec-1] com.example.filter.filter.LoggerFilter   : "age" :"44"
2024-05-13 21:58:15.631  INFO 64280 --- [nio-8080-exec-1] com.example.filter.filter.LoggerFilter   : }
2024-05-13 21:58:15.678 ERROR 64280 --- [nio-8080-exec-1] o.a.c.c.C.[.[.[/].[dispatcherServlet]    : Servlet.service() for servlet [dispatcherServlet] in context with path [] threw exception [Request processing failed; nested exception is java.lang.IllegalStateException: getReader() has already been called for this request] with root cause

java.lang.IllegalStateException: getReader() has already been called for this request
	at org.apache.catalina.connector.Request.getInputStream(Request.java:1054) ~[tomcat-embed-core-9.0.80.jar:9.0.80]
	at org.apache.catalina.connector.RequestFacade.getInputStream(RequestFacade.java:298) ~[tomcat-embed-core-9.0.80.jar:9.0.80]
	at javax.servlet.ServletRequestWrapper.getInputStream(ServletRequestWrapper.java:141) ~[tomcat-embed-core-9.0.80.jar:4.0.FR]
	at org.springframework.http.server.ServletServerHttpRequest.getBody(ServletServerHttpRequest.java:212) ~[spring-web-5.3.30.jar:5.3.30]
	at org.springframework.web.servlet.mvc.method.annotation.AbstractMessageConverterMethodArgumentResolver$EmptyBodyCheckingHttpInputMessage.<init>(AbstractMessageConverterMethodArgumentResolver.java:325) ~[spring-webmvc-5.3.30.jar:5.3.30]
	at org.springframework.web.servlet.mvc.method.annotation.AbstractMessageConverterMethodArgumentResolver.readWithMessageConverters(AbstractMessageConverterMethodArgumentResolver.java:174) ~[spring-webmvc-5.3.30.jar:5.3.30]
	at org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor.readWithMessageConverters(RequestResponseBodyMethodProcessor.java:160) ~[spring-webmvc-5.3.30.jar:5.3.30]
	at org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor.resolveArgument(RequestResponseBodyMethodProcessor.java:133) ~[spring-webmvc-5.3.30.jar:5.3.30]
	at org.springframework.web.method.support.HandlerMethodArgumentResolverComposite.resolveArgument(HandlerMethodArgumentResolverComposite.java:122) ~[spring-web-5.3.30.jar:5.3.30]
	at org.springframework.web.method.support.InvocableHandlerMethod.getMethodArgumentValues(InvocableHandlerMethod.java:179) ~[spring-web-5.3.30.jar:5.3.30]
	at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:146) ~[spring-web-5.3.30.jar:5.3.30]
	at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:117) ~[spring-webmvc-5.3.30.jar:5.3.30]
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:895) ~[spring-webmvc-5.3.30.jar:5.3.30]
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:808) ~[spring-webmvc-5.3.30.jar:5.3.30]
	at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87) ~[spring-webmvc-5.3.30.jar:5.3.30]
	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1072) ~[spring-webmvc-5.3.30.jar:5.3.30]
	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:965) ~[spring-webmvc-5.3.30.jar:5.3.30]
	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1006) ~[spring-webmvc-5.3.30.jar:5.3.30]
	at org.springframework.web.servlet.FrameworkServlet.doPost(FrameworkServlet.java:909) ~[spring-webmvc-5.3.30.jar:5.3.30]
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:555) ~[tomcat-embed-core-9.0.80.jar:4.0.FR]
	at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:883) ~[spring-webmvc-5.3.30.jar:5.3.30]
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:623) ~[tomcat-embed-core-9.0.80.jar:4.0.FR]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:209) ~[tomcat-embed-core-9.0.80.jar:9.0.80]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:153) ~[tomcat-embed-core-9.0.80.jar:9.0.80]
	at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:51) ~[tomcat-embed-websocket-9.0.80.jar:9.0.80]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:178) ~[tomcat-embed-core-9.0.80.jar:9.0.80]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:153) ~[tomcat-embed-core-9.0.80.jar:9.0.80]
	at com.example.filter.filter.LoggerFilter.doFilter(LoggerFilter.java:33) ~[main/:na]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:178) ~[tomcat-embed-core-9.0.80.jar:9.0.80]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:153) ~[tomcat-embed-core-9.0.80.jar:9.0.80]
	at org.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:100) ~[spring-web-5.3.30.jar:5.3.30]
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:117) ~[spring-web-5.3.30.jar:5.3.30]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:178) ~[tomcat-embed-core-9.0.80.jar:9.0.80]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:153) ~[tomcat-embed-core-9.0.80.jar:9.0.80]
	at org.springframework.web.filter.FormContentFilter.doFilterInternal(FormContentFilter.java:93) ~[spring-web-5.3.30.jar:5.3.30]
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:117) ~[spring-web-5.3.30.jar:5.3.30]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:178) ~[tomcat-embed-core-9.0.80.jar:9.0.80]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:153) ~[tomcat-embed-core-9.0.80.jar:9.0.80]
	at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:201) ~[spring-web-5.3.30.jar:5.3.30]
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:117) ~[spring-web-5.3.30.jar:5.3.30]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:178) ~[tomcat-embed-core-9.0.80.jar:9.0.80]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:153) ~[tomcat-embed-core-9.0.80.jar:9.0.80]
	at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:168) ~[tomcat-embed-core-9.0.80.jar:9.0.80]
	at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:90) ~[tomcat-embed-core-9.0.80.jar:9.0.80]
	at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:481) ~[tomcat-embed-core-9.0.80.jar:9.0.80]
	at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:130) ~[tomcat-embed-core-9.0.80.jar:9.0.80]
	at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:93) ~[tomcat-embed-core-9.0.80.jar:9.0.80]
	at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:74) ~[tomcat-embed-core-9.0.80.jar:9.0.80]
	at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:343) ~[tomcat-embed-core-9.0.80.jar:9.0.80]
	at org.apache.coyote.http11.Http11Processor.service(Http11Processor.java:390) ~[tomcat-embed-core-9.0.80.jar:9.0.80]
	at org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:63) ~[tomcat-embed-core-9.0.80.jar:9.0.80]
	at org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:926) ~[tomcat-embed-core-9.0.80.jar:9.0.80]
	at org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1790) ~[tomcat-embed-core-9.0.80.jar:9.0.80]
	at org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:52) ~[tomcat-embed-core-9.0.80.jar:9.0.80]
	at org.apache.tomcat.util.threads.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1191) ~[tomcat-embed-core-9.0.80.jar:9.0.80]
	at org.apache.tomcat.util.threads.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:659) ~[tomcat-embed-core-9.0.80.jar:9.0.80]
	at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61) ~[tomcat-embed-core-9.0.80.jar:9.0.80]
	at java.base/java.lang.Thread.run(Thread.java:833) ~[na:na]
```

ㅇ 참고 : https://aljjabaegi.tistory.com/683   


[@OpenApi 유]
```
2024-05-13 22:53:51.102  INFO 50328 --- [nio-8080-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
2024-05-13 22:53:51.102  INFO 50328 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2024-05-13 22:53:51.103  INFO 50328 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 1 ms
2024-05-13 22:53:51.111  INFO 50328 --- [nio-8080-exec-1] com.example.filter.filter.LoggerFilter   : >>>>> 진입 전: 
2024-05-13 22:53:51.134  INFO 50328 --- [nio-8080-exec-1] c.e.f.interceptor.OpenApiInterceptor     : pre handler
2024-05-13 22:53:51.135  INFO 50328 --- [nio-8080-exec-1] c.e.f.interceptor.OpenApiInterceptor     : class level
2024-05-13 22:53:51.143  INFO 50328 --- [nio-8080-exec-1] c.e.filter.controller.UserApiController  : hello
2024-05-13 22:53:51.162  INFO 50328 --- [nio-8080-exec-1] c.e.f.interceptor.OpenApiInterceptor     : post handle
2024-05-13 22:53:51.162  INFO 50328 --- [nio-8080-exec-1] c.e.f.interceptor.OpenApiInterceptor     : after completion
2024-05-13 22:53:51.163  INFO 50328 --- [nio-8080-exec-1] com.example.filter.filter.LoggerFilter   : req : 
2024-05-13 22:53:51.165  INFO 50328 --- [nio-8080-exec-1] com.example.filter.filter.LoggerFilter   : res : 
2024-05-13 22:53:51.165  INFO 50328 --- [nio-8080-exec-1] com.example.filter.filter.LoggerFilter   : <<<<< 진입 후: 
```
*************************************************
[@OpenApi 무]
```
2024-05-13 22:54:30.729  INFO 58060 --- [nio-8080-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
2024-05-13 22:54:30.729  INFO 58060 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2024-05-13 22:54:30.731  INFO 58060 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 2 ms
2024-05-13 22:54:30.739  INFO 58060 --- [nio-8080-exec-1] com.example.filter.filter.LoggerFilter   : >>>>> 진입 전: 
2024-05-13 22:54:30.767  INFO 58060 --- [nio-8080-exec-1] c.e.f.interceptor.OpenApiInterceptor     : pre handler
2024-05-13 22:54:30.767  INFO 58060 --- [nio-8080-exec-1] c.e.f.interceptor.OpenApiInterceptor     : open api 아닙니다. /api/user/hello
2024-05-13 22:54:30.769  INFO 58060 --- [nio-8080-exec-1] com.example.filter.filter.LoggerFilter   : req : 
2024-05-13 22:54:30.769  INFO 58060 --- [nio-8080-exec-1] com.example.filter.filter.LoggerFilter   : res : 
2024-05-13 22:54:30.769  INFO 58060 --- [nio-8080-exec-1] com.example.filter.filter.LoggerFilter   : <<<<< 진입 후: 
```