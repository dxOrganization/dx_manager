/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.dx.channel.web;

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
import com.thinkgem.jeesite.modules.dx.channel.entity.Channel;
import com.thinkgem.jeesite.modules.dx.channel.service.ChannelService;

/**
 * 渠道信息Controller
 * @author mzh143
 * @version 2017-10-09
 */
@Controller
@RequestMapping(value = "${adminPath}/channel/channel")
public class ChannelController extends BaseController {

	@Autowired
	private ChannelService channelService;
	
	@ModelAttribute
	public Channel get(@RequestParam(required=false) String id) {
		Channel entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = channelService.get(id);
		}
		if (entity == null){
			entity = new Channel();
		}
		return entity;
	}
	
	@RequiresPermissions("channel:channel:view")
	@RequestMapping(value = {"list", ""})
	public String list(Channel channel, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Channel> page = channelService.findPage(new Page<Channel>(request, response), channel); 
		model.addAttribute("page", page);
		return "dx/channel/channelList";
	}

	@RequiresPermissions("channel:channel:view")
	@RequestMapping(value = "form")
	public String form(Channel channel, Model model) {
		model.addAttribute("channel", channel);
		return "dx/channel/channelForm";
	}

	@RequiresPermissions("channel:channel:edit")
	@RequestMapping(value = "save")
	public String save(Channel channel, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, channel)){
			return form(channel, model);
		}
		channelService.save(channel);
		addMessage(redirectAttributes, "保存渠道信息成功");
		return "redirect:"+Global.getAdminPath()+"/channel/channel/?repage";
	}
	
	@RequiresPermissions("channel:channel:edit")
	@RequestMapping(value = "delete")
	public String delete(Channel channel, RedirectAttributes redirectAttributes) {
		channelService.delete(channel);
		addMessage(redirectAttributes, "删除渠道信息成功");
		return "redirect:"+Global.getAdminPath()+"/channel/channel/?repage";
	}

}