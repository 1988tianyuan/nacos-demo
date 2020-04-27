package com.tianyuan.nacosdemo.client.config;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;

import java.util.Properties;
import java.util.concurrent.Executor;

public class ConfigConsumer {

    private final String addr;

    public ConfigConsumer(String addr) {
        this.addr = addr;
    }

    public void subscribeConfig(String dataId, String group) {
        Properties properties = new Properties();
        properties.put("serverAddr", addr);
        try {
            ConfigService configService = NacosFactory.createConfigService(properties);
            String content = configService.getConfig(dataId, group, 5000);
            System.out.println("config是：" + content);
            configService.addListener(dataId, group, new Listener() {
                public Executor getExecutor() {
                    return null;
                }
                public void receiveConfigInfo(String configInfo) {
                    System.out.println("配置变化了，变成了：" + configInfo);
                }
            });
        } catch (NacosException e) {
            e.printStackTrace();
        }
    }
}
