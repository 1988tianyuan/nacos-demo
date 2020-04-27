package com.tianyuan.nacosdemo.client.config;

public class TestPublish {

    private static final String addr = "localhost:8848";

    public static void main(String[] args) {
        String dataId = "demo-config";
        String group = "demo-group";
        ConfigPublisher publisher = new ConfigPublisher(addr);
        String content = "demo.name=nono, it's not liugeng's demo";
        publisher.publishConfig(dataId, group, content);
    }
}
