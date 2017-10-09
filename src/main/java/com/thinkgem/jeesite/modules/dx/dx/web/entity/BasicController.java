/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.dx.dx.web.entity;

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
import com.thinkgem.jeesite.modules.dx.dx.entity.entity.Basic;
import com.thinkgem.jeesite.modules.dx.dx.service.entity.BasicService;

/**
 * 单表生成Controller
 * @author ThinkGem
 * @version 2017-10-09
 */
@Controller
@RequestMapping(value = "${adminPath}/dx/entity/basic")
public class BasicController extends BaseController {

	@Autowired
	private BasicService basicService;
	
	@ModelAttribute
	public Basic get(@RequestParam(required=false) String id) {
		Basic entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = basicService.get(id);
		}
		if (entity == null){
			entity = new Basic();
		}
		return entity;
	}
	
	@RequiresPermissions("dx:entity:basic:view")
	@RequestMapping(value = {"list", ""})
	public String list(Basic basic, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Basic> page = basicService.findPage(new Page<Basic>(request, response), basic); 
		model.addAttribute("page", page);
		return "dx/dx/entity/basicList";
	}

	@RequiresPermissions("dx:entity:basic:view")
	@RequestMapping(value = "form")
	public String form(Basic basic, Model model) {
		model.addAttribute("basic", basic);
		return "dx/dx/entity/basicForm";
	}

	@RequiresPermissions("dx:entity:basic:edit")
	@RequestMapping(value = "save")
	public String save(Basic basic, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, basic)){
			return form(basic, model);
		}
		basicService.save(basic);
		addMessage(redirectAttributes, "保存单表成功");
		return "redirect:"+Global.getAdminPath()+"/dx/entity/basic/?repage";
	}
	
	@RequiresPermissions("dx:entity:basic:edit")
	@RequestMapping(value = "delete")
	public String delete(Basic basic, RedirectAttributes redirectAttributes) {
		basicService.delete(basic);
		addMessage(redirectAttributes, "删除单表成功");
		return "redirect:"+Global.getAdminPath()+"/dx/entity/basic/?repage";
	}

}