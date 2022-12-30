package com.rtrs.cloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
    /***
     * 这个是和yml 文件中实现同样效果的配置 只是使用了java代码实现
     * 相较于yml而言 这个java代码的实现现得更加的臃肿
     * @param builder
     * @return
     */
    @Bean
    public RouteLocator customerRouterLocator(RouteLocatorBuilder builder){
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("path_route",
                r-> r.path("/guonei")
                        .uri("http://news.baidu.com/guonei")).build();
        return routes.build();
    }
}
