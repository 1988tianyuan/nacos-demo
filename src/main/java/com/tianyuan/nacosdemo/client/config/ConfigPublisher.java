package com.tianyuan.nacosdemo.client.config;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;

import java.util.Properties;

public class ConfigPublisher {

    private final String addr;

    public ConfigPublisher(String addr) {
        this.addr = addr;
    }

    public void publishConfig(String dataId, String group, String content) {
        Properties properties = new Properties();
        properties.put("serverAddr", addr);
        try {
            ConfigService configService = NacosFactory.createConfigService(properties);
            boolean result = configService.publishConfig(dataId, group, content);
            if (result) {
                System.out.println("成功发布配置");
            } else {
                System.out.println("未成功发布配置");
            }
        } catch (NacosException e) {
            e.printStackTrace();
        }
    }
}
