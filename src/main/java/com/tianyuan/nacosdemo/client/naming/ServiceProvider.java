package com.tianyuan.nacosdemo.client.naming;

import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingFactory;
import com.alibaba.nacos.api.naming.NamingService;

public class ServiceProvider {

    private static final String addr = "localhost:8848";

    public static void main(String[] args) throws NacosException, InterruptedException {
        NamingService namingService = NamingFactory.createNamingService(addr);
        namingService.registerInstance("demo-service", "127.0.0.1",
                Integer.parseInt(args[0]), "DEMO-CLUSTER");
        Thread.sleep(Long.MAX_VALUE);
    }
}
