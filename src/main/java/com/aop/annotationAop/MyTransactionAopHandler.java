package com.aop.annotationAop;

import com.aop.annotation.MyTransaction;
import com.aop.holder.DataSourceConnectHolder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.sql.SQLException;

/**
 * @ClassName MyTransactionAopHandler
 * @Description: TODO 这部分是事务处理的核心，先获取注解上的异常类，然后捕获住执行的异常，判断异常是不是注解上的异常或者其子类，如果是就回滚，否则就提交。
 * @Author lxc
 * @Date 2020/7/20 12:54
 * @Version V1.0
 **/
@Aspect
@Component
public class MyTransactionAopHandler {
    @Autowired DataSourceConnectHolder connectHolder;
    Class<? extends Throwable>[] es;

    //拦截所有MyTransaction注解的方法
    @org.aspectj.lang.annotation.Pointcut("@annotation(com.aop.annotation.MyTransaction)")
    public void Transaction() {

    }

    @Around("Transaction()")
    public Object TransactionProceed(ProceedingJoinPoint proceed) throws Throwable {
        Object result = null;
        Signature signature = proceed.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        if (method == null) {
            return result;
        }
        MyTransaction transaction = method.getAnnotation(MyTransaction.class);
        if (transaction != null) {
            es = transaction.rollbackFor();
        }
        try {
            result = proceed.proceed();
        } catch (Throwable throwable) {
            //异常处理
            completeTransactionAfterThrowing(throwable);
            throw throwable;
        }
        //直接提交
        doCommit();
        return result;
    }

    /**
     * 执行回滚，最后关闭连接和清理线程绑定
     */
    private void doRollBack() {
        try {
            connectHolder.getConnection().rollback();
        } catch (ArithmeticException | SQLException e) {
            e.printStackTrace();
        } finally {
            connectHolder.cleanHolder();
        }

    }

    /**
     * 执行提交，最后关闭连接和清理线程绑定
     */
    private void doCommit() {
        try {
            connectHolder.getConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectHolder.cleanHolder();
        }
    }

    /**
     * 异常处理，捕获的异常是目标异常或者其子类，就进行回滚，否则就提交事务。
     */
    private void completeTransactionAfterThrowing(Throwable throwable) {
        if (es != null && es.length > 0) {
            for (Class<? extends Throwable> e : es) {
                if (e.isAssignableFrom(throwable.getClass())) {
                    doRollBack();
                }
            }
        }
        doCommit();
    }
}
