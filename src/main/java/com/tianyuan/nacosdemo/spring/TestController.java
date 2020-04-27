package com.tianyuan.nacosdemo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.MessageFormat;

@RestController
public class TestController {
    @Autowired
    private NacosConfigs configs;

    @GetMapping("/user")
    public String getUser() {
        return MessageFormat.format("name is {0}, age is {1}", configs.getName(), configs.getAge());
    }
}
