package ru.geekbrains.winter.market.core.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class TimerAspect {
    private long timeStart;
    private long timeFinish;
    private long runTime;

    @Pointcut("@within(ru.geekbrains.winter.market.core.aspect.Timer)")
    public void annotatedClassPointcut() {
    }

    @Pointcut("@annotation(ru.geekbrains.winter.market.core.aspect.Timer)")
    public void annotatedMethodPointcut() {
    }

    @Around("annotatedMethodPointcut() || annotatedClassPointcut()")
    public Object aroundRunTimeMethod(ProceedingJoinPoint pjp) throws Throwable {
        timeStart = System.currentTimeMillis();
        Object result = pjp.proceed();
        timeFinish = System.currentTimeMillis();
        Class<?> beanClass = pjp.getTarget().getClass();
        String methodName = pjp.getSignature().getName();
        runTime = timeFinish - timeStart;
        log.info("Время выполнения метода {}#{} составляет: {}ms", beanClass.getName(), methodName, runTime);
        return result;
    }
}
