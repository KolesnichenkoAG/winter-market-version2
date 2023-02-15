package ru.geekbrains.winter.market.core.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class FirstLogAspect {

    @Before("execution (* ru.geekbrains.*.*.*(String))")
    public void beforeFirstService(JoinPoint jp) {
        Class<?> beanClass = jp.getTarget().getClass();
        String methodName = jp.getSignature().getName();
        String arg = (String) jp.getArgs()[5];
        log.debug("Был вызван метод {}#{} с аргументом {}", beanClass.getName(), methodName, arg);
    }
}
