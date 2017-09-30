package com.thinkgem.jeesite.modules.dx.portal.web;

import java.util.List;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.thinkgem.jeesite.modules.dx.room.entity.Room;
import com.thinkgem.jeesite.modules.dx.room.service.RoomService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring-context.xml"})
public class JunitTest {
	
	@Autowired
	private RoomService roomService;
	@Test
    public void test08(){
		for(int i=0;i<10;i++){
			Integer code=RandomUtils.nextInt(1000, 10000);
			System.out.println(code);
		}
		
    }
	@Test
	public void test(){
		Room room=new Room();
//		room.setStatus("1");
		List<Room> exrecords = roomService.findList(room);
		System.out.println(exrecords.size()+"==========");
	}

}
	
