/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.dx.complaint.web;

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
import com.thinkgem.jeesite.modules.dx.complaint.entity.Complaint;
import com.thinkgem.jeesite.modules.dx.complaint.service.ComplaintService;

/**
 * 会议投诉建议Controller
 * @author mzh143
 * @version 2017-10-10
 */
@Controller
@RequestMapping(value = "${adminPath}/complaint/complaint")
public class ComplaintController extends BaseController {

	@Autowired
	private ComplaintService complaintService;
	
	@ModelAttribute
	public Complaint get(@RequestParam(required=false) String id) {
		Complaint entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = complaintService.get(id);
		}
		if (entity == null){
			entity = new Complaint();
		}
		return entity;
	}
	
	@RequiresPermissions("complaint:complaint:view")
	@RequestMapping(value = {"list", ""})
	public String list(Complaint complaint, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Complaint> page = complaintService.findPage(new Page<Complaint>(request, response), complaint); 
		model.addAttribute("page", page);
		return "dx/complaint/complaintList";
	}

	@RequiresPermissions("complaint:complaint:view")
	@RequestMapping(value = "form")
	public String form(Complaint complaint, Model model) {
		model.addAttribute("complaint", complaint);
		return "dx/complaint/complaintForm";
	}

	@RequiresPermissions("complaint:complaint:edit")
	@RequestMapping(value = "save")
	public String save(Complaint complaint, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, complaint)){
			return form(complaint, model);
		}
		complaintService.save(complaint);
		addMessage(redirectAttributes, "保存会议投诉建议成功");
		return "redirect:"+Global.getAdminPath()+"/complaint/complaint/?repage";
	}
	
	@RequiresPermissions("complaint:complaint:edit")
	@RequestMapping(value = "delete")
	public String delete(Complaint complaint, RedirectAttributes redirectAttributes) {
		complaintService.delete(complaint);
		addMessage(redirectAttributes, "删除会议投诉建议成功");
		return "redirect:"+Global.getAdminPath()+"/complaint/complaint/?repage";
	}

}