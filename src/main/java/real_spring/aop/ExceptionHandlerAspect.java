package real_spring.aop;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import real_spring.aop.business.DBException;

import java.util.Map;
import java.util.WeakHashMap;

@Aspect
public class ExceptionHandlerAspect {

    @Value("${dba}")
    private String[] mails;

    private Map<DBException,Void> exceptions = new WeakHashMap<>();

    @Pointcut("execution(* real_spring.aop.business..*.*(..))")
    public void allBusinessMethods(){}

    @AfterThrowing(value = "allBusinessMethods()",throwing = "ex")
    public void handleDBException(DBException ex){
        if(!exceptions.containsKey(ex)){
            exceptions.put(ex,null);
            for (String mail : mails) {
                System.out.println("mail sent to "+mail);
                System.out.println(ex.getMessage());
            }
        }
    }
}
