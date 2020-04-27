package com.tianyuan.nacosdemo.spring;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.context.annotation.Configuration;

@NacosPropertySource(dataId = "demo", autoRefreshed = true)
@Configuration
public class NacosConfigs {
    @NacosValue(value = "${name:liugeng}", autoRefreshed = true)
    private String name;
    @NacosValue("${age:0}")
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
