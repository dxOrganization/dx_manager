/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.dx.module.web;

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
import com.thinkgem.jeesite.modules.dx.module.entity.Module;
import com.thinkgem.jeesite.modules.dx.module.service.ModuleService;

/**
 * 版块信息维护Controller
 * @author mzh143
 * @version 2017-09-25
 */
@Controller
@RequestMapping(value = "${adminPath}/module/module")
public class ModuleController extends BaseController {

	@Autowired
	private ModuleService moduleService;
	
	@ModelAttribute
	public Module get(@RequestParam(required=false) String id) {
		Module entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = moduleService.get(id);
		}
		if (entity == null){
			entity = new Module();
		}
		return entity;
	}
	
	@RequiresPermissions("module:module:view")
	@RequestMapping(value = {"list", ""})
	public String list(Module module, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Module> page = moduleService.findPage(new Page<Module>(request, response), module); 
		model.addAttribute("page", page);
		return "dx/module/moduleList";
	}

	@RequiresPermissions("module:module:view")
	@RequestMapping(value = "form")
	public String form(Module module, Model model) {
		model.addAttribute("module", module);
		return "dx/module/moduleForm";
	}

	@RequiresPermissions("module:module:edit")
	@RequestMapping(value = "save")
	public String save(Module module, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, module)){
			return form(module, model);
		}
		moduleService.save(module);
		addMessage(redirectAttributes, "保存版块信息维护成功");
		return "redirect:"+Global.getAdminPath()+"/module/module/?repage";
	}
	
	@RequiresPermissions("module:module:edit")
	@RequestMapping(value = "delete")
	public String delete(Module module, RedirectAttributes redirectAttributes) {
		moduleService.delete(module);
		addMessage(redirectAttributes, "删除版块信息维护成功");
		return "redirect:"+Global.getAdminPath()+"/module/module/?repage";
	}

}