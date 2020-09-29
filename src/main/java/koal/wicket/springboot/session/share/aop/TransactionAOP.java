package koal.wicket.springboot.session.share.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.sql.SQLException;


@Aspect
@Component
public class TransactionAOP  implements Serializable{
    private static final long serialVersionUID = 1772885188841025047L;

    /**
     * 定义切点
     */
    @Pointcut("@annotation(koal.wicket.springboot.session.share.aop.anotation.TransactionalSelf)")
    public void transactionPointCut() {
    }

    /**
     * 环绕通知，在方法执行前分配connection,在结束时释放connection
     * @param pjd
     * @throws SQLException
     * @throws Exception
     */
    @Around("transactionPointCut()")
    public Object doTransaction(ProceedingJoinPoint pjd) throws  Exception,Throwable {
        System.out.println("asdfasdfasdfasdfasdfasdf");
        return  pjd.proceed();
    }

}
