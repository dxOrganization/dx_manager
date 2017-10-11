package com.thinkgem.jeesite.modules.dx.webutils;


import com.thinkgem.jeesite.modules.dx.room.entity.Room;
import com.thinkgem.jeesite.modules.dx.room.service.RoomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IndexController {

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private RoomService roomService;

    @RequestMapping(value = "/${frontPath}/index/get_room_by_moduleid", method = RequestMethod.GET)
    public Object getRoomByModuleId() {
        Room room = new Room();
        room.setModuleId("1");
        List<Room> roomList = roomService.findList(room);
        return roomList;
    }

}
