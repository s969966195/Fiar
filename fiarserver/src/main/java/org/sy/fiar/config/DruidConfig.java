package org.sy.fiar.config;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.pool.DruidDataSource;
import com.google.common.collect.Lists;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * druid配置类
 *
 * @author SY
 * @since 2022/7/13 23:48
 */
@Configuration
public class DruidConfig {

    public DruidDataSource druid() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setProxyFilters(proxyFilters());
        return druidDataSource;
    }

    private List<Filter> proxyFilters(){
        //将自定义filter加入druid
        return Lists.newArrayList(new DruidTestFilter());
    }

}
