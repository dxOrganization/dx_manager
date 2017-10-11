package com.thinkgem.jeesite.test.service;

import com.thinkgem.jeesite.common.persistence.Page;
<<<<<<< Updated upstream
<<<<<<< Updated upstream
=======
import com.thinkgem.jeesite.modules.act.utils.DateConverter;
>>>>>>> Stashed changes
=======
import com.thinkgem.jeesite.modules.act.utils.DateConverter;
>>>>>>> Stashed changes
import com.thinkgem.jeesite.modules.dx.module.entity.Module;
import com.thinkgem.jeesite.modules.dx.module.service.ModuleService;
import com.thinkgem.jeesite.modules.dx.room.entity.Room;
import com.thinkgem.jeesite.modules.dx.room.service.RoomService;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring-context.xml"})
public class ServiceTest {

    private static final Logger logger = LoggerFactory.getLogger(ServiceTest.class);

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
    public void getModule(){
        Module module = new Module();
        List<Module> modules = moduleService.findList(module);
        for (Module m : modules) {
            logger.info(m.getModuleName()+"==========");
        }
    }

    @Test
    public void getRoomByModuleId() {
        Room room = new Room();
<<<<<<< Updated upstream
<<<<<<< Updated upstream
        room.setModuleId("1");
=======
        room.setModuleId(2L);
>>>>>>> Stashed changes
=======
        room.setModuleId(2L);
>>>>>>> Stashed changes
        List<Room> roomList = roomService.findList(room);
        for (Room r : roomList) {
            logger.info(r.getRoomName() + "----------->");
        }
    }

    @Test
    public void getRoomPageByModuleId() {
        Room room = new Room();
<<<<<<< Updated upstream
<<<<<<< Updated upstream
        room.setModuleId("3");
=======
        room.setModuleId(1L);
>>>>>>> Stashed changes
=======
        room.setModuleId(1L);
>>>>>>> Stashed changes
        List<Room> roomList = roomService.findList(room);

        Page<Room> roomPage = new Page<>(3,6);
        roomPage.setCount(roomList.size());

        Page<Room> page = roomService.findPage(roomPage, room);
        logger.info("当前页内容数量----------->> " + page.getList().size());
        logger.info("共多少页----------->> " + page.getTotalPage());
        for (Room m : page.getList()) {
            logger.info("当前第" + page.getPageNo() + "页，房间名称是： " + m.getRoomName());
        }
    }
}
