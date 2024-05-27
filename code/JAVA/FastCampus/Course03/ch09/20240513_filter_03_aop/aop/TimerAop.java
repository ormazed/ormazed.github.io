package com.example.filter.aop;

import com.example.filter.model.UserRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.Arrays;
import java.util.Objects;

@Aspect  // Pointcut + Advice
@Component
public class TimerAop {

    @Pointcut(value = "within(com.example.filter.controller.UserApiController)")  // UserApiContorller 가 실행되어야함을 알려줌
    public void timerPointCut(){}

    @Before(value = "timerPointCut()")
    public void before(JoinPoint joinPoint){
        System.out.println("before");
    }

    @After(value = "timerPointCut()")
    public void after(JoinPoint joinPoint){
        System.out.println("after");
    }

    @AfterReturning(value = "timerPointCut()", returning = "result") // afterReturning= 예외가 발생하지 않았을 때
    public void afterReturning(JoinPoint joinPoint, Objects result){
        System.out.println("afterReturning");
    }

    @AfterThrowing(value = "timerPointCut()", throwing = "tx")  // afterThrowing= 예외가 발생했을 때
    public void afterThrowing(JoinPoint joinPoint, Throwable tx){
        System.out.println("afterReturning");
    }

    @Around(value = "timerPointCut()")
    // ProceedingJoinPoint : Spring AOP에서 Advice를 실행하는 데 사용되는 객체
    public void around(ProceedingJoinPoint joinPoint) throws Throwable{ // around = 예외가 발생한 경우 + 발생하지 않을 경우
        System.out.println("메소드 실행 이전");

        Arrays.stream(joinPoint.getArgs()).forEach(
                it -> {
                    if(it instanceof UserRequest){
                        var tempUser = (UserRequest)it;
                        var phoneNumber = tempUser.getPhoneNumber().replace("-", "");
                        tempUser.setPhoneNumber(phoneNumber);
                    }
                }
        );

        var newObj = Arrays.asList(
                new UserRequest()
        );
        var stopWatch = new StopWatch();
        stopWatch.start();
        joinPoint.proceed(newObj.toArray());

        stopWatch.stop();
        System.out.println("총 소요된 시간 : " + stopWatch.getTotalTimeMillis());
        System.out.println("메소드 실행이후");
    }
}
/*
// 정상적인 경우 log
        메소드 실행 이전  => around 동작
        before => before 동작
        2024-05-13 23:57:21.033  INFO 43388 --- [nio-8080-exec-1] c.e.filter.controller.UserApiController  : UserRequest(name=null, phoneNumber=null, email=null, age=null) => 메서드 동작
        after => after 동작
        총 소요된 시간 : 21
        메소드 실행이후
*/
/*
    // 에러를 발생시킨 경우 log
        메소드 실행 이전
        before
        2024-05-14 00:00:28.731  INFO 45732 --- [nio-8080-exec-1] c.e.filter.controller.UserApiController  : UserRequest(name=null, phoneNumber=null, email=null, age=null)
        afterReturning
        after
        2024-05-14 00:00:28.749 ERROR 45732 --- [nio-8080-exec-1] o.a.c.c.C.[.[.[/].[dispatcherServlet]    : Servlet.service() for servlet [dispatcherServlet] in context with path [] threw exception [Request processing failed; nested exception is java.lang.NumberFormatException: ] with root cause
        java.lang.NumberFormatException:
        at com.example.filter.controller.UserApiController.register(UserApiController.java:19) ~[main/:na]

 */