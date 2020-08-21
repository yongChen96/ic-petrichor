package com.example.security.security;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: IgnoreUrlsConfig
 * @Description: 用于配置白名单资源路径
 * @Author: yongchen
 * @Date: 2020/8/14 10:52
 **/
@Data
@ConfigurationProperties(prefix = "secure.ignored")
public class IgnoreUrlsConfig {

    private List<String> urls = new ArrayList<>();
}
