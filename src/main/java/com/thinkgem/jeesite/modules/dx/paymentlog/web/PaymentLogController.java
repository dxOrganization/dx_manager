/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.dx.paymentlog.web;

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
import com.thinkgem.jeesite.modules.dx.paymentlog.entity.PaymentLog;
import com.thinkgem.jeesite.modules.dx.paymentlog.service.PaymentLogService;

/**
 * 会员消费记录Controller
 * @author mzh143
 * @version 2017-10-10
 */
@Controller
@RequestMapping(value = "${adminPath}/paymentlog/paymentLog")
public class PaymentLogController extends BaseController {

	@Autowired
	private PaymentLogService paymentLogService;
	
	@ModelAttribute
	public PaymentLog get(@RequestParam(required=false) String id) {
		PaymentLog entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = paymentLogService.get(id);
		}
		if (entity == null){
			entity = new PaymentLog();
		}
		return entity;
	}
	
	@RequiresPermissions("paymentlog:paymentLog:view")
	@RequestMapping(value = {"list", ""})
	public String list(PaymentLog paymentLog, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<PaymentLog> page = paymentLogService.findPage(new Page<PaymentLog>(request, response), paymentLog); 
		model.addAttribute("page", page);
		return "dx/paymentlog/paymentLogList";
	}

	@RequiresPermissions("paymentlog:paymentLog:view")
	@RequestMapping(value = "form")
	public String form(PaymentLog paymentLog, Model model) {
		model.addAttribute("paymentLog", paymentLog);
		return "dx/paymentlog/paymentLogForm";
	}

	@RequiresPermissions("paymentlog:paymentLog:edit")
	@RequestMapping(value = "save")
	public String save(PaymentLog paymentLog, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, paymentLog)){
			return form(paymentLog, model);
		}
		paymentLogService.save(paymentLog);
		addMessage(redirectAttributes, "保存会员消费记录成功");
		return "redirect:"+Global.getAdminPath()+"/paymentlog/paymentLog/?repage";
	}
	
	@RequiresPermissions("paymentlog:paymentLog:edit")
	@RequestMapping(value = "delete")
	public String delete(PaymentLog paymentLog, RedirectAttributes redirectAttributes) {
		paymentLogService.delete(paymentLog);
		addMessage(redirectAttributes, "删除会员消费记录成功");
		return "redirect:"+Global.getAdminPath()+"/paymentlog/paymentLog/?repage";
	}

}