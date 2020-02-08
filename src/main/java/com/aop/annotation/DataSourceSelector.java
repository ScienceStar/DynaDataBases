package com.aop.annotation;

import com.config.DynamicDataSourceEnum;

import java.lang.annotation.*;

/**
 * @AnnotationName DataSourceSelector
 * @Description: TODO 数据源切换
 * @Author lxc
 * @Date 2020/2/8
 * @Version V1.0
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface DataSourceSelector {
    DynamicDataSourceEnum value() default DynamicDataSourceEnum.MASTER;
    boolean clear() default true;
}
