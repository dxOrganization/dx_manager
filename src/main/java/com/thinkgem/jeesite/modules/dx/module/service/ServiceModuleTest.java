package com.thinkgem.jeesite.modules.dx.module.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
// 使用junit4进行测试
@ContextConfiguration({ "/spring-*.xml","/mybatis-*.xml" })
// 加载配置文件
public class ServiceModuleTest {

    @Test
    public void aaa() {
        System.out.println("ceshi......");
    }

    @Test
    public void getModule() {
//        System.out.println("11111-----" + super.getClass().toString());
//        Module module = new Module();
//        List<Module> list =  moduleService.findList(module);
//        for (Module m : list) {
//            System.out.println(m.getModuleName());
//        }
    }
}
