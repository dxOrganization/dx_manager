/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.room.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.room.entity.Room;
import com.thinkgem.jeesite.modules.room.dao.RoomDao;

/**
 * 直播间Service
 * @author mzh143
 * @version 2017-09-24
 */
@Service
@Transactional(readOnly = true)
public class RoomService extends CrudService<RoomDao, Room> {

	public Room get(String id) {
		return super.get(id);
	}
	
	public List<Room> findList(Room room) {
		return super.findList(room);
	}
	
	public Page<Room> findPage(Page<Room> page, Room room) {
		return super.findPage(page, room);
	}
	
	@Transactional(readOnly = false)
	public void save(Room room) {
		super.save(room);
	}
	
	@Transactional(readOnly = false)
	public void delete(Room room) {
		super.delete(room);
	}
	
}