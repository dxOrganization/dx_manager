/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.dx.memeber.web;

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
import com.thinkgem.jeesite.modules.dx.memeber.entity.Memeber;
import com.thinkgem.jeesite.modules.dx.memeber.service.MemeberService;

/**
 * 会员信息Controller
 * @author mzh143
 * @version 2017-09-25
 */
@Controller
@RequestMapping(value = "${adminPath}/memeber/memeber")
public class MemeberController extends BaseController {

	@Autowired
	private MemeberService memeberService;
	
	@ModelAttribute
	public Memeber get(@RequestParam(required=false) String id) {
		Memeber entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = memeberService.get(id);
		}
		if (entity == null){
			entity = new Memeber();
		}
		return entity;
	}
	
	@RequiresPermissions("memeber:memeber:view")
	@RequestMapping(value = {"list", ""})
	public String list(Memeber memeber, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Memeber> page = memeberService.findPage(new Page<Memeber>(request, response), memeber); 
		model.addAttribute("page", page);
		return "dx/memeber/memeberList";
	}

	@RequiresPermissions("memeber:memeber:view")
	@RequestMapping(value = "form")
	public String form(Memeber memeber, Model model) {
		model.addAttribute("memeber", memeber);
		return "dx/memeber/memeberForm";
	}

	@RequiresPermissions("memeber:memeber:edit")
	@RequestMapping(value = "save")
	public String save(Memeber memeber, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, memeber)){
			return form(memeber, model);
		}
		memeberService.save(memeber);
		addMessage(redirectAttributes, "保存会员信息成功");
		return "redirect:"+Global.getAdminPath()+"/memeber/memeber/?repage";
	}
	
	@RequiresPermissions("memeber:memeber:edit")
	@RequestMapping(value = "delete")
	public String delete(Memeber memeber, RedirectAttributes redirectAttributes) {
		memeberService.delete(memeber);
		addMessage(redirectAttributes, "删除会员信息成功");
		return "redirect:"+Global.getAdminPath()+"/memeber/memeber/?repage";
	}

}