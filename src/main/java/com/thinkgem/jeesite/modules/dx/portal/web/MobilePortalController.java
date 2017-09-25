package com.thinkgem.jeesite.modules.dx.portal.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thinkgem.jeesite.common.mapper.JsonMapper;
import com.thinkgem.jeesite.modules.dx.room.entity.Room;
import com.thinkgem.jeesite.modules.dx.room.service.RoomService;
/**
 * 移动端前后http交互后台
 * @author mzh14
 *
 */
@Controller
@RequestMapping(value = "${frontPath}/mobile")
public class MobilePortalController {

	@Autowired
	private RoomService roomService;
	/**
	 * 获取秀场直播间信息
	 * @param json
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/room",method = RequestMethod.GET)
	 public Map getRoom(@RequestParam(value = "json") String json) {
		 Map<String, Object> map = null;
	        try {
	            //由于浏览器会把中文直接换成ISO-8859-1编码格式,如果用户在地址打入中文,需要进行如下转换处理
	            String tempJson = "";
	            if(json != null){
	            	tempJson = new String(json.getBytes("ISO-8859-1"), "utf-8");
	            }
	            Room room = new Room();
	            room = JsonMapper.getInstance().fromJson(tempJson,Room.class);
	            List<Room> rooms = roomService.findList(room);
	            map = new HashMap<String, Object>();
	            map.put("data", JsonMapper.getInstance().toJsonString(rooms));//返回所有房间
	        } catch (Exception e) {
	        	e.printStackTrace();
	        	map = new HashMap<String, Object>();
	        	map.put("error", "400");//错误
	        }
		 return map;
	 }  
}
