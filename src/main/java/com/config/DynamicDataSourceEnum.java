package com.config;

/**
 * @EnumName DynamicDataSourceEnum
 * @Description: TODO 多数据源枚举
 * @Author lxc
 * @Date 2020/2/8
 * @Version V1.0
 **/
//@Getter
public enum DynamicDataSourceEnum {

    MASTER("master"),
    SLAVE("slave");
    private String dataSourceName;
    DynamicDataSourceEnum(String dataSourceName) {
        this.dataSourceName = dataSourceName;
    }

    public String getDataSourceName() {
        return dataSourceName;
    }

    public void setDataSourceName(String dataSourceName) {
        this.dataSourceName = dataSourceName;
    }
}
