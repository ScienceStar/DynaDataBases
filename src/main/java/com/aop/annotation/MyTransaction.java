package com.aop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.*;

/**
 * @ClassName MyTransaction
 * @Description: TODO 自定义回滚事物注解
 * @Author lxc
 * @Date 2020/7/20 12:45
 * @Version V1.0
 **/
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface MyTransaction {
    //指定异常回滚
    Class<? extends Throwable>[] rollbackFor() default {};
}
