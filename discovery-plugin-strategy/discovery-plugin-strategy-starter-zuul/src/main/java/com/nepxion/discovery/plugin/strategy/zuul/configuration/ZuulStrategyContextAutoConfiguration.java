package com.nepxion.discovery.plugin.strategy.zuul.configuration;

/**
 * <p>Title: Nepxion Discovery</p>
 * <p>Description: Nepxion Discovery</p>
 * <p>Copyright: Copyright (c) 2017-2050</p>
 * <p>Company: Nepxion</p>
 *
 * @author Haojun Ren
 * @version 1.0
 */

import com.nepxion.discovery.plugin.framework.adapter.DynamicRouteAdapter;
import com.nepxion.discovery.plugin.strategy.zuul.adapter.ZuulDynamicRouteAdapter;
import com.nepxion.discovery.plugin.strategy.zuul.context.ZuulStrategyContextHolder;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.cloud.netflix.ribbon.RibbonClientConfiguration;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AutoConfigureBefore(RibbonClientConfiguration.class)
public class ZuulStrategyContextAutoConfiguration {
    @Bean
    @ConditionalOnMissingBean
    public ZuulStrategyContextHolder zuulStrategyContextHolder() {
        return new ZuulStrategyContextHolder();
    }

    @Bean
    @ConditionalOnMissingBean
    public DynamicRouteAdapter zuulDynamicRouteAdapter(final ZuulProperties zuulProperties,
                                                       final ServerProperties serverProperties) {
        return new ZuulDynamicRouteAdapter(serverProperties.getServlet().getContextPath(), zuulProperties);
    }
}