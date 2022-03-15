package AnnotatinProfiler;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ProfilerAspect {
    @Pointcut("@annotation(AnnotatinProfiler.Profiler)&&execution(* com.abc.Test.*(..))")
    public void timeCount() {

    }

    @Around("timeCount()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint)throws Throwable {
        Object obj =null;
        String methodName = proceedingJoinPoint.getSignature().getName();
        String className = proceedingJoinPoint.getSignature().getDeclaringTypeName();
        try {
            Long startTime = System.currentTimeMillis();
            obj = proceedingJoinPoint.proceed();
            Long endTime = System.currentTimeMillis();
            System.out.println(className + "." + methodName + "方法耗时:" + (endTime - startTime) + "ms");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return obj;
    }

}
