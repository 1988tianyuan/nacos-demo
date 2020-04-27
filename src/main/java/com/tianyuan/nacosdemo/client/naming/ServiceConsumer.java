package com.tianyuan.nacosdemo.client.naming;

import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingFactory;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.listener.Event;
import com.alibaba.nacos.api.naming.listener.EventListener;
import com.alibaba.nacos.api.naming.listener.NamingEvent;
import com.alibaba.nacos.api.naming.pojo.Instance;

import java.util.List;

public class ServiceConsumer {

    private static final String addr = "localhost:8848";

    public static void main(String[] args) throws NacosException, InterruptedException {
        String serviceName = "demo-service";
        NamingService namingService = NamingFactory.createNamingService(addr);
        final List<Instance> instanceList = namingService.getAllInstances(serviceName);
        System.out.println("现有的服务有：" + instanceList);

        namingService.subscribe(serviceName, new EventListener() {
            public void onEvent(Event event) {
                if (event instanceof NamingEvent) {
                    List<Instance> instances = ((NamingEvent)event).getInstances();
                    System.out.println("变化后的服务门：" + instances);
                }
            }
        });
        Thread.sleep(Long.MAX_VALUE);
    }
}
