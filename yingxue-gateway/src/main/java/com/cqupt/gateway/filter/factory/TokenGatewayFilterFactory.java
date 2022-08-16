package com.cqupt.gateway.filter.factory;

import com.cqupt.constants.RedisPrefix;
import com.cqupt.exceptions.IllegalTokenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

/**
 * 自定义token工厂
 *
 * @Component 代表在工厂中创建对象   @configuration 配置     @Component  在工厂中创建对象
 */
@Component
public class TokenGatewayFilterFactory extends AbstractGatewayFilterFactory<TokenGatewayFilterFactory.Config> {
    private RedisTemplate redisTemplate;

    @Autowired
    public TokenGatewayFilterFactory(RedisTemplate redisTemplate) {
        super(Config.class);
        this.redisTemplate = redisTemplate;
    }



    //Config 参数就是基于当前中Config创建对象
    @Override
    public GatewayFilter apply(Config config) {
        /*
         * servlet的service的参数： 1. httpServletRequest  2. httpServletResponse (传统web springmvc)
         * exchange 是springwebflux 是一种新的web模型
         * filter的参数： 1. request 2. response 3. filterChain.dofilter(request,response)
         */
        return new GatewayFilter() {
            @Override
            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
                if(config.requiredToken) {
                    MultiValueMap<String, String> queryParams = exchange.getRequest().getQueryParams();
                    if (queryParams.get("token") == null) {
                        throw new IllegalTokenException("未知token");
                    }
                    //1.获取token信息
                    String token = queryParams.get("token").get(0);
                    System.out.println(token);
                    //2.根据token信息去redis获取
                    if (!redisTemplate.hasKey(RedisPrefix.TOKEN_KEY + token)) {
                        throw new IllegalTokenException("不合法的token");
                    }
                }
                return chain.filter(exchange);
            }
        };
    }

    /**
     * 用来配置将来使用filter时指定值赋值给Config中哪个属性
     * 当有多个属性的时候，按顺序填写即可
     */
    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("requiredToken", "name");
    }

    /**
     * 自定义配置类
     * 有两个属性是做范例, 当有多个属性的时候怎么赋值
     */
    public static class Config {
        /**
         * 默认值:false
         */
        private boolean requiredToken;
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isRequiredToken() {
            return requiredToken;
        }

        public void setRequiredToken(boolean requiredToken) {
            this.requiredToken = requiredToken;
        }
    }
}


















