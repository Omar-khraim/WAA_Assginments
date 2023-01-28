package WAA.Assignments.Aspect;

import jakarta.servlet.http.HttpServletRequest;
import org.apache.catalina.connector.Request;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ReturnTypeAspect {


//   @Pointcut("execution (public WAA.Assignments.DTO.User.UserDTO *())")
//    @Pointcut("within(WAA.Assignments.DTO.User.UserDTO)")
    @Pointcut("target(WAA.Assignments.DTO.User.UserDTO)")
//    @Pointcut("args(long)")
    public void execute(){}

    @After("execute()")
    public void aspe(JoinPoint joinPoint){
//        HttpServletRequest request = RequestContext.
        System.out.println("UserDto Was Called");
    }
}
