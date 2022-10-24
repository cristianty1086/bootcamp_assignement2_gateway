package com.nttdata.bootcamp.assignement2.ntscgateway.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

@Component
public class SCWGlobalFilter extends AbstractGatewayFilterFactory<SCWGlobalFilter.Config> {

    Logger logger = LoggerFactory.getLogger(SCWGlobalFilter.class);

    public SCWGlobalFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        logger.info("Inside SCWGlobalFilter apply");

        return (exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest()
                    .mutate().header("scgw-pre-header", Math.random()*100+"").build();
            return chain.filter(exchange.mutate().request(request).build());
        };
    }

    public static class Config {
        private String name;

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
