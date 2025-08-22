package com.example.TodoSpringApi;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeMonitorAspect {

    @Around("@annotation(TimeMonitor)")
    public void logTime(ProceedingJoinPoint joinPoint){
        long startTime = System.currentTimeMillis();  // start time of code
        try {
            // execute the joint point
            joinPoint.proceed();
        } catch (Throwable throwable) {
            System.out.println("Something went wrong during execution..");
        } finally {
            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;

            System.out.println("Execution time of is: " + duration + " ms..");
        }

    }
}
