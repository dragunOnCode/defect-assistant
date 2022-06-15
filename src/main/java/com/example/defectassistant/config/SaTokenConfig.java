package com.example.defectassistant.config;

import cn.dev33.satoken.reactor.context.SaReactorSyncHolder;
import cn.dev33.satoken.reactor.filter.SaReactorFilter;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.ServerWebExchange;

import javax.annotation.Resource;
import java.util.Collections;

@Configuration
public class SaTokenConfig {

    /**
     * 配置白名单
     */
    @Resource
    private IgnoreUrlsConfig ignoreUrlsConfig;

    /**
     * 注册Sa-Token全局过滤器
     */
    @Bean
    public SaReactorFilter getSaReactorFilter() {
        return new SaReactorFilter()
                // 拦截地址
                .addInclude("/**")
                // 开放地址
                .addExclude("/favicon.ico")
                .addExclude("/ds/test/**")
                // 鉴权方法：每次访问进入
                .setAuth(r -> {
                    // 登录认证：除登录接口都需要认证
                    //SaRouter.match("/**", "/auth/user/login", StpUtil::checkLogin);
                    SaRouter.match(Collections.singletonList("/**"), ignoreUrlsConfig.getUrls(), StpUtil::checkLogin);
                    // 权限认证：不同接口访问权限不同
                    SaRouter.match("/user", () -> StpUtil.checkRole("ROLE_USER"));
                    SaRouter.match("/admin", () -> StpUtil.checkRole("ROLE_ADMIN"));
                })
                // setAuth方法异常处理
                .setError(e -> {
                    //设置错误返回格式为JSON
                    ServerWebExchange exchange = SaReactorSyncHolder.getContent();
                    exchange.getResponse().getHeaders().set("Content-Type", "application/json; charset=utf-8");
                    return SaResult.error(e.getMessage());
                });
    }
}


