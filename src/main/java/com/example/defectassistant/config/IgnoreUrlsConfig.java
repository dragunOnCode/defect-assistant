package com.example.defectassistant.config;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 网关白名单配置
 * Created by macro on 2020/6/17.
 */
@ConfigurationProperties(prefix="secure.ignore")
@Data
@EqualsAndHashCode(callSuper = false)
@Component
public class IgnoreUrlsConfig {
    private List<String> urls;
}

