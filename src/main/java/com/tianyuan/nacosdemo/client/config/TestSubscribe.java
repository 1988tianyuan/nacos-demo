package com.tianyuan.nacosdemo.client.config;

public class TestSubscribe {

    private static final String addr = "localhost:8848";

    public static void main(String[] args) throws InterruptedException {
        String dataId = "demo-config";
        String group = "demo-group";
        ConfigConsumer consumer = new ConfigConsumer(addr);
        consumer.subscribeConfig(dataId, group);
        Thread.sleep(Long.MAX_VALUE);
    }
}
