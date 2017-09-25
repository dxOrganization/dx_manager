/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.dx.room.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.dx.room.entity.Room;
import com.thinkgem.jeesite.modules.dx.room.service.RoomService;

/**
 * 直播间Controller
 * @author mzh143
 * @version 2017-09-25
 */
@Controller
@RequestMapping(value = "${adminPath}/room/room")
public class RoomController extends BaseController {

	@Autowired
	private RoomService roomService;
	
	@ModelAttribute
	public Room get(@RequestParam(required=false) String id) {
		Room entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = roomService.get(id);
		}
		if (entity == null){
			entity = new Room();
		}
		return entity;
	}
	
	@RequiresPermissions("room:room:view")
	@RequestMapping(value = {"list", ""})
	public String list(Room room, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Room> page = roomService.findPage(new Page<Room>(request, response), room); 
		model.addAttribute("page", page);
		return "dx/room/roomList";
	}

	@RequiresPermissions("room:room:view")
	@RequestMapping(value = "form")
	public String form(Room room, Model model) {
		model.addAttribute("room", room);
		return "dx/room/roomForm";
	}

	@RequiresPermissions("room:room:edit")
	@RequestMapping(value = "save")
	public String save(Room room, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, room)){
			return form(room, model);
		}
		roomService.save(room);
		addMessage(redirectAttributes, "保存直播间成功");
		return "redirect:"+Global.getAdminPath()+"/room/room/?repage";
	}
	
	@RequiresPermissions("room:room:edit")
	@RequestMapping(value = "delete")
	public String delete(Room room, RedirectAttributes redirectAttributes) {
		roomService.delete(room);
		addMessage(redirectAttributes, "删除直播间成功");
		return "redirect:"+Global.getAdminPath()+"/room/room/?repage";
	}

}