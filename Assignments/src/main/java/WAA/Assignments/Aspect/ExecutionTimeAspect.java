package WAA.Assignments.Aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ExecutionTimeAspect {

    @Pointcut("@annotation(WAA.Assignments.Annotation.ExecutionTime)")
    public  void execute(){}

    @Around("execute()")
    public void calculateExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable{
        long start = System.nanoTime();
        joinPoint.proceed();
        long finish = System.nanoTime();

        System.out.println( "method executed in : " + ((finish-start) / 1000000000.0));
    }

}
