package com.thinkgem.jeesite.test.service;

import com.thinkgem.jeesite.modules.dx.module.service.ModuleService;
import com.thinkgem.jeesite.modules.dx.room.entity.Room;
import com.thinkgem.jeesite.modules.dx.room.service.RoomService;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring-context.xml"})
public class ServiceTest {

    @Autowired
    private RoomService roomService;

    @Autowired
    private ModuleService moduleService;
    @Test
    public void test08(){
        System.out.println("1111111-------- " + moduleService.toString());
        for(int i=0;i<10;i++){
            Integer code= RandomUtils.nextInt(1000, 10000);
            System.out.println(code);
        }

    }
    @Test
    public void aa(){
        Room room=new Room();
//		room.setStatus("1");
        List<Room> exrecords = roomService.findList(room);
        System.out.println(exrecords.size()+"==========");
    }
}
