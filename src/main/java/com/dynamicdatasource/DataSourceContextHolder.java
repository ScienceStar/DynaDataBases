package com.dynamicdatasource;

/**
 * @ClassName DataSourceContextHolder
 * @Description: TODO 数据源路由
 * @Author lxc
 * @Date 2020/2/8
 * @Version V1.0
 **/
public class DataSourceContextHolder {

    private static final ThreadLocal<String> DYNAMIC_DATASOURCE_CONTEXT = new ThreadLocal<String>();
    public static void set(String datasourceType) {
        DYNAMIC_DATASOURCE_CONTEXT.set(datasourceType);
    }
    public static String get() {
        return DYNAMIC_DATASOURCE_CONTEXT.get();
    }
    public static void clear() {
        DYNAMIC_DATASOURCE_CONTEXT.remove();
    }
}
